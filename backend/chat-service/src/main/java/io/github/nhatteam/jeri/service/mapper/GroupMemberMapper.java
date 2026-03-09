package io.github.nhatteam.jeri.service.mapper;

import io.github.nhatteam.jeri.service.entity.sql.GroupMember;
import io.github.nhatteam.jeri.service.model.dto.GroupMemberDto;
import io.github.nhatteam.jeri.service.model.vo.GroupMemberVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMemberMapper {

    GroupMember toEntity(GroupMemberDto request);

    GroupMemberVo toVo(GroupMember entity);
}
