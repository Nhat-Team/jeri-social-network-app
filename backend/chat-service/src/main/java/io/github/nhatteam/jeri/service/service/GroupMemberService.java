package io.github.nhatteam.jeri.service.service;

import io.github.nhatteam.jeri.service.entity.sql.Group;
import io.github.nhatteam.jeri.service.entity.sql.GroupMember;
import io.github.nhatteam.jeri.service.enums.GroupInviteSetting;
import io.github.nhatteam.jeri.service.enums.GroupMemberRole;
import io.github.nhatteam.jeri.service.enums.GroupMemberStatus;
import io.github.nhatteam.jeri.service.mapper.GroupMemberMapper;
import io.github.nhatteam.jeri.service.model.dto.GroupMemberDto;
import io.github.nhatteam.jeri.service.model.dto.UpdateGroupMemberStatus;
import io.github.nhatteam.jeri.service.model.vo.GroupMemberVo;
import io.github.nhatteam.jeri.service.repository.sql.GroupMemberRepository;
import io.github.nhatteam.jeri.service.repository.sql.GroupRepository;
import io.github.nhatteam.project.core.exception.QueryNotFoundException;
import io.github.nhatteam.project.core.model.vo.BaseVo;
import io.github.nhatteam.project.core.service.IService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class GroupMemberService implements IService<GroupMemberDto, Long> {

    GroupMemberRepository groupMemberRepository;
    GroupMemberMapper groupMemberMapper;
    GroupRepository groupRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public GroupMemberVo add(GroupMemberDto request) {
        GroupMember groupMember = groupMemberMapper.toEntity(request);
        groupMember.setGroupId(groupRepository.findById(request.groupId()).orElseThrow(() -> new QueryNotFoundException("Group not found with id: " + request.groupId())));
        groupMember.setRole(GroupMemberRole.MEMBER);
        groupMember.setJoinStatus(GroupMemberStatus.JOINED);
        return getVo(groupMemberRepository.save(groupMember));
    }

    @Transactional(rollbackFor = Exception.class)
    public GroupMemberVo add(Long userAddedId, GroupMemberDto request) throws Exception {
        Group group = groupRepository.findById(request.groupId()).orElseThrow(() -> new QueryNotFoundException("Group not found with id: " + request.groupId()));
        if(groupMemberRepository.findByUserFollowStaff(userAddedId, request.groupId()).isPresent()) {
            GroupMember groupMember = groupMemberMapper.toEntity(request);
            groupMember.setRole(GroupMemberRole.MEMBER);
            groupMember.setJoinStatus(GroupMemberStatus.INVITED);
            return getVo(groupMemberRepository.save(groupMember));
        } else if(group.getInviteSetting().equals(GroupInviteSetting.STAFF) && groupMemberRepository.findByUserFollowStaff(userAddedId, request.groupId()).isEmpty()) {
            throw new BadRequestException("Must be owner or co_owner to invite members to this group");
        } else if(group.getInviteSetting().equals(GroupInviteSetting.BLOCKED)) {
            throw new BadRequestException("Inviting members to this group is blocked");
        } else {
            GroupMember groupMember = groupMemberMapper.toEntity(request);
            groupMember.setRole(GroupMemberRole.MEMBER);
            groupMember.setJoinStatus(group.getInviteSetting().equals(GroupInviteSetting.REQUEST_APPROVE) ? GroupMemberStatus.WAITING_JOINED : GroupMemberStatus.INVITED);
            return getVo(groupMemberRepository.save(groupMember));
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public GroupMemberVo update(Long id, GroupMemberDto request) {
        throw new UnsupportedOperationException("The update operation is not supported for GroupMember");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public GroupMemberVo delete(Long id) {
        throw new UnsupportedOperationException("The delete operation is not supported for GroupMember");
    }

    @Transactional(readOnly = true)
    @Override
    public GroupMemberVo getById(Long id) {
        return getVo(groupMemberRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Group member not found with id: " + id)));
    }

    @Transactional(readOnly = true)
    @Override
    public <R extends BaseVo> List<R> getAll() {
        throw new UnsupportedOperationException("The getAll operation is not supported for GroupMember");
    }

    public List<GroupMemberVo> getMembersByGroupId(Long groupId) {
        return groupMemberRepository.findByGroupId_Id(groupId).stream().map(this::getVo).toList();
    }

    public GroupMemberVo updateRoleMember(Long id, GroupMemberRole role) {
        GroupMember groupMember = groupMemberRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Group member not found with id: " + id));
        groupMember.setRole(role);
        return getVo(groupMemberRepository.save(groupMember));
    }

    public GroupMemberVo updateStatusMember(Long id, UpdateGroupMemberStatus request) throws Exception {
        GroupMember groupMember = groupMemberRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Group member not found with id: " + id));
        if(request.joinStatus().equals(GroupMemberStatus.BANNED)) {
            if(request.reasonBanned() != null && !request.reasonBanned().isBlank()) {
                groupMember.setReasonBanned(request.reasonBanned());
            } else {
                throw new BadRequestException("Reason banned must be provided when banning a member");
            }
        }
        groupMember.setJoinStatus(request.joinStatus());
        return getVo(groupMemberRepository.save(groupMember));
    }

    public GroupMemberVo getVo(GroupMember groupMember) {
        GroupMemberVo groupMemberVo = groupMemberMapper.toVo(groupMember);
        groupMemberVo.setId(groupMember.getId());
        return groupMemberVo;
    }
}
