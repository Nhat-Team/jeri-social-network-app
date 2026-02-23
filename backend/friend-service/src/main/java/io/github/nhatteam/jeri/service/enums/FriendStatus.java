package io.github.nhatteam.jeri.service.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
@AllArgsConstructor
public enum FriendStatus {

    STRANGER("Stranger"),
    WAITING_RESPONSE("Waiting Response"),
    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    BLOCKED("Blocked");

    String type;
}
