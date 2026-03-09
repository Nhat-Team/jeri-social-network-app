package io.github.nhatteam.jeri.service.controller;

import io.github.nhatteam.jeri.service.model.dto.GroupMemberDto;
import io.github.nhatteam.jeri.service.service.GroupMemberService;
import io.github.nhatteam.project.core.controller.IController;
import io.github.nhatteam.project.core.model.vo.BaseVo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/group-members")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class GroupMemberController implements IController<GroupMemberDto, Long> {

    GroupMemberService groupMemberService;

    @Override
    public ResponseEntity<? extends BaseVo> add(GroupMemberDto request) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<? extends BaseVo> update(Long id, GroupMemberDto request) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<? extends BaseVo> delete(Long id) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<? extends BaseVo> getById(Long id) throws Exception {
        return null;
    }

    @Override
    public <R extends BaseVo> ResponseEntity<List<R>> getAll() throws Exception {
        return null;
    }
}
