package io.github.nhatteam.jeri.service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "addresses")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Address extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "id") @JoinColumn(name = "user_id", nullable = false) @NonNull
    User user;

    @Column(name = "street", length = 50)
    String street;

    @Column(name = "ward", length = 50)
    String ward;

    @Column(name = "district", length = 50)
    String district;

    @Column(name = "city", length = 50)
    String city;

    @Column(name = "country", length = 50)
    String country;

    @Column(name = "postal_code")
    Integer postalCode;
}
