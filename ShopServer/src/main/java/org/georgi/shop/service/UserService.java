package org.georgi.shop.service;

import org.georgi.shop.exception.ResourceNotFoundException;
import org.georgi.shop.model.User;
import org.georgi.shop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
                       ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.modelMapper = modelMapper;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User createUser(User u) {
        u.setPassword(this.bCryptPasswordEncoder.encode(u.getPassword()));
        return this.userRepository.save(u);
    }

    public User getUserById(long id) {
        return this.userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User with id { " + String.valueOf(id) + " } not found."));
    }

    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }
}
