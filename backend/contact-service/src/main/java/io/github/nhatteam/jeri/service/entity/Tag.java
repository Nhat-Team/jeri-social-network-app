package io.github.nhatteam.jeri.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "tags")
@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class Tag extends BaseEntity {

    @Column(name = "tag_name", length = 50, nullable = false) @NonNull
    String tagName;

    @Column(name = "color_hash_tag", length = 20, nullable = false) @NonNull
    String colorHashTag;
}
