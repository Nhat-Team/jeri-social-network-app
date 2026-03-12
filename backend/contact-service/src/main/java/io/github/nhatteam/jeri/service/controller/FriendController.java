package io.github.nhatteam.jeri.service.controller;

import io.github.nhatteam.jeri.service.enums.FriendStatus;
import io.github.nhatteam.jeri.service.model.dto.FriendDto;
import io.github.nhatteam.jeri.service.model.vo.FriendVo;
import io.github.nhatteam.jeri.service.service.FriendService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/friend")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class FriendController {

    FriendService friendService;

    @PostMapping("/")
    public ResponseEntity<FriendVo> addFriend(@Valid @RequestBody FriendDto request) {
        return ResponseEntity.ok(friendService.add(request));
    }

    @PutMapping("/message-request")
    public ResponseEntity<FriendVo> updateFriendMessageRequest(@RequestParam("friendId") Long friendId,
                                                               @RequestParam("messageRequest") String messageRequest) {
        return ResponseEntity.ok(friendService.updateFriendMessageRequest(friendId, messageRequest));
    }

    @PutMapping("/friend-status")
    public ResponseEntity<FriendVo> updateFriendStatus(
            @RequestParam Long friendId,
            @RequestParam FriendStatus status) {
        return ResponseEntity.ok(friendService.updateFriendStatus(friendId, status));
    }

    @GetMapping("/friends/{userId}")
    public ResponseEntity<List<FriendVo>> getAllFriends(@PathVariable Long userId) {
        return ResponseEntity.ok(friendService.getAllFriends(userId));
    }
}
