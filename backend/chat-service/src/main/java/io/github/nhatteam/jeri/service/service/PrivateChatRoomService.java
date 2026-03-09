package io.github.nhatteam.jeri.service.service;

import io.github.nhatteam.jeri.service.entity.nosql.PrivateChatRoom;
import io.github.nhatteam.jeri.service.mapper.PrivateChatRoomMapper;
import io.github.nhatteam.jeri.service.model.dto.PrivateChatRoomDto;
import io.github.nhatteam.jeri.service.model.vo.PrivateChatRoomVo;
import io.github.nhatteam.jeri.service.repository.nosql.PrivateChatRoomRepository;
import io.github.nhatteam.project.core.exception.QueryNotFoundException;
import io.github.nhatteam.project.core.model.vo.BaseVo;
import io.github.nhatteam.project.core.service.IService;
import io.github.nhatteam.project.core.util.MinIOUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PrivateChatRoomService implements IService<PrivateChatRoomDto, Long> {

    PrivateChatRoomRepository privateChatRoomRepository;
    PrivateChatRoomMapper privateChatRoomMapper;
    MinIOUtil minIOUtil;

    @Override
    public PrivateChatRoomVo add(PrivateChatRoomDto request) throws Exception {
        PrivateChatRoom target = privateChatRoomMapper.toEntity(request);
        return getVo(privateChatRoomRepository.save(target));
    }

    @Override
    public PrivateChatRoomVo update(Long id, PrivateChatRoomDto request) {
        return null;
    }

    @Override
    public PrivateChatRoomVo delete(Long id) throws Exception {
        PrivateChatRoom privateChatRoom = privateChatRoomRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Private chat room not found with id: " + id));
        privateChatRoom.setStatus(false);
        return getVo(privateChatRoomRepository.save(privateChatRoom));
    }

    @Override
    public PrivateChatRoomVo getById(Long id) {
        return null;
    }

    @Override
    public List<PrivateChatRoomVo> getAll() {
        return List.of();
    }

    public List<PrivateChatRoomVo> getAllByFriendId(Long friendId) {
        return privateChatRoomRepository.findByFriendIdOrderByCreatedAtDesc(friendId).stream().map(privateChatRoom -> {
            try {
                return getVo(privateChatRoom);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }

    @Override
    public PrivateChatRoomVo uploadFile(Long id, MultipartFile file) throws Exception {
        return null;
    }

    public PrivateChatRoomVo uploadFiles(Long id, MultipartFile[] files) throws Exception {
        PrivateChatRoom privateChatRoom = privateChatRoomRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Private chat room not found with id: " + id));
        List<String> attachments = new ArrayList<>();
        for (MultipartFile file : files) {
            String objectName = "private-chat-room/" + id + "/" + file.getOriginalFilename();
            minIOUtil.uploadObject(file, objectName);
            attachments.add(objectName);
        }
        privateChatRoom.setAttachments(attachments);
        return getVo(privateChatRoomRepository.save(privateChatRoom));
    }

    public PrivateChatRoomVo getVo(PrivateChatRoom privateChat) throws Exception {
        PrivateChatRoomVo privateChatRoomVo = privateChatRoomMapper.toVo(privateChat);
        for (String attachment : privateChat.getAttachments()) {
            privateChatRoomVo.getAttachmentLinks().put(attachment, minIOUtil.getUrlObject(attachment));
        }
        return privateChatRoomVo;
    }
}
