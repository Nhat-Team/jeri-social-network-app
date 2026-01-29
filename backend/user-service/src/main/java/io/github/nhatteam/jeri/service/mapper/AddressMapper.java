package io.github.nhatteam.jeri.service.mapper;

import io.github.nhatteam.jeri.service.entity.Address;
import io.github.nhatteam.jeri.service.model.dto.AddressDto;
import io.github.nhatteam.jeri.service.model.vo.AddressVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toEntity(AddressDto request);

    AddressVo toVo(Address address);
}
