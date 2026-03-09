package io.github.nhatteam.jeri.service.entity.nosql;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.List;

@Document(collection = "group_chats")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupChatRoom extends ChatRoom {

    @Field(name = "group_id", targetType = FieldType.INT64)
    Long groupId;

    @Field(name = "watchers", targetType = FieldType.ARRAY)
    List<String> watchers;
}
