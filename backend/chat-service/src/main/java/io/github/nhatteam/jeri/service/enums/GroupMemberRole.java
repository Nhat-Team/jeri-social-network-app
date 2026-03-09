package io.github.nhatteam.jeri.service.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public enum GroupMemberRole {

    MEMBER("Member"),
    CO_OWNER("Co-Owner"),
    OWNER("Owner");

    String roleName;
}
