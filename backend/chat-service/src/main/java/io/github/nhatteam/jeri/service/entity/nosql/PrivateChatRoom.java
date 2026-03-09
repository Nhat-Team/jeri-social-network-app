package io.github.nhatteam.jeri.service.entity.nosql;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "private_chats")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrivateChatRoom extends ChatRoom {

    @Field(name = "friend_id", targetType = FieldType.INT64)
    Long friendId;

    @Field(name = "is_read", targetType = FieldType.BOOLEAN)
    Boolean isRead;

}
