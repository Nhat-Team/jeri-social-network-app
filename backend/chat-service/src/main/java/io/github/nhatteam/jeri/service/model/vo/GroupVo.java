package io.github.nhatteam.jeri.service.model.vo;

import io.github.nhatteam.jeri.service.enums.GroupInviteSetting;
import io.github.nhatteam.project.core.model.vo.BaseVo;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupVo extends BaseVo {

    String groupName;

    String groupId;

    String groupAvatar;

    String linkAvatar;

    Boolean allowChangeGroupNameAndAvatar;

    Boolean allowPinMessage;

    Boolean allowSendMessage;

    GroupInviteSetting groupInviteSetting;

    List<GroupMemberVo> groupMembers;
}
