package io.github.nhatteam.jeri.service.mapper;

import io.github.nhatteam.jeri.service.entity.nosql.Friend;
import io.github.nhatteam.jeri.service.model.dto.FriendDto;
import io.github.nhatteam.jeri.service.model.vo.FriendVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FriendMapper {

    Friend toEntity(FriendDto request);

    FriendVo toVo(Friend entity);
}
