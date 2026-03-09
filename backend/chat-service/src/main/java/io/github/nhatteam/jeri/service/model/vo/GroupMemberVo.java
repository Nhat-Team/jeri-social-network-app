package io.github.nhatteam.jeri.service.model.vo;

import io.github.nhatteam.jeri.service.enums.GroupMemberRole;
import io.github.nhatteam.jeri.service.enums.GroupMemberStatus;
import io.github.nhatteam.project.core.model.vo.BaseVo;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupMemberVo extends BaseVo {

    Long groupId;

    Long userId;

    GroupMemberRole role;

    GroupMemberStatus status;
}
