package io.github.nhatteam.jeri.service.model.vo;

import io.github.nhatteam.project.core.model.vo.BaseVo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomVo extends BaseVo {

    Long senderId;

    String content;

    Map<String, String> attachmentLinks;

    Boolean isPinned;

    Boolean isRecall;
}
