package io.github.nhatteam.jeri.service.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cloud_chat")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
@AllArgsConstructor
public class CloudChatRoom extends ChatRoom {


}
