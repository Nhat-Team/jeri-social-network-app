package io.github.nhatteam.project.core.service;

import io.github.nhatteam.project.core.model.vo.BaseVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IService<S extends Record, P extends Number> {

    BaseVo add(S request);

    BaseVo update(P id, S request);

    BaseVo delete(P id);

    BaseVo getById(P id);

    <R extends BaseVo> List<R> getAll();

    default BaseVo uploadFile(Long id, MultipartFile file) {
        return null;
    }

    default BaseVo deleteFile(Long id) {
        return null;
    }
}
