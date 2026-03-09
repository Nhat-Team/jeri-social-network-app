package io.github.nhatteam.jeri.service.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public enum UserGender {

    MALE("Male"), FEMALE("Female"), OTHER("Other"), UNSPECIFIED("Unspecified"), LGBTQ("LGBTQ+");

    String genderName;
}
