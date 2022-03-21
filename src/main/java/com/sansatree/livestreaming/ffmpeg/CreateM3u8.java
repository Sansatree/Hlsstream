package com.sansatree.livestreaming.ffmpeg;

import com.sansatree.livestreaming.controller.FilePath;
import lombok.extern.slf4j.Slf4j;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import org.springframework.stereotype.Service;


import java.io.IOException;


@Slf4j
@Service
public class CreateM3u8{
    FilePath pathConfig = new FilePath();
    FFmpeg fFmpeg = new FFmpeg(pathConfig.getFfmpegPath() +"\\ffmpeg");
    FFprobe fFprobe = new FFprobe(pathConfig.getFfmpegPath() + "\\ffprobe");
    FFmpegExecutor executor = new FFmpegExecutor(fFmpeg,fFprobe);

    // 이미 녹화된 mp4 파일을 스트리밍
    public Object encodeTs(){
        FFmpegBuilder builder = new FFmpegBuilder()
                .setInput(pathConfig.getFilePath() + "\\" + pathConfig.getVideoName() + ".mp4")
                .addOutput(pathConfig.getFilePath()+ "\\" + pathConfig.getVideoName() + ".m3u8")
                .setAudioCodec("copy")
                .addExtraArgs("-profile:v", "baseline")
                .addExtraArgs("-level", "3.0")
                .addExtraArgs("-start_number", "0")
                .addExtraArgs("-hls_time", "10")
                .addExtraArgs("-hls_list_size", "0")
                .addExtraArgs("-f", "hls")
                .done();

        executor.createJob(builder).run();
        log.info("================= acc ==============");

        return builder;
    }

    /**
     * 로컬카메라로 녹화
     * encode h264,aac
     */
    public Object videoEncode(){
        FFmpegBuilder builder = new FFmpegBuilder()
                .addExtraArgs("-rtbufsize", "15M")// 버퍼사이즈 수정
                .addExtraArgs("-re")
                .setFormat("dshow")
                .addInput("video=\"WebCam\":audio=\"Microphone\"")
                .addOutput(pathConfig.getFfmpegOutputPath() + "\\" + pathConfig.getVideoName() + ".mp4")
                .setVideoCodec("libx264") // x264는 cpu 사용, h.264는 Gpu 사용
                .addExtraArgs("-bufsize", "4000k")  //버퍼사이즈 수정
                .addExtraArgs("-minrate", "1000k") //minrate???
                .addExtraArgs("-maxrate", "1000k") //비트레이트 수정 ??minrate는 왜 없을까??
                .setAudioCodec("aac") // 오디오 코덱?? aac??
                .setAudioSampleRate(FFmpeg.AUDIO_SAMPLE_44100) //오디오 표준 sample rate 값(44.1khz)
                .setAudioBitRate(1_000_000)  // 오디오 비트레이트 128K로 수정
                .addExtraArgs("-profile:v", "baseline")
                .setVideoPixelFormat("yuv420p") // 지정해야 하나???
                .setVideoResolution(426, 240) // videosize (-s)
                .setVideoBitRate(2_000_000)
                .setVideoFrameRate(30)  // 내 노트북은 30프레임까지만 가능 video frame rate (-r)
                .addExtraArgs("-preset", "medium")
                .addExtraArgs("-f","flv")
//                .addExtraArgs(pathConfig.getFfmpegOutputPath() + "\\" + pathConfig.getVideoName() + ".mp4")
                .addExtraArgs("rtmp://sstree@172.30.85.109:1935/live")
                .done();
        executor.createJob(builder).run();
        return builder;
    }

//    /**
//     * rtmp로 인코딩 전송
//     */
//    public Object rtmpStream(){
//        FFmpegBuilder builder = new FFmpegBuilder()
//
//    }

    //녹화와 동시에 스트리밍
    public Object localCamera(){
        FFmpegBuilder builder =  new FFmpegBuilder()
                .addExtraArgs("-rtbufsize", "10M")// 버퍼사이즈 수정
                .addExtraArgs("-re")
                .setFormat("dshow")
                .addInput("video=\"WebCam\":audio=\"Microphone\"")
                .addOutput(pathConfig.getFilePath()+ "\\" + pathConfig.getVideoName() + ".m3u8")// 수정 (저장위치)

                .setFormat("mp4")
                .addExtraArgs("-bufsize", "4000k")  //버퍼사이즈 수정
                .addExtraArgs("-minrate", "1000k") //minrate???
                .addExtraArgs("-maxrate", "1000k") //비트레이트 수정 ??minrate는 왜 없을까??
                .addExtraArgs("-t","30") //30초만 녹음


                .setAudioCodec("aac") // 오디오 코덱?? aac??
                .setAudioSampleRate(FFmpeg.AUDIO_SAMPLE_44100) //오디오 표준 sample rate 값(44.1khz)
                .setAudioBitRate(1_000_000)  // 오디오 비트레이트 128K로 수정

                .addExtraArgs("-profile:v", "baseline")
                .setVideoCodec("libx264") // x264는 cpu 사용, h.264는 Gpu 사용
                .setVideoPixelFormat("yuv420p") // 지정해야 하나???????????????
                .setVideoResolution(426, 240) // videosize (-s)
                .setVideoBitRate(2_000_000)
                .setVideoFrameRate(30)  // 내 노트북은 30프레임까지만 가능 video frame rate (-r)
                .addExtraArgs("-preset", "medium")
                .addExtraArgs("-g", "30") // -g는 gop(group of pictures)
                .addExtraArgs("-start_number", "0") //ts파일 시작 번호
                .addExtraArgs("-hls_time","8") //ts 파일 길이
                .addExtraArgs("-hls_list_size","0") //.m3u8에 포함할 .ts 파일 리스트의 길이를 설정 (0은 모두 저장)
//                .addExtraArgs("-hls_delete_threshold","2") //.m3u8에 포함되지 않은 segment를 2개까지 허용.
//                .addExtraArgs("-hls_flags","delete_segments") //오래된 segment 삭제
                .addExtraArgs("-f", "hls") //출력 형식 hls

                .done();
        executor.createJob(builder).run();
        return builder;
    }


    /**
     * m3u8 -> mp4
     * @throws IOException
     */
    public Object m3u8ToMp4(){
        //ffmpeg -i "C:\ffmpeg\bin\testvideo.m3u8" -c copy -bsf:a aac_adtstoasc "aa.mp4"
        FFmpegBuilder builder = new FFmpegBuilder()
                .addInput(pathConfig.getFfmpegOutputPath() + "\\" + pathConfig.getPlayListName())
                .addOutput(pathConfig.getFfmpegOutputPath() + "\\" + pathConfig.getVideoName() + ".mp4")
                .addExtraArgs("-c","copy")
                .addExtraArgs("-bsf:a","aac_adtstoasc")
                .done();
        executor.createJob(builder).run();
        return builder;
    }


    public CreateM3u8() throws IOException {
    }


}


