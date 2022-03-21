package com.sansatree.livestreaming.ffmpeg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class CreateM3u8TsAac implements ApplicationRunner {

    CreateM3u8 createM3u8 = new CreateM3u8();


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        createM3u8.localCamera();
        createM3u8.videoEncode();
    }

    public CreateM3u8TsAac() throws IOException {
    }

}