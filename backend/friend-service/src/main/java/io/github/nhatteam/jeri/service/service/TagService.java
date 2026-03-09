package io.github.nhatteam.jeri.service.service;

import io.github.nhatteam.jeri.service.entity.sql.Tag;
import io.github.nhatteam.jeri.service.mapper.TagMapper;
import io.github.nhatteam.jeri.service.model.dto.TagDto;
import io.github.nhatteam.jeri.service.model.vo.TagVo;
import io.github.nhatteam.jeri.service.repository.sql.TagRepository;
import io.github.nhatteam.project.core.exception.QueryNotFoundException;
import io.github.nhatteam.project.core.service.IService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TagService implements IService<TagDto, Long> {

    TagRepository tagRepository;
    TagMapper tagMapper;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public TagVo add(TagDto request) {
        Tag tag = tagMapper.toEntity(request);
        return toVo(tagRepository.save(tag));
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public TagVo update(Long id, TagDto request) {
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Tag not found with id: " + id));
        BeanUtils.copyProperties(request, tag);
        return toVo(tagRepository.save(tag));
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public TagVo delete(Long id) {
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Tag not found with id: " + id));
        tag.setDeleted(true);
        return toVo(tagRepository.save(tag));
    }

    @Override
    public TagVo getById(Long id) {
        return toVo(tagRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Tag not found with id: " + id)));
    }

    @Override
    public List<TagVo> getAll() {
        return tagRepository.findAll().stream().map(this::toVo).toList();
    }

    private TagVo toVo(Tag tag) {
        TagVo tagVo = tagMapper.toVo(tag);
        return tagVo;
    }
}
