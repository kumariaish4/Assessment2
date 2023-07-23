package com.Assessment2.serviceImpl;

import com.Assessment2.entities.User;
import com.Assessment2.payload.UserDto;
import com.Assessment2.repositories.UserRepository;
import com.Assessment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return userToDto(user);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return userToDto(user);
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = dtoToUser(userDto);
        user = userRepository.save(user);
        return userToDto(user);
    }

    @Override
    public void generateAndSaveOTP(UserDto userDto) {
        // Implement your logic here to generate and save the OTP to the userDto object
        // You can use a random generator library or any other method of your choice

        // For simplicity, let's assume the OTP is "123456"
        userDto.setOtp("123456");
    }

    @Override
    public boolean validateOTP(UserDto userDto, String otp) {
        // Implement your logic here to validate the OTP entered by the user
        // For this example, we'll simply compare the OTP with the userDto's stored OTP.

        String storedOTP = userDto.getOtp();
        return storedOTP != null && storedOTP.equals(otp);
    }

    private User dtoToUser(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }

    private UserDto userToDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
