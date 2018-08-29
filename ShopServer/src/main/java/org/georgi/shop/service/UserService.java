package org.georgi.shop.service;

import org.georgi.shop.exception.ResourceNotFoundException;
import org.georgi.shop.model.User;
import org.georgi.shop.repository.UserRepository;
import org.georgi.shop.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User createUser(User u) {
        return this.userRepository.save(u);
    }

    public User getUserById(long id) {
        return this.userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User with id { " + String.valueOf(id) + " } not found."));
    }

    public User updateUser(long id, User u) {
        User foundUser = getUserById(id);

        return this.userRepository.save(ServiceUtil.updateEntityProperties(u, foundUser));
    }

    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }
}
