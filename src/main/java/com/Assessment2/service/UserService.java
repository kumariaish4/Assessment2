package com.Assessment2.service;
import com.Assessment2.payload.UserDto;

public interface UserService {
    UserDto getUserById(Long id);
    UserDto getUserByUsername(String username);
    UserDto saveUser(UserDto userDto);
    void generateAndSaveOTP(UserDto userDto);
    boolean validateOTP(UserDto userDto, String otp);
}
