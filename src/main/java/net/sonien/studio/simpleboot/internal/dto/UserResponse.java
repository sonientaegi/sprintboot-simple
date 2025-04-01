package net.sonien.studio.simpleboot.internal.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserResponse {
    // https://zzang9ha.tistory.com/380#google_vignette

    @JsonProperty("아이디")
    private final int id;

    @JsonProperty("이름")
    private final String name;

    @JsonProperty("이메일")
    private final String email;
}
