package io.github.nhatteam.jeri.service.repository.mongodb;

import io.github.nhatteam.jeri.service.entity.mongodb.Friend;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends MongoRepository<Friend, Long> {

    @Query(value = """
            {
                $or: [
                    { "userId": ?0 },
                    { "friendId": ?0 }
                ]
            }
            """)
    List<Friend> getFriendsFromUser(Long userId);
}
