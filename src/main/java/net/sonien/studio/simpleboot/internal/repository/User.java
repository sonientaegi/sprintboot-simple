package net.sonien.studio.simpleboot.internal.repository;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class User {
    private Integer id;
    private String name;
    private String email;
    private String session;
}
