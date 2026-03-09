package io.github.nhatteam.jeri.service.controller;

import io.github.nhatteam.jeri.service.model.dto.AccountLogin;
import io.github.nhatteam.jeri.service.model.dto.UserDto;
import io.github.nhatteam.jeri.service.model.vo.UserVo;
import io.github.nhatteam.jeri.service.service.AuthService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthController {

    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(@Valid @RequestBody AccountLogin accountLogin) {
        return ResponseEntity.ok(authService.login(accountLogin));
    }

    @PostMapping("/register")
    public ResponseEntity<UserVo> registerAccount(@Valid @RequestBody UserDto request) throws Exception {
        return ResponseEntity.ok(authService.registerAccount(request));
    }
}
