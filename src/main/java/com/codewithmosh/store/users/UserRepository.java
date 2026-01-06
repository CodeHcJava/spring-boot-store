package com.codewithmosh.store.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    List<User> getUserByName(String name);

    Optional<User> findByEmail(String email);

    String email(String email);
}
