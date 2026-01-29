package io.github.nhatteam.jeri.service.mapper;

import io.github.nhatteam.jeri.service.entity.User;
import io.github.nhatteam.jeri.service.model.dto.UserDto;
import io.github.nhatteam.jeri.service.model.vo.UserVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto request);

    UserVo toVo(User entity);
}
