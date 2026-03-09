package io.github.nhatteam.jeri.service.service;

import io.github.nhatteam.jeri.service.model.dto.AccountLogin;
import io.github.nhatteam.jeri.service.model.dto.UserDto;
import io.github.nhatteam.jeri.service.model.vo.UserVo;
import io.github.nhatteam.jeri.service.service.external.KeyCloakService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthService {

    UserService userService;
    KeyCloakService keyCloakService;

    @Transactional(rollbackFor = Exception.class)
    public UserVo registerAccount(UserDto request) throws Exception {
        UserVo result = userService.add(request);
        keyCloakService.createUser(request, result.getUserId());
        return result;
    }

    public Map<String,Object> login(@Valid AccountLogin accountLogin) {
        return keyCloakService.loginAccount(accountLogin);
    }
}
