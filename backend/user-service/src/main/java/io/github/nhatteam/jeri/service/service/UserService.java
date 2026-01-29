package io.github.nhatteam.jeri.service.service;

import io.github.nhatteam.jeri.service.entity.Address;
import io.github.nhatteam.jeri.service.entity.User;
import io.github.nhatteam.jeri.service.mapper.AddressMapper;
import io.github.nhatteam.jeri.service.mapper.UserMapper;
import io.github.nhatteam.jeri.service.model.dto.UserDto;
import io.github.nhatteam.jeri.service.model.vo.UserVo;
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
public class UserService implements IService<UserDto, Long> {

    UserMapper userMapper;
    UserRepository userRepository;
    AddressRepository addressRepository;
    AddressMapper addressMapper;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public UserVo add(UserDto request) {
        User user = userMapper.toEntity(request);
        return getEntityVo(userRepository.save(user));
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public UserVo update(Long id, UserDto request) {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User not found"));
        BeanUtils.copyProperties(request, user);
        return getEntityVo(userRepository.save(user));
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public UserVo delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User not found with id: " + id));
        user.setDeleted(true);
        return getEntityVo(userRepository.save(user));
    }

    @Override
    public UserVo getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User not found with id: " + id));
        return getEntityVo(user);
    }

    @Override
    public List<UserVo> getAll() {
        return userRepository.findAll().stream().map(this::getEntityVo).toList();
    }

    private UserVo getEntityVo(User user) {
        UserVo userVo = userMapper.toVo(user);
        userVo.setAddress(addressMapper.toVo(addressRepository.findById(user.getId()).orElse(null)));
        return userVo;
    }
}
