package net.sonien.studio.simpleboot.internal.repository;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class User {
    @Setter(AccessLevel.PACKAGE)
    private Integer id;
    private String name;
    private String email;
    private String session;
}
