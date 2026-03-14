package io.github.nhatteam.jeri.service.entity;

import io.github.nhatteam.jeri.service.enums.FriendStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.print.DocFlavor;

@Entity @Table(name = "friends")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Friend extends BaseEntity {

    @Column(name = "sender_id", nullable = false) @NonNull
    Long senderId;

    @Column(name = "receiver_id", nullable = false) @NonNull
    Long receiverId;

    @Column(name = "message_request", length = 400) @NonNull
    String messageRequest;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false) @NonNull
    FriendStatus status;
}
