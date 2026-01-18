package io.github.nhatteam.project.core.exception;

import io.github.nhatteam.project.core.enums.FileExtensionExceptionType;

public class FileExtensionException extends RuntimeException {

    public FileExtensionException(FileExtensionExceptionType type) {
        super(type.getMessage());
    }
}
