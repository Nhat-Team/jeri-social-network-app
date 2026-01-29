package io.github.nhatteam.jeri.service.repository;

import io.github.nhatteam.jeri.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
