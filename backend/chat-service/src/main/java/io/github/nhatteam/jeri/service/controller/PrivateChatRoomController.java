package io.github.nhatteam.jeri.service.controller;

import io.github.nhatteam.jeri.service.model.vo.PrivateChatRoomVo;
import io.github.nhatteam.jeri.service.service.PrivateChatRoomService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/private-chat-rooms")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PrivateChatRoomController {

    PrivateChatRoomService privateChatRoomService;

    @PostMapping(value = "/upload-attachments/{messageId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PrivateChatRoomVo> uploadAttachments(@PathVariable Long messageId, @RequestPart MultipartFile[] attachments) throws Exception {
        return ResponseEntity.ok(privateChatRoomService.uploadFiles(messageId, attachments));
    }
}
