package io.github.nhatteam.jeri.service.entity.nosql;

import io.github.nhatteam.jeri.service.enums.FriendStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "friends")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Friend extends BaseEntity {

    @Field(name = "sender_id", targetType = FieldType.INT64)
    Long senderId;

    @Field(name = "receiver_id", targetType = FieldType.INT64)
    Long receiverId;

    @Field(name = "message_request", targetType = FieldType.STRING)
    String messageRequest;

    @Field(name = "status", targetType = FieldType.STRING)
    FriendStatus status;
}
