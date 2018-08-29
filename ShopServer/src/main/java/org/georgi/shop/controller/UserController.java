package org.georgi.shop.controller;

import org.georgi.shop.dto.CompactUserDTO;
import org.georgi.shop.dto.CreateUserDTO;
import org.georgi.shop.dto.UserDTO;
import org.georgi.shop.model.User;
import org.georgi.shop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService userService;

    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllUsers() {
        List<User> allUsers = this.userService.getAllUsers();

        return allUsers.stream()
                       .map(user -> this.modelMapper.map(user, UserDTO.class))
                       .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById(@PathVariable("id") long userId) {
        return this.modelMapper.map(this.userService.getUserById(userId), UserDTO.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompactUserDTO createUser(@RequestBody @Valid CreateUserDTO user) {
        User createdUser = this.userService.createUser(this.modelMapper.map(user, User.class));

        return this.modelMapper.map(createdUser, CompactUserDTO.class);
    }

}
