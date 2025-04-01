package net.sonien.studio.simpleboot.internal.repository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

// 자바 표준 예외
// https://docs.oracle.com/en/java/javase/21/docs/api/java.sql/java/sql/SQLDataException.html

// 표준 SQL 오류 리스트
// https://www.ibm.com/docs/ko/i/7.3?topic=codes-listing-sqlstate-values
public interface UserRepository {
    List<User> findAll();
    Optional<User> findById(int id);
    List<User> findByName(String name);
    Optional<User> create(User user);
    Optional<User> update(int id, User user);
    Optional<User> delete(int id);
}
