package io.github.nhatteam.jeri.service.model.dto;

import io.github.nhatteam.jeri.service.enums.UserGender;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserDto(

        @NotBlank(message = "can not be null or empty")
        @Size(max = 50, message = "maximum length is {max} characters")
        String firstName,

        @NotBlank(message = "can not be null or empty")
        @Size(max = 50, message = "maximum length is {max} characters")
        String lastName,

        @NotNull(message = "can not be null")
        @PastOrPresent(message = "must be a past or present date")
        LocalDate birthDate,

        @NotNull(message = "can not be null")
        UserGender gender,

        @NotBlank(message = "can not be null or empty")
        String phone,

        @NotBlank(message = "can not be null or empty")
        @Email(message = "must be a valid email address")
        String email,

        @NotBlank(message = "can not be null or empty")
        @Size(min = 3, max = 50, message = "minimum length and maximum between {min} and {max} characters")
        String username,

        @NotBlank(message = "can not be null or empty")
        @Size(max = 100, message = "maximum length is {max} characters")
        String password,

        AddressDto address
) {
}
