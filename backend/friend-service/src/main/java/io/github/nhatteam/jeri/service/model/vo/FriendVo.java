package io.github.nhatteam.jeri.service.model.vo;

import io.github.nhatteam.jeri.service.enums.FriendStatus;
import io.github.nhatteam.project.core.model.vo.BaseVo;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class FriendVo extends BaseVo {

    Long senderId;

    Long receiverId;

    String messageRequest;

    FriendStatus status;
}
