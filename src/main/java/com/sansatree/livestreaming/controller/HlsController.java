package com.sansatree.livestreaming.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;


//@RestController
@Controller
@RequiredArgsConstructor
@Slf4j
public class HlsController {

    private static FilePath filePath;


    private static final String inputPath = "C:\\ffmpeg\\bin";
    private static final String videoName = "testvideo";
    private static final String tsName = "testvideo";
    private static final String pathFile = "../m3u8/";



    @GetMapping("/hls-video")
    public String videoHls(){

        return "hlsvideo";
    }



}
