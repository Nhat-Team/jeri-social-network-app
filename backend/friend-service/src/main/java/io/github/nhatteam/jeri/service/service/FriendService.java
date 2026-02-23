package io.github.nhatteam.jeri.service.service;

import io.github.nhatteam.jeri.service.entity.mongodb.Friend;
import io.github.nhatteam.jeri.service.enums.FriendStatus;
import io.github.nhatteam.jeri.service.mapper.FriendMapper;
import io.github.nhatteam.jeri.service.model.dto.FriendDto;
import io.github.nhatteam.jeri.service.model.vo.FriendVo;
import io.github.nhatteam.jeri.service.repository.mongodb.FriendRepository;
import io.github.nhatteam.project.core.exception.QueryNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class FriendService {

    FriendRepository friendRepository;
    FriendMapper friendMapper;

    public FriendVo add(FriendDto request) {
        Friend friend = friendMapper.toEntity(request);
        friend.setStatus(FriendStatus.WAITING_RESPONSE);
        return getVo(friendRepository.save(friend));
    }

    public FriendVo updateFriendMessageRequest(Long friendId, String messageRequest) {
        Friend friend = friendRepository.findById(friendId).orElseThrow(() -> new QueryNotFoundException("Friend wasn't found in system"));
        friend.setMessageRequest(messageRequest);
        return getVo(friendRepository.save(friend));
    }

    public FriendVo updateFriendStatus(Long friendId, FriendStatus status) {
        Friend friend = friendRepository.findById(friendId).orElseThrow(() -> new QueryNotFoundException("Friend wasn't found in system"));
        friend.setStatus(status);
        return getVo(friendRepository.save(friend));
    }

    public List<FriendVo> getAllFriends(Long userId) {
        return friendRepository.findFriendByUser().stream().map(this::getVo).toList();
    }

    private FriendVo getVo(Friend friend) {
        return friendMapper.toVo(friend);
    }
}
