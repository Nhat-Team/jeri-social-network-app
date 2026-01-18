package io.github.nhatteam.project.core.service;

import io.github.nhatteam.project.core.model.vo.BaseVo;

import java.util.List;

public interface IService<S extends Record, P extends Number> {

    <R extends BaseVo> R add(S request);

    <R extends BaseVo> R update(P id, S request);

    <R extends BaseVo> R delete(P id);

    <R extends BaseVo> R getById(P id);

    <R extends BaseVo> List<R> getAll();
}
