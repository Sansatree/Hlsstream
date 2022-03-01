package com.sansatree.livestreaming.controller;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;

public class FileSystemResource implements Resource {
    public FileSystemResource(String fileFullPath) {

    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public String lookup() {
        return null;
    }

    @Override
    public Class<?> type() {
        return null;
    }

    @Override
    public AuthenticationType authenticationType() {
        return null;
    }

    @Override
    public boolean shareable() {
        return false;
    }

    @Override
    public String mappedName() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
