package io.github.nhatteam.jeri.service.controller;

import io.github.nhatteam.jeri.service.model.dto.TagDto;
import io.github.nhatteam.jeri.service.model.vo.TagVo;
import io.github.nhatteam.jeri.service.service.TagService;
import io.github.nhatteam.project.core.controller.IController;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TagController implements IController<TagDto, Long> {
    
    TagService tagService;

    @PostMapping("/")
    @Override
    public ResponseEntity<TagVo> add(@RequestBody @Valid TagDto request) {
        return ResponseEntity.ok(tagService.add(request));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<TagVo> update(@PathVariable Long id, @RequestBody @Valid TagDto request) {
        return ResponseEntity.ok(tagService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<TagVo> delete(@PathVariable Long id) {
        return ResponseEntity.ok(tagService.delete(id));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<TagVo> getById(@PathVariable Long id) {
        return ResponseEntity.ok(tagService.getById(id));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<TagVo>> getAll() {
        return ResponseEntity.ok(tagService.getAll());
    }
}
