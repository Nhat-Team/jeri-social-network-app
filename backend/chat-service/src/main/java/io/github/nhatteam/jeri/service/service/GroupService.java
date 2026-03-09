package io.github.nhatteam.jeri.service.service;

import io.github.nhatteam.jeri.service.entity.sql.Group;
import io.github.nhatteam.jeri.service.mapper.GroupMapper;
import io.github.nhatteam.jeri.service.model.dto.GroupDto;
import io.github.nhatteam.jeri.service.model.dto.GroupMemberDto;
import io.github.nhatteam.jeri.service.model.vo.GroupVo;
import io.github.nhatteam.jeri.service.repository.sql.GroupRepository;
import io.github.nhatteam.project.core.exception.QueryNotFoundException;
import io.github.nhatteam.project.core.service.IService;
import io.github.nhatteam.project.core.util.MinIOUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class GroupService implements IService<GroupDto, Long> {

    GroupMemberService groupMemberService;
    GroupRepository groupRepository;
    GroupMapper groupMapper;
    MinIOUtil minIOUtil;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public GroupVo add(GroupDto request) throws Exception {
        Group group = groupRepository.save(groupMapper.toEntity(request));
        request.members().stream().map(member -> {
            try {
                return groupMemberService.add(new GroupMemberDto(group.getId(), member.userId()));
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        });
        return getVo(groupRepository.save(group));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public GroupVo update(Long id, GroupDto request) throws Exception {
        Group group = groupRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Group not found with id: " + id));
        BeanUtils.copyProperties(request, group, "id");
        return getVo(groupRepository.save(group));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public GroupVo delete(Long id) throws Exception {
        Group group = groupRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Group not found with id: " + id));
        group.setStatus(false);
        return getVo(groupRepository.save(group));
    }

    @Override
    public GroupVo getById(Long id) throws Exception {
        return getVo(groupRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Group not found with id: " + id)));
    }

    @Override
    public List<GroupVo> getAll() {
        return groupRepository.findAll().stream().map(group -> {
            try {
                return getVo(group);
            } catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }).toList();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public GroupVo uploadFile(Long id, MultipartFile file) throws Exception {
        Group group = groupRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Group not found with id: " + id));
        if(Objects.nonNull(file)) {
            String objectName = "group-avatar/" + group.getId() + "_" + file.getOriginalFilename();
            minIOUtil.uploadObject(file, objectName);
            group.setGroupAvatar(objectName);
        }
        return getVo(groupRepository.save(group));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public GroupVo deleteFile(Long id) throws Exception {
        Group group = groupRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Group not found with id: " + id));
        if(Objects.nonNull(group.getGroupAvatar())) {
            minIOUtil.deleteObject(group.getGroupAvatar());
            group.setGroupAvatar(null);
        }
        return getVo(groupRepository.save(group));
    }

    @Transactional(rollbackFor = Exception.class)
    public GroupVo add(GroupDto request, MultipartFile file) throws Exception {
        Group group = groupRepository.save(groupMapper.toEntity(request));
        if(Objects.nonNull(file)) {
            String objectName = "group-avatar/" + group.getId() + "_" + file.getOriginalFilename();
            minIOUtil.uploadObject(file, objectName);
            group.setGroupAvatar(objectName);
        }
        return getVo(groupRepository.save(group));
    }

    public GroupVo getVo(Group group) throws Exception {
        GroupVo groupVo = groupMapper.toVo(group);
        if(Objects.nonNull(group.getGroupAvatar())) {
            groupVo.setLinkAvatar(minIOUtil.getUrlObject(group.getGroupAvatar()));
        }
        groupVo.setGroupMembers(groupMemberService.getMembersByGroupId(group.getId()));
        return groupVo;
    }
}
