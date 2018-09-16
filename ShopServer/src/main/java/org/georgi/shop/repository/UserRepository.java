package org.georgi.shop.repository;

import org.georgi.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByFirstNameAndLastName(String firstName, String lastName);
    User findByEmail(String email);
    User findByUsername(String username);
    void deleteByUsername(String username);
}
