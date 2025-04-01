package net.sonien.studio.simpleboot.internal.repository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import net.sonien.studio.simpleboot.util.exception.RepositoryEntityNotExistException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class UserRepositoryMockup implements UserRepository {
    private final Map<Integer, User> users = new LinkedHashMap<>();

    @PostConstruct
    public void init() {
        for (User user : List.of(
                User.builder().id(1).name("1니언").email("onien@gmail.com").build(),
                User.builder().id(2).name("2니언").email("twnien@gmail.com").build(),
                User.builder().id(3).name("3니언").email("thrnien@gmail.com").build(),
                User.builder().id(4).name("4니언").email("fournien@gmail.com").build()
        )) {
            this.users.put(user.getId(), user);
        }
    }

    @Override
    public List<User> findAll() {
        return this.users.values().stream().toList();
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.ofNullable(this.users.get(id));
    }

    @Override
    public List<User> findByName(String name) {
        return this.users.values().stream().filter(user -> user.getName().equals(name)).toList();
    }

    @Override
    public Optional<User> create(User user) {
        int nextId = this.users.keySet().stream().max(Integer::compareTo).orElse(0) + 1;
        user.setId(nextId);
        this.users.put(user.getId(), user);

        return Optional.of(user);
    }

    @Override
    public Optional<User> update(int id, User user) {
        User target = this.users.get(id);
        if (target == null) {
            throw new RepositoryEntityNotExistException("USER", id);
        } else {
            user.setId(id);
            this.users.put(user.getId(), user);
            return Optional.of(user);
        }
    }

    @Override
    public Optional<User> delete(int id) {
        User user = this.users.remove(id);
        if (user == null) {
            throw new RepositoryEntityNotExistException("USER", id);
        } else {
            return Optional.of(user);
        }
    }
}
