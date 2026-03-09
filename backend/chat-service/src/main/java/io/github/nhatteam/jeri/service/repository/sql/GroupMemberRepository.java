package io.github.nhatteam.jeri.service.repository.sql;

import io.github.nhatteam.jeri.service.entity.sql.GroupMember;
import io.github.nhatteam.jeri.service.enums.GroupMemberRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {
    List<GroupMember> findByGroupId_Id(Long id);

    @Query("""
            SELECT gm FROM GroupMember gm
            WHERE gm.userId = :userId AND gm.groupId = :groupId AND (gm.role = 'OWNER' OR gm.role = 'CO_OWNER') 
            """)
    Optional<GroupMember> findByUserFollowStaff(Long userId, Long groupId);
}
