package net.sonien.studio.simpleboot.internal.controller;

import lombok.RequiredArgsConstructor;
import net.sonien.studio.simpleboot.internal.dto.UserDto;
import net.sonien.studio.simpleboot.internal.dto.UserDtoMapper;
import net.sonien.studio.simpleboot.internal.dto.UserRequest;
import net.sonien.studio.simpleboot.internal.dto.UserResponse;
import net.sonien.studio.simpleboot.internal.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AccountService accountService;

    // https://mapstruct.org/documentation/stable/reference/html/#retrieving-mapper
    private final UserDtoMapper userDtoMapper = UserDtoMapper.INSTANCE;

    // https://hello-judy-world.tistory.com/217
    @GetMapping("/api/v1/user")
    public List<UserResponse> getUserAll() {
        List<UserDto> users = this.accountService.getUserAll();
        return users.stream().map(userDtoMapper::toResponse).toList();
    }

    @GetMapping("/api/v1/user/{id}")
    public UserResponse getUser(@PathVariable int id) {
        UserDto user = this.accountService.getUser(id);
        return this.userDtoMapper.toResponse(user);
    }

    @PutMapping("/api/v1/user/{id}")
    public UserResponse updateUser(@PathVariable int id, @RequestBody UserRequest request) {
        UserDto user = this.userDtoMapper.fromRequest(request);
        return this.userDtoMapper.toResponse(this.accountService.updateUser(id, user));
    }

    @PostMapping("/api/v1/user")
    public UserResponse createUser(@RequestBody UserRequest request) {
        return this.userDtoMapper.toResponse(this.accountService.createUser(this.userDtoMapper.fromRequest(request)));
    }

}
