package io.github.nhatteam.jeri.service.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
@NoArgsConstructor
public abstract class BaseEntity {

    @Id @Field(name = "id", targetType = FieldType.INT64)
    Long id;

    @Field(name = "note", targetType = FieldType.STRING)
    String note;

    @Field(name = "status", targetType = FieldType.BOOLEAN, value = "true")
    Boolean status;

    @CreatedDate
    @Field(name = "created_at", targetType = FieldType.TIMESTAMP)
    Instant createdAt;

    @LastModifiedDate
    @Field(name = "last_modified_at", targetType = FieldType.TIMESTAMP)
    Instant lastModifiedAt;

    @CreatedBy
    @Field(name = "created_by", targetType = FieldType.STRING)
    String createdBy;

    @LastModifiedBy
    @Field(name = "last_modified_by", targetType = FieldType.STRING)
    String lastModifiedBy;

    public BaseEntity(String note) {
        this.note = note;
        this.status = Boolean.TRUE;
    }
}
