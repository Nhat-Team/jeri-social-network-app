package io.github.nhatteam.jeri.service.model.vo;

import io.github.nhatteam.project.core.model.vo.BaseVo;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class TagVo extends BaseVo {

    String tagName;

    String colorHashTag;

}
