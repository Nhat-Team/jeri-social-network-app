package io.github.nhatteam.project.core.util;

import io.github.nhatteam.project.core.enums.FileExtensionExceptionType;
import io.github.nhatteam.project.core.exception.FileExtensionException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

public class FileValidatedUtil {

    public static boolean isImageFile(MultipartFile file) {
        if(Objects.requireNonNull(file.getContentType()).isEmpty() || file.getContentType().isBlank()) {
            throw new FileExtensionException(FileExtensionExceptionType.NOT_FOUND_EXTENSION_FILE);
        }

        String getContentType = file.getContentType();
        return getContentType != null && (getContentType.equals("image/png")
                || getContentType.equals("image/jpeg")
                || getContentType.equals("image/jpg"));
    }

    public static boolean isVideoFile(MultipartFile file) {
        if(Objects.requireNonNull(Objects.requireNonNull(file.getContentType()).isEmpty()) || file.getContentType().isBlank()) {
            throw new FileExtensionException(FileExtensionExceptionType.NOT_FOUND_EXTENSION_FILE);
        }

        String getContentType = file.getContentType();
        return getContentType != null && (getContentType.equals("video/mp4")
                || getContentType.equals("video/mpeg"));
    }
}
