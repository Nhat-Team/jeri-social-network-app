package io.github.nhatteam.project.core.controller;

import io.github.nhatteam.project.core.model.vo.BaseVo;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IController<S extends Record, P extends Number> {

    ResponseEntity<? extends BaseVo> add(S request) throws Exception;

    ResponseEntity<? extends BaseVo> update(P id, S request) throws Exception;

    ResponseEntity<? extends BaseVo> delete(P id) throws Exception;

    ResponseEntity<? extends BaseVo> getById(P id) throws Exception;

    <R extends BaseVo> ResponseEntity<List<R>> getAll() throws Exception;

    default ResponseEntity<? extends BaseVo> uploadFile(P id, MultipartFile file) throws Exception {
        return ResponseEntity.ok(null);
    }

    default ResponseEntity<? extends BaseVo> deleteFile(P id) throws Exception {
        return ResponseEntity.ok(null);
    }
}
