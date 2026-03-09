package io.github.nhatteam.jeri.service.repository.nosql;

import io.github.nhatteam.jeri.service.entity.nosql.PrivateChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivateChatRoomRepository extends MongoRepository<PrivateChatRoom, Long> {
    List<PrivateChatRoom> findByFriendIdOrderByCreatedAtDesc(Long friendId);
}
