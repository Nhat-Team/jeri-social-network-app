package io.github.nhatteam.jeri.service.mapper;

import io.github.nhatteam.jeri.service.entity.nosql.GroupChatRoom;
import io.github.nhatteam.jeri.service.model.dto.GroupChatRoomDto;
import io.github.nhatteam.jeri.service.model.vo.GroupChatRoomVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupChatRoomMapper {

    GroupChatRoom toEntity(GroupChatRoomDto request);

    GroupChatRoomVo toVo(GroupChatRoom entity);
}
