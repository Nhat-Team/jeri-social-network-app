package io.github.nhatteam.jeri.service.service;

import io.github.nhatteam.jeri.service.entity.nosql.GroupChatRoom;
import io.github.nhatteam.jeri.service.mapper.GroupChatRoomMapper;
import io.github.nhatteam.jeri.service.model.dto.GroupChatRoomDto;
import io.github.nhatteam.jeri.service.model.vo.GroupChatRoomVo;
import io.github.nhatteam.jeri.service.repository.nosql.GroupChatRoomRepository;
import io.github.nhatteam.project.core.service.IService;
import io.github.nhatteam.project.core.util.MinIOUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class GroupChatRoomService implements IService<GroupChatRoomDto, Long> {

    GroupChatRoomRepository groupChatRoomRepository;
    GroupChatRoomMapper groupChatRoomMapper;
    MinIOUtil minIOUtil;

    @Override
    public GroupChatRoomVo add(GroupChatRoomDto request) {
        return null;
    }

    @Override
    public GroupChatRoomVo update(Long id, GroupChatRoomDto request) {
        return null;
    }

    @Override
    public GroupChatRoomVo delete(Long id) {
        return null;
    }

    @Override
    public GroupChatRoomVo getById(Long id) {
        return null;
    }

    @Override
    public List<GroupChatRoomVo> getAll() {
        return List.of();
    }

    @Override
    public GroupChatRoomVo uploadFile(Long id, MultipartFile file) throws Exception {
        return null;
    }

    @Override
    public GroupChatRoomVo deleteFile(Long id) throws Exception {
        return null;
    }

    public GroupChatRoomVo getVo(GroupChatRoom groupChatRoom) throws Exception {
        GroupChatRoomVo groupChatRoomVo = groupChatRoomMapper.toVo(groupChatRoom);
        for (String attachment : groupChatRoom.getAttachments()) {
            groupChatRoomVo.getAttachmentLinks().put(attachment, minIOUtil.getUrlObject(attachment));
        }
        return groupChatRoomVo;
    }
}
