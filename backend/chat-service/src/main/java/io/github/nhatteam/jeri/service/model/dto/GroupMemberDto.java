package io.github.nhatteam.jeri.service.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record GroupMemberDto(

        @NotBlank(message = "can not be null or empty")
        @Positive(message = "must be a positive number")
        Long groupId,

        @NotBlank(message = "can not be null or empty")
        @Positive(message = "must be a positive number")
        Long userId
) {
}
