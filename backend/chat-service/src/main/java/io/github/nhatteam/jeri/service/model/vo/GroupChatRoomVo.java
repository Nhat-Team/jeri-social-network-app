package io.github.nhatteam.jeri.service.model.vo;

import io.github.nhatteam.project.core.model.vo.BaseVo;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupChatRoomVo extends ChatRoomVo {

    Long groupId;

    List<String> watchers;
}
