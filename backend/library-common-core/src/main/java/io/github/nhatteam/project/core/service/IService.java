package io.github.nhatteam.project.core.service;

import io.github.nhatteam.project.core.model.vo.BaseVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IService<S extends Record, P extends Number> {

    BaseVo add(S request) throws Exception;

    BaseVo update(P id, S request) throws Exception;

    BaseVo delete(P id) throws Exception;

    BaseVo getById(P id) throws Exception;

    <R extends BaseVo> List<R> getAll() throws Exception;

    default BaseVo uploadFile(Long id, MultipartFile file) throws Exception {
        return null;
    }

    default BaseVo deleteFile(Long id) throws Exception {
        return null;
    }
}
