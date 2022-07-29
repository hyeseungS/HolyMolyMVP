package com.amazingavocado.holymolymvp.service;

import com.amazingavocado.holymolymvp.dto.UserDto;
import com.amazingavocado.holymolymvp.model.User;
import com.amazingavocado.holymolymvp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(UserDto userDto) {
        User user = User.builder()
                .age(Integer.parseInt(userDto.getAge()))
                .gender(Integer.parseInt(userDto.getGender()))
                .region(userDto.getRegion()).build();
        return userRepository.save(user);
    }
}
