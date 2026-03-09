package io.github.nhatteam.jeri.service.mapper;

import io.github.nhatteam.jeri.service.entity.nosql.PrivateChatRoom;
import io.github.nhatteam.jeri.service.model.dto.PrivateChatRoomDto;
import io.github.nhatteam.jeri.service.model.vo.PrivateChatRoomVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrivateChatRoomMapper {

    PrivateChatRoom toEntity(PrivateChatRoomDto request);

    PrivateChatRoomVo toVo(PrivateChatRoom entity);
}
