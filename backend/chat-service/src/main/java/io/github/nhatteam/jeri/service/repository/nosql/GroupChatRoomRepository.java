package io.github.nhatteam.jeri.service.repository.nosql;

import io.github.nhatteam.jeri.service.entity.nosql.GroupChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupChatRoomRepository extends MongoRepository<GroupChatRoom, Long> {
}
