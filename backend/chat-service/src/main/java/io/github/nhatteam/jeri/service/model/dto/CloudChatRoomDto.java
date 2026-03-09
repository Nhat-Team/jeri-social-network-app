package io.github.nhatteam.jeri.service.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CloudChatRoomDto(
        @Positive(message = "must be a number greater than 0") @NotBlank(message = "can not be null or empty")
        Long friendId,

        @Positive(message = "must be a number greater than 0")
        @NotBlank(message = "can not be null or empty")
        Long senderId,

        @NotBlank(message = "can not be null or empty")
        String content,

        String[] attachments
) {

}
