package io.github.nhatteam.jeri.service.repository.postgresql;

import io.github.nhatteam.jeri.service.entity.postgresql.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
