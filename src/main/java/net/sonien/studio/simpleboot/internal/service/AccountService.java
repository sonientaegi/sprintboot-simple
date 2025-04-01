package net.sonien.studio.simpleboot.internal.service;

import lombok.RequiredArgsConstructor;
import net.sonien.studio.simpleboot.internal.dto.UserDto;
import net.sonien.studio.simpleboot.internal.dto.UserDtoMapper;
import net.sonien.studio.simpleboot.internal.repository.User;
import net.sonien.studio.simpleboot.internal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final UserRepository userRepository;

    // https://mapstruct.org/documentation/stable/reference/html/#retrieving-mapper
    private final UserDtoMapper userDtoMapper = UserDtoMapper.INSTANCE;


    /**
     * 전체 사용자 조회
     * @return
     */
    public List<UserDto> getUserAll() {
        return userRepository.findAll().stream().map(userDtoMapper::fromEntity).toList();
    }

    /**
     * 사용자 조회
     * @param id
     * @return
     */
    public UserDto getUser(int id) {
        User user = userRepository.findById(id).orElseThrow();

        return this.userDtoMapper.fromEntity(user);
    }

    /**
     * 사용자 조회
     * @param name
     * @return
     */
    public List<UserDto> getUserByName(String name) {
        return this.userRepository.findByName(name).stream().map(this.userDtoMapper::fromEntity).toList();
    }

    /**
     * 사용자 생성
     * @param userDto
     * @return
     */
    public UserDto createUser(UserDto userDto) {
        User user = this.userDtoMapper.toEntity(userDto);
        return this.userDtoMapper.fromEntity(this.userRepository.create(user).orElseThrow());
    }

    /**
     * 사용자 수정
     * @param userDto
     * @return
     */
    public UserDto updateUser(int id, UserDto userDto) {
        User user = this.userDtoMapper.toEntity(userDto);
        return this.userDtoMapper.fromEntity(this.userRepository.update(id, user).orElseThrow());
    }

    /**
     * 사용자 삭제
     * @param id
     */
    public void deleteUser(int id) {
        User user = this.userRepository.findById(id).orElseThrow();
        this.userRepository.delete(id);
    }
}
