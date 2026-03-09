package io.github.nhatteam.jeri.service.repository.sql;

import io.github.nhatteam.jeri.service.entity.sql.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
