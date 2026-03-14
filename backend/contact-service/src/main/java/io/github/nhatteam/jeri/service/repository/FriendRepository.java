package io.github.nhatteam.jeri.service.repository;

import io.github.nhatteam.jeri.service.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {
}
