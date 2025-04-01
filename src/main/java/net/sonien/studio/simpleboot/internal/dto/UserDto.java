package net.sonien.studio.simpleboot.internal.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {
    @Setter(AccessLevel.PACKAGE)
    private Integer id;
    private String name;
    private String email;
}
