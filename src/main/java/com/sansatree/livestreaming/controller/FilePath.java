package com.sansatree.livestreaming.controller;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.io.File;


@Getter
@Component
public class FilePath {

    /**
     * separator를 사용해서 output path, ffmpeg path 설정
     * ffmpeg실행파일 경로
     */


    String separator = File.separator;

    String outputPath = "";

    String videoName = "testvideo"; //비디오 파일 이름

    String playListPath = "https://Sansatree.github.io/testvideo.m3u8"; //.m3u8 경로

    String playListName = videoName + ".m3u8"; //.m3u8 이름
    String tsFilePath = "C:\\ffmpeg\\bin"; //.ts 파일 경로
    String tsFileName ; //.ts 파일 이름

    String ffmpegPath = "C:\\ffmpeg\\bin";  //ffmpeg.exe, ffprobe.exe 경로

    String ffmpegOutputPath = "C:\\ffmpeg\\bin"; //ffmpeg 으로 만들 파일 경로
    String filePath = "C:\\ffmpeg\\bin"; //비디오 파일 경로

}
