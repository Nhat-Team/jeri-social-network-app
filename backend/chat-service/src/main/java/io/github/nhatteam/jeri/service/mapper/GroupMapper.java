package io.github.nhatteam.jeri.service.mapper;

import io.github.nhatteam.jeri.service.entity.sql.Group;
import io.github.nhatteam.jeri.service.model.dto.GroupDto;
import io.github.nhatteam.jeri.service.model.vo.GroupVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    Group toEntity(GroupDto request);

    GroupVo toVo(Group entity);
}
