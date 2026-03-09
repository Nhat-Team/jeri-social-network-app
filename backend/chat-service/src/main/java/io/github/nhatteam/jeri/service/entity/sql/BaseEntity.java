package io.github.nhatteam.jeri.service.entity.sql;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@DynamicInsert @DynamicUpdate
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "note", length = 200)
    String note;

    @Column(name = "status", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    Boolean status;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    Instant createdAt;

    @LastModifiedDate
    @Column(name = "last_modified_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    Instant lastModifiedAt;

    @CreatedBy
    @Column(name = "created_by", length = 50, nullable = false, updatable = false, columnDefinition = "VARCHAR(50) DEFAULT 'system'")
    String createdBy;

    @LastModifiedBy
    @Column(name = "last_modified_by", length = 50, nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'system' ON UPDATE 'system'")
    String lastModifiedBy;

    @Version @Column(name = "version", nullable = false, columnDefinition = "BIGINT DEFAULT 0")
    Long version;
}
