//package com.sansatree.livestreaming.ffmpeg;
//
//import com.sansatree.livestreaming.FilePath;
//import net.bramp.ffmpeg.FFmpeg;
//import net.bramp.ffmpeg.FFmpegExecutor;
//import net.bramp.ffmpeg.FFprobe;
//import net.bramp.ffmpeg.builder.FFmpegBuilder;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//
//
////@RequiredArgsConstructor
//@Service
//public class BrampFfmpegCommandSupplier{
//    FilePath pathConfig = new FilePath();
////    private final FFmpeg fFmpeg;
////    private final FFprobe fFprobe;
////    private final FFmpegExecutor executor;
//
//    FFmpeg fFmpeg = new FFmpeg(pathConfig.getFfmpegPath());
//    FFprobe fFprobe = new FFprobe(pathConfig.getFfmpegPath());
////    FFmpegExecutor executor = new FFmpegExecutor(fFmpeg,fFprobe);
//
//    public BrampFfmpegCommandSupplier(FilePath pathConfig) throws IOException {
//        this.pathConfig = pathConfig;
////        this.executor = executor;
//    }
//
//
////    //config 파일로 빼거나 properties에 정의해서 @Value 활용 고민해보기
////    private static final String inputPath = "C:\\ffmpeg\\bin";
////    private static final String videoName = "testvideo";
////    private static final String videoFilePath = "C:\\videos" + "\\" + videoName;
////    private static final String ts_path = inputPath + "\\" + "";
////    private static final String m3u8_path = inputPath + "\\" + videoName + ".m3u8";
////    private static final String uploadPath = "";
//
//
//    public void encodeAudio() {
//        FFmpegBuilder builder = (FFmpegBuilder) new FFmpegBuilder()
//                .setInput(pathConfig.getFilePath()) //동영상 파일
//                .overrideOutputFiles(true) //오버라이드 여부(true시 묻지 않고 덮어쓰기)
//                .addOutput(pathConfig.getFfmpegOutputPath()) //저장경로
//                .setAudioCodec("aac")
//                .setAudioBitRate(128000)
//                .done().build();
////        executor.createJob(builder).run();
//    }
//
//    public void encodeTs(){
//        FFmpegBuilder builder = new FFmpegBuilder()
//                .setInput(pathConfig.getFilePath())
//                .addOutput(pathConfig.getFilePath())
//                .setAudioCodec("copy")
//                .addExtraArgs("-hls_list_sie", "0")
//                .addExtraArgs("-hls_time", "9")
//                .addExtraArgs("-start_number","0")
//                .addExtraArgs("-hls_playlist_type", "event")
//                .addExtraArgs("-hls_flags", "append_list")
//                .done();
////        executor.createJob(builder).run();
//
//    }
//
//
//
//}
