package io.github.nhatteam.jeri.service.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TagDto(

        @NotBlank(message = "can not be null or empty")
        @Size(max = 50, message = "maximum length is {max} characters")
        String tagName,

        @NotBlank(message = "can not be null or empty")
        @Size(max = 20, message = "maximum length is {max} characters")
        String colorHashTag) {
}
