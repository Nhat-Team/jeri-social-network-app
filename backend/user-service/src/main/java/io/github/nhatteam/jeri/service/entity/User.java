package io.github.nhatteam.jeri.service.entity;

import io.github.nhatteam.jeri.service.enums.UserGender;
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

@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Column(name = "user_id", nullable = false, unique = true) @NonNull
    String userId;

    @Column(name = "first_name", length = 50, nullable = false)
    @NonNull
    String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    @NonNull
    String lastName;

    @Column(name = "birth_date", nullable = false)
    @NonNull
    LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    @NonNull
    UserGender gender;

    @Column(name = "phone", length = 30, nullable = false, unique = true)
    @NonNull
    String phone;

    @Column(name = "email", length = 150, nullable = false, unique = true)
    @NonNull
    String email;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    @NonNull
    String username;

    @Column(name = "avatar", length = 100)
    String avatar;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Address address;

    public User(String note, @NonNull String userId, @NonNull String firstName, @NonNull String lastName, @NonNull LocalDate birthDate, @NonNull UserGender gender, @NonNull String phone, @NonNull String email, @NonNull String username, String avatar, Address address) {
        super(note);
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.avatar = avatar;
        this.address = address;
    }
}
