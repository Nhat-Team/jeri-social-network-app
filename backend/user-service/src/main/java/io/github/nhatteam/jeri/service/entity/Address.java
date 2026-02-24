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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false) @NonNull
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

    public Address(String note, @NonNull User user, String street, String ward, String district, String city, String country, Integer postalCode) {
        super(note);
        this.user = user;
        this.street = street;
        this.ward = ward;
        this.district = district;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }
}
