package io.github.nhatteam.jeri.service.entity.nosql;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ChatRoom extends BaseEntity {

    @Field(name = "sender_id", targetType = FieldType.STRING)
    Long senderId;

    @Field(name = "content", targetType = FieldType.STRING)
    String content;

    @Field(name = "attachments", targetType = FieldType.ARRAY)
    List<String> attachments;

    @Field(name = "is_pinned", targetType = FieldType.BOOLEAN)
    Boolean isPinned;

    @Field(name = "is_recall", targetType = FieldType.BOOLEAN)
    Boolean isRecall;
}
