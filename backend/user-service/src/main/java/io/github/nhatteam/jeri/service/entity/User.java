package io.github.nhatteam.jeri.service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;

@Entity @Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Column(name = "first_name", length = 50, nullable = false) @NonNull
    String firstName;

    @Column(name = "last_name", length = 50, nullable = false) @NonNull
    String lastName;

    @Column(name = "birth_date", nullable = false) @NonNull
    LocalDate birthDate;

    @Column(name = "phone", length = 30, nullable = false, unique = true) @NonNull
    String phone;

    @Column(name = "email", length = 150, nullable = false, unique = true) @NonNull
    String email;

    @Column(name = "username", length = 50, nullable = false, unique = true) @NonNull
    String username;

    @Column(name = "avatar", length = 100)
    String avatar;

    @OneToOne(mappedBy = "user")
    Address address;
}
