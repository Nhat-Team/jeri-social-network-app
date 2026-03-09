package io.github.nhatteam.jeri.service.model.dto;

import jakarta.validation.constraints.Size;

public record AddressDto(

        Long userId,

        @Size(max = 50, message = "maximum length is {max} characters")
        String street,

        @Size(max = 50, message = "maximum length is {max} characters")
        String ward,

        @Size(max = 50, message = "maximum length is {max} characters")
        String district,

        @Size(max = 50, message = "maximum length is {max} characters")
        String city,

        @Size(max = 50, message = "maximum length is {max} characters")
        String country,

        Integer postalCode
) {
}
