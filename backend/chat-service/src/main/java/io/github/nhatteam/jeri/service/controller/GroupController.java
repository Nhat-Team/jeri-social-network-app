package io.github.nhatteam.jeri.service.controller;

import io.github.nhatteam.jeri.service.model.dto.GroupDto;
import io.github.nhatteam.jeri.service.model.vo.GroupVo;
import io.github.nhatteam.jeri.service.service.GroupService;
import io.github.nhatteam.project.core.controller.IController;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class GroupController implements IController<GroupDto, Long> {
    
    GroupService groupService;

    @PostMapping("/")
    @Override
    public ResponseEntity<GroupVo> add(@Valid @RequestBody GroupDto request) throws Exception {
        return ResponseEntity.ok(groupService.add(request));
    }

    @PostMapping(value = "/with-avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<GroupVo> addWithAvatar(@Valid @RequestBody GroupDto request, @RequestPart MultipartFile file) throws Exception {
        return ResponseEntity.ok(groupService.add(request, file));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<GroupVo> update(@PathVariable Long id, @Valid @RequestBody GroupDto request) throws Exception {
        return ResponseEntity.ok(groupService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<GroupVo> delete(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(groupService.delete(id));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<GroupVo> getById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(groupService.getById(id));
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<List<GroupVo>> getAll() {
        return ResponseEntity.ok(groupService.getAll());
    }

    @PutMapping(value = "/{id}/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<GroupVo> uploadFile(@PathVariable Long id, @RequestPart MultipartFile file) throws Exception {
        return ResponseEntity.ok(groupService.uploadFile(id, file));
    }

    @DeleteMapping("/{id}/avatar")
    @Override
    public ResponseEntity<GroupVo> deleteFile(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(groupService.deleteFile(id));
    }
}
