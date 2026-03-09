package io.github.nhatteam.jeri.service.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
@AllArgsConstructor
public enum GroupMemberStatus {

    WAITING_JOINED("Waiting Joined"), JOINED("Joined"), INVITED("Invited"), LEFT("Left"), KICKED("Kicked"), BANNED("Banned");

    String status;
}
