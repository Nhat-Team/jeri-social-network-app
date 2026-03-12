package io.github.nhatteam.jeri.service.model.dto;

import jakarta.validation.constraints.NotBlank;

public record AccountResetPasswordDto(

        @NotBlank(message = "can not be null or empty")
        String username,

        @NotBlank(message = "can not be null or empty")
        String password
) {
}
