package org.georgi.shop.repository;

import org.georgi.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByFirstNameAndLastName(String firstName, String lastName);
    User findByEmail(String email);
    User findByUsername(String username);
}
