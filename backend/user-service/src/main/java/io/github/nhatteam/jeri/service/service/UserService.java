package io.github.nhatteam.jeri.service.service;

import io.github.nhatteam.jeri.service.entity.Address;
import io.github.nhatteam.jeri.service.entity.User;
import io.github.nhatteam.jeri.service.mapper.AddressMapper;
import io.github.nhatteam.jeri.service.mapper.UserMapper;
import io.github.nhatteam.jeri.service.model.dto.AccountResetPasswordDto;
import io.github.nhatteam.jeri.service.model.dto.UserDto;
import io.github.nhatteam.jeri.service.model.vo.UserVo;
import io.github.nhatteam.jeri.service.repository.AddressRepository;
import io.github.nhatteam.jeri.service.repository.UserRepository;
import io.github.nhatteam.jeri.service.service.external.KeyCloakService;
import io.github.nhatteam.project.core.exception.QueryNotFoundException;
import io.github.nhatteam.project.core.service.IService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserService implements IService<UserDto, Long> {

    UserMapper userMapper;
    UserRepository userRepository;
    AddressRepository addressRepository;
    AddressMapper addressMapper;
    AddressService addressService;
    KeyCloakService keyCloakService;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public UserVo add(@Valid UserDto request) throws Exception {
        if(userRepository.findByEmail(request.email()).isPresent()) {
            throw new BadRequestException("Email already exists");
        } else if(userRepository.findByUsername(request.username()).isPresent()) {
            throw new BadRequestException("Username already exists");
        } else if(userRepository.findByPhone(request.phone()).isPresent()) {
            throw new BadRequestException("Phone number already exists");
        }

        keyCloakService.createUser(request);

        User user = userMapper.toEntity(request);
        user.setUserId(keyCloakService.getUserId(user.getUsername()));
        user.setAddress(null);
        User result = userRepository.save(user);

        if(request.address() != null) {
            addressService.add(result.getId(), request.address());
        }

        return getEntityVo(userRepository.save(result));
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public UserVo update(Long id, @Valid UserDto request) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("User not found"));

        if(userRepository.findByEmail(request.email()).orElse(new User()).equals(user)) {
            throw new BadRequestException("Email already exists");
        } else if(userRepository.findByUsername(request.username()).orElse(new User()).equals(user)) {
            throw new BadRequestException("Username already exists");
        } else if(userRepository.findByPhone(request.phone()).orElse(new User()).equals(user)) {
            throw new BadRequestException("Phone number already exists");
        }

        BeanUtils.copyProperties(request, user);
        if(request.address() != null) {
            Address address = addressRepository.findById(user.getAddress().getId()).orElse(new Address());
            BeanUtils.copyProperties(address, request.address());
            addressRepository.save(address);
        }

        User result = userRepository.save(user);
        keyCloakService.updateUser(result);

        return getEntityVo(result);
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

    public boolean resetPassword(@Valid AccountResetPasswordDto request) {
        return keyCloakService.resetPassword(request);
    }
}
