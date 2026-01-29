package io.github.nhatteam.project.core.controller;

import io.github.nhatteam.project.core.model.vo.BaseVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IController<S extends Record, P extends Number> {

    ResponseEntity<? extends BaseVo> add(S request);

    ResponseEntity<? extends BaseVo> update(P id, S request);

    ResponseEntity<? extends BaseVo> delete(P id);

    ResponseEntity<? extends BaseVo> getById(P id);

    <R extends BaseVo> ResponseEntity<List<R>> getAll();

    default ResponseEntity<? extends BaseVo> uploadFile(P id, MultipartFile file) {
        return ResponseEntity.ok(null);
    }

    default ResponseEntity<? extends BaseVo> deleteFile(P id) {
        return ResponseEntity.ok(null);
    }
}
