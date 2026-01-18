package io.github.nhatteam.project.core.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public enum FileExtensionExceptionType {

    NOT_FOUND_EXTENSION_FILE("File extension not found."),

    INVALID_IMAGE_FILE("Invalid image file extension. Allowed extensions are PNG, JPEG, JPG."),
    INVALID_VIDEO_FILE("Invalid video file extension. Allowed extensions are MP4, MPEG.");

    String message;

}
