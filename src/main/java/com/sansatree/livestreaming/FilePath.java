package com.sansatree.livestreaming;

import lombok.Getter;
import org.springframework.stereotype.Component;


@Getter
@Component
public class FilePath {
    String filePath = "C:\\ffmpeg\\bin"; //비디오 파일 경로

    String videoName = "testvideo"; //비디오 파일 이름

    String playListPath = "C:\\ffmpeg\\bin"; //.m3u8 경로

    String playListName = videoName + ".m3u8"; //.m3u8 이름
    String tsFilePath = "C:\\ffmpeg\\bin"; //.ts 파일 경로
    String tsFileName ; //.ts 파일 이름

    String ffmpegPath = "C:\\ffmpeg\\bin";  //ffmpeg.exe, ffprobe.exe 경로

    String ffmpegOutputPath = "C:\\ffmpeg\\bin"; //ffmpeg 으로 만들 파일 경로
}
