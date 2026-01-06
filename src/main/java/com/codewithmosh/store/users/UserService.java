package com.codewithmosh.store.users;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    public Iterable<UserDto> getAllUsers(String sortBy) {

        if (!Set.of("name", "email").contains(sortBy))
            sortBy = "name";


        return userRepository.findAll(Sort.by(sortBy))
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserDto getUser(Long userId) {
        var user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User was not found"));
        return userMapper.toDto(user);
    }

    public UserDto registerUser(RegisterUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateUserException();
        }
        var user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);

        return userMapper.toDto(user);
    }

    public UserDto updateUser(Long userId, UpdateUserRequest request) {
        var user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found"));

        userMapper.update(request, user);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public void deleteUser(Long userId) {
        var user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found"));
        userRepository.delete(user);
    }

    public void changePassword(ChangePasswordRequest request, Long userId) {
        var user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found"));

        if (!passwordEncoder.matches(request.getOldPassword(),user.getPassword())) {
            throw new AccessDeniedException("password does not match");
        }
        user.setPassword(request.getNewPassword());
        userRepository.save(user);
    }

}