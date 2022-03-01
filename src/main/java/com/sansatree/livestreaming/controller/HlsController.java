package com.sansatree.livestreaming.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HlsController {
    private static final String inputPath = "C:\\ffmpeg\\bin";
    private static final String videoName = "testvideo";
    private static final String tsName = "testvideo";


    @GetMapping("/hls")
    public String hls(){
        String filePath = inputPath + videoName + ".m3u8";
//        Model videoUrl = model.addAttribute("videoUrl", inputPath + videoName + ".m3u8");
        return "hls";
    }

    @GetMapping("/{videoName}.m3u8")
    public String videoM3u8(@PathVariable String videoName){

        String fileFullPath = inputPath + "\\" + videoName + ".m3u8";
        Resource resource = new FileSystemResource(fileFullPath);
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; videoname=" + videoName + ".m3u8");
//        headers.setContentType(MediaType.parseMediaType("application/vnd.apple.mpegurl"));
        return fileFullPath;

    }

    @GetMapping("/{tsName}.ts")
    public ResponseEntity<Resource> videoTs(@PathVariable String videoName, @PathVariable String tsName){
        String fileFullPath = inputPath + "\\" + tsName + ".ts";
        Resource resource = new FileSystemResource(fileFullPath);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; videoname=" + tsName + ".ts");
        headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_OCTET_STREAM_VALUE));
        return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);

    }


}
