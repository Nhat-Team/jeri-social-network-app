package io.github.nhatteam.jeri.service.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record GroupDto(

        @NotBlank(message = "can not be null or empty")
        @Size(max = 100, message = "maximum length is {max} characters")
        String groupName,

        Boolean allowChangeGroupNameAndAvatar,

        Boolean allowPinMessage,

        Boolean allowSendMessage,

        List<GroupMemberDto> members) {
}
