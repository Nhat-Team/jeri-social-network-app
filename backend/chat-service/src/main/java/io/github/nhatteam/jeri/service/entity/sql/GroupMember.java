package io.github.nhatteam.jeri.service.entity.sql;


import io.github.nhatteam.jeri.service.enums.GroupMemberRole;
import io.github.nhatteam.jeri.service.enums.GroupMemberStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity @Table(name = "group_members")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class GroupMember extends BaseEntity {

    @ManyToOne @JoinColumn(name = "group_id", nullable = false) @NonNull
    Group groupId;

    @Column(name = "user_id", nullable = false) @NonNull
    Long userId;

    @Column(name = "reason_banned", length = 300)
    String reasonBanned;

    @Enumerated(EnumType.STRING) @JoinColumn(name = "role", nullable = false, columnDefinition = "VARCHAR(30) DEFAULT 'Member'") @NonNull
    GroupMemberRole role;

    @Enumerated(EnumType.STRING) @JoinColumn(name = "join_status", nullable = false) @NonNull
    GroupMemberStatus joinStatus;
}
