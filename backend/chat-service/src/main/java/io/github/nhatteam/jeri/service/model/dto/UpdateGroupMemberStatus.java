package io.github.nhatteam.jeri.service.model.dto;

import io.github.nhatteam.jeri.service.enums.GroupMemberStatus;
import jakarta.validation.constraints.Size;

public record UpdateGroupMemberStatus(

        GroupMemberStatus joinStatus,

        @Size(max = 300, message = "maximum length is {max} characters")
        String reasonBanned
) {
}
