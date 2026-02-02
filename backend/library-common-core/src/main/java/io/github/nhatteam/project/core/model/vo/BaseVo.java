package io.github.nhatteam.project.core.model.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseVo {

    Long id;

    String note;

    Boolean deleted;

    Instant createdAt;

    Instant lastModifiedAt;

    String createdBy;

    String lastModifiedBy;

    Long version;
}
