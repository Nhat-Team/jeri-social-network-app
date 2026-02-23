package io.github.nhatteam.jeri.service.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record FriendDto(

        @Positive(message = "must be a number greater than 0")
        @NotBlank(message = "can not be null or empty")
        Long senderId,

        @Positive(message = "must be a number greater than 0")
        @NotBlank(message = "can not be null or empty")
        Long receiverId,

        String messageRequest
) {
}
