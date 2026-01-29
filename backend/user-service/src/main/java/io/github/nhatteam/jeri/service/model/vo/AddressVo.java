package io.github.nhatteam.jeri.service.model.vo;

import io.github.nhatteam.project.core.model.vo.BaseVo;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AddressVo extends BaseVo {

    String street;

    String ward;

    String district;

    String city;

    String country;

    Integer postalCode;
}
