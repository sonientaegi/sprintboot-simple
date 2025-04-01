package net.sonien.studio.simpleboot.internal.repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();
    Optional<User> findById(int id);
    List<User> findByName(String name);
    Optional<User> create(User user);
    Optional<User> update(int id, User user);
    Optional<User> delete(int id);
}
