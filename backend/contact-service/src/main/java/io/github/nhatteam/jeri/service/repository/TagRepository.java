package io.github.nhatteam.jeri.service.repository;

import io.github.nhatteam.jeri.service.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
