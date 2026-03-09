package io.github.nhatteam.jeri.service.entity.sql;

import io.github.nhatteam.jeri.service.enums.GroupInviteSetting;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity @Table(name = "groups")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class Group extends BaseEntity {

    @Column(name = "group_name", length = 100, nullable = false) @NonNull
    String groupName;

    @Column(name = "group_id", length = 50, nullable = false) @NonNull
    String groupId;

    @Column(name = "group_avatar", length = 50)
    String groupAvatar;

    @Column(name = "link_join", length = 300, nullable = false) @NonNull
    String linkJoin;

    @Column(name = "allow_change_group_name_and_avatar", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE") @NonNull
    Boolean allowChangeGroupNameAndAvatar;

    @Column(name = "allow_pin_message", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE") @NonNull
    Boolean allowPinMessage;

    @Column(name = "allow_send_message", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE") @NonNull
    Boolean allowSendMessage;

    @Enumerated(EnumType.STRING)
    @Column(name = "invite_setting", nullable = false, columnDefinition = "VARCHAR(30) DEFAULT 'Anyone'") @NonNull
    GroupInviteSetting inviteSetting;
}
