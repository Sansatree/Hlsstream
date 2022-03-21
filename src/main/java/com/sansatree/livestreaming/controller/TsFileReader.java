package com.sansatree.livestreaming.controller;

import java.nio.file.Path;

public interface TsFileReader {

    /**
     * Reads audio file chunk content of given id from given path.
     *
     * @param pathToTsFileDirectory - path where ts file chunks are stored
     * @param tsPathId - id of ts file chunk
     * @return byte array containing audio file chunk contents.
     */

    byte[] readTsPartFile(Path pathToTsFileDirectory, Integer tsPathId);
}
