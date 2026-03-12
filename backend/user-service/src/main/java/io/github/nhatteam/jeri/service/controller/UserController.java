package io.github.nhatteam.jeri.service.controller;

import io.github.nhatteam.jeri.service.model.dto.AccountResetPasswordDto;
import io.github.nhatteam.jeri.service.model.dto.UserDto;
import io.github.nhatteam.jeri.service.model.vo.UserVo;
import io.github.nhatteam.jeri.service.service.UserService;
import io.github.nhatteam.project.core.controller.IController;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController implements IController<UserDto, Long> {

    UserService userService;

    @Override
    @PostMapping("/register")
    public ResponseEntity<UserVo> add(@RequestBody UserDto request) throws Exception {
        return ResponseEntity.ok(userService.add(request));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<UserVo> update(@PathVariable Long id, @RequestBody UserDto request) throws Exception {
        return ResponseEntity.ok(userService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<UserVo> delete(@PathVariable Long id) {
        return ResponseEntity.ok(userService.delete(id));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<UserVo> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<List<UserVo>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping("/reset-password")
    public ResponseEntity<Boolean> resetPassword(@Valid @RequestBody AccountResetPasswordDto request) {
        return ResponseEntity.ok(userService.resetPassword(request));
    }
}
