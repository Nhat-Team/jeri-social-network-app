package io.github.nhatteam.project.core.controller;

import io.github.nhatteam.project.core.model.vo.BaseVo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IController<S extends Record, P extends Number> {

    <R extends BaseVo> ResponseEntity<R> add(S request);

    <R extends BaseVo> ResponseEntity<R> update(P id, S request);

    <R extends BaseVo> ResponseEntity<R> delete(P id);

    <R extends BaseVo> ResponseEntity<R> getById(P id);

    <R extends BaseVo> ResponseEntity<List<R>> getAll();
}
