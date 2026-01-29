package io.github.nhatteam.jeri.service.model.vo;

import io.github.nhatteam.project.core.model.vo.BaseVo;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserVo extends BaseVo {

    Long id;

    String firstName;

    String lastName;

    LocalDate birthDate;

    AddressVo address;

    String phone;

    String email;

    String username;

    Instant createdAt;

    Instant lastModifiedAt;

    String createdBy;

    String lastModifiedBy;

    Boolean deleted;
}
