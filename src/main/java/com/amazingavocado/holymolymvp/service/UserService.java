package com.amazingavocado.holymolymvp.service;

import com.amazingavocado.holymolymvp.dto.UserDto;
import com.amazingavocado.holymolymvp.model.User;
import com.amazingavocado.holymolymvp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(UserDto userDto) {
        User user = User.builder()
                .age(userDto.getAge())
                .gender(userDto.getGender())
                .region(userDto.getRegion()).build();
        return userRepository.save(user);
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }
}
