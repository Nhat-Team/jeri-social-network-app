package io.github.nhatteam.jeri.service.controller.socket;

import io.github.nhatteam.jeri.service.model.dto.GroupChatRoomDto;
import io.github.nhatteam.jeri.service.model.dto.PrivateChatRoomDto;
import io.github.nhatteam.jeri.service.model.vo.GroupChatRoomVo;
import io.github.nhatteam.jeri.service.model.vo.PrivateChatRoomVo;
import io.github.nhatteam.jeri.service.service.GroupChatRoomService;
import io.github.nhatteam.jeri.service.service.PrivateChatRoomService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller(value = "/private-chat")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ChatRoomSocket {

    PrivateChatRoomService privateChatRoomService;
    GroupChatRoomService groupChatRoomService;

    @MessageMapping("/private/send-message")
    @SendTo("/private/receive-message")
    public PrivateChatRoomVo sendAndGetMessagePrivateChat(@Valid @Payload PrivateChatRoomDto request) throws Exception {
        return privateChatRoomService.add(request);
    }

    @MessageMapping("/group/send-message")
    @SendTo("/group/receive-message")
    public GroupChatRoomVo sendAndGetMessageGroupChat(@Valid @Payload GroupChatRoomDto request) throws Exception {
        return groupChatRoomService.add(request);
    }
}
