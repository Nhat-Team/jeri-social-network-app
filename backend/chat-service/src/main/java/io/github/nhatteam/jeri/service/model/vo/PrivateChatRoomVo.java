package io.github.nhatteam.jeri.service.model.vo;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PrivateChatRoomVo extends ChatRoomVo {

    Long friendId;

    Boolean isRead;
}
