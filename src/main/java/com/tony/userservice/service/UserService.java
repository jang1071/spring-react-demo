package com.tony.userservice.service;

import com.tony.userservice.domain.User;
import com.tony.userservice.dto.UserRequest;
import com.tony.userservice.dto.UserResponse;
import com.tony.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse createUser(UserRequest request) {
        User savedUser = userRepository.save(User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .password(request.getPassword())
                .build());

        return UserResponse.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .name(savedUser.getName())
                .build();

    }
}
