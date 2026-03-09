package io.github.nhatteam.jeri.service.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
@AllArgsConstructor
public enum GroupInviteSetting {

    ANYONE("Anyone"), REQUEST_APPROVE("Request Approve"), STAFF("Staff"), BLOCKED("Blocked");

    String type;
}
