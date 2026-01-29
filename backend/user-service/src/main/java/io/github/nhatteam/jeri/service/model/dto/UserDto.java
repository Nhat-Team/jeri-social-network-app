package io.github.nhatteam.jeri.service.model.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserDto(

        @NotBlank(message = "can not be null or empty")
        @Size(max = 50, message = "maximum length is {max} characters")
        String firstName,

        @NotBlank(message = "can not be null or empty")
        @Size(max = 50, message = "maximum length is {max} characters")
        String lastName,

        @NotEmpty(message = "can not be null or empty")
        LocalDate birthDate,

        @NotBlank(message = "can not be null or empty")
        String phone,

        @NotBlank(message = "can not be null or empty")
        @Email(message = "must be a valid email address")
        String email,

        @NotBlank(message = "can not be null or empty")
        @Size(max = 50, message = "maximum length is {max} characters")
        String username
) {
}
