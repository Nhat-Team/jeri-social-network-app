package io.github.nhatteam.jeri.service.mapper;

import io.github.nhatteam.jeri.service.entity.sql.Tag;
import io.github.nhatteam.jeri.service.model.dto.TagDto;
import io.github.nhatteam.jeri.service.model.vo.TagVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {

    Tag toEntity(TagDto request);

    TagVo toVo(Tag entity);
}
