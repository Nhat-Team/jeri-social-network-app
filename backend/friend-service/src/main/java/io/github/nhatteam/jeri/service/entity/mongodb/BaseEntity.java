package io.github.nhatteam.jeri.service.entity.mongodb;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {

    @Id @Field(name = "id", targetType = FieldType.INT64)
    Long id;

    @Field(name = "note", targetType = FieldType.STRING)
    String note;

    @Field(name = "deleted", targetType = FieldType.BOOLEAN)
    Boolean deleted;

    @CreatedDate
    @Field(name = "created_at", targetType = FieldType.TIMESTAMP)
    Instant createdAt;

    @LastModifiedDate @Field(name = "last_modified_at", targetType = FieldType.TIMESTAMP)
    Instant lastModifiedAt;

    @CreatedBy @Field(name = "created_by", targetType = FieldType.STRING)
    String createdBy;

    @LastModifiedBy @Field(name = "last_modified_by", targetType = FieldType.STRING)
    String lastModifiedBy;

    @Version @Field(name = "version", targetType = FieldType.INT64)
    Long version;
}
