package io.github.nhatteam.jeri.service.repository.mongodb;

import io.github.nhatteam.jeri.service.entity.mongodb.Friend;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends MongoRepository<Friend, Long> {

}
