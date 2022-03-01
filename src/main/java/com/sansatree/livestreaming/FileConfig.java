package com.sansatree.livestreaming;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
public interface FileConfig {

    //
    //    String videoName;
    //    Path getRootAudioFile();

    //String playListPath;
    //String playListName;

    byte[] readAudioPartFile(Path pathToAudioRootDirectory, Integer audioPathId);

}
