package net.sonien.studio.simpleboot.internal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    // https://hello-judy-world.tistory.com/217

    @NotBlank
    private String name;

    @Email
    private String email;
}
