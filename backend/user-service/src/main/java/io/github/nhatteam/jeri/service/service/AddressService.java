package io.github.nhatteam.jeri.service.service;

import io.github.nhatteam.jeri.service.entity.Address;
import io.github.nhatteam.jeri.service.entity.User;
import io.github.nhatteam.jeri.service.mapper.AddressMapper;
import io.github.nhatteam.jeri.service.model.dto.AddressDto;
import io.github.nhatteam.jeri.service.model.vo.AddressVo;
import io.github.nhatteam.jeri.service.repository.AddressRepository;
import io.github.nhatteam.jeri.service.repository.UserRepository;
import io.github.nhatteam.project.core.exception.QueryNotFoundException;
import io.github.nhatteam.project.core.service.IService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AddressService implements IService<AddressDto, Long> {

    AddressMapper addressMapper;
    AddressRepository addressRepository;
    UserRepository userRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public AddressVo add(AddressDto request) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Transactional(rollbackOn = Exception.class)
    public AddressVo add(Long userId, AddressDto request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new QueryNotFoundException("User not found"));
        Address address = addressMapper.toEntity(request);
        address.setUser(user);
        Address result = addressRepository.save(address);

        user.setAddress(result);
        userRepository.save(user);

        return addressMapper.toVo(result);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public AddressVo update(Long id, AddressDto request) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Address not found"));
        BeanUtils.copyProperties(request, address);
        return addressMapper.toVo(addressRepository.save(address));
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public AddressVo delete(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Address not found"));
        address.setDeleted(true);
        return addressMapper.toVo(addressRepository.save(address));
    }

    @Override
    public AddressVo getById(Long id) {
        return addressMapper.toVo(addressRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Address not found")));
    }

    @Override
    public List<AddressVo> getAll() {
        return addressRepository.findAll().stream().map(addressMapper::toVo).toList();
    }
}
