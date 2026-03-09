package io.github.nhatteam.jeri.service.mapper;

import io.github.nhatteam.jeri.service.entity.nosql.CloudChatRoom;
import io.github.nhatteam.jeri.service.model.dto.CloudChatRoomDto;
import io.github.nhatteam.jeri.service.model.vo.CloudChatVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CloudChatRoomMapper {

    CloudChatRoom toEntity(CloudChatRoomDto request);

    CloudChatVo toVo(CloudChatRoom entity);
}
