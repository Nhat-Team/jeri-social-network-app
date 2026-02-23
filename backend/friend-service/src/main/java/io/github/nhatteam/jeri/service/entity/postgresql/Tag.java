package io.github.nhatteam.jeri.service.entity.postgresql;

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

}
