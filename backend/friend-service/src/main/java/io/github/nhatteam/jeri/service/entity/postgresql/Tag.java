package io.github.nhatteam.jeri.service.entity.postgresql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity @Table(name = "tags")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Tag extends BaseEntity {

    @Column(name = "tag_name", length = 100, nullable = false, unique = true) @NonNull
    String tagName;

    @Column(name = "description")
    String description;

    public Tag(String note, @NonNull String tagName, String description) {
        super(note);
        this.tagName = tagName;
        this.description = description;
    }
}
