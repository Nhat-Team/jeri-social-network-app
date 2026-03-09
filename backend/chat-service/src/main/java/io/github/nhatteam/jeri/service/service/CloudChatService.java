package io.github.nhatteam.jeri.service.service;

import io.github.nhatteam.jeri.service.mapper.CloudChatRoomMapper;
import io.github.nhatteam.jeri.service.model.dto.CloudChatRoomDto;
import io.github.nhatteam.jeri.service.model.vo.CloudChatVo;
import io.github.nhatteam.jeri.service.repository.nosql.CloudChatRoomRepository;
import io.github.nhatteam.project.core.service.IService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CloudChatService implements IService<CloudChatRoomDto, Long> {

    CloudChatRoomRepository cloudChatRoomRepository;
    CloudChatRoomMapper cloudChatRoomMapper;

    @Override
    public CloudChatVo add(CloudChatRoomDto request) {
        return null;
    }

    @Override
    public CloudChatVo update(Long id, CloudChatRoomDto request) {
        return null;
    }

    @Override
    public CloudChatVo delete(Long id) {
        return null;
    }

    @Override
    public CloudChatVo getById(Long id) {
        return null;
    }

    @Override
    public List<CloudChatVo> getAll() {
        return List.of();
    }

    @Override
    public CloudChatVo uploadFile(Long id, MultipartFile file) {
        return null;
    }

    @Override
    public CloudChatVo deleteFile(Long id) {
        return null;
    }
}
