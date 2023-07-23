package com.Assessment2.controller;

import com.Assessment2.payload.UserDto;
import com.Assessment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = userService.getUserById(id);
        if (userDto != null) {
            return ResponseEntity.ok(userDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byUsername/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) {
        UserDto userDto = userService.getUserByUsername(username);
        if (userDto != null) {
            return ResponseEntity.ok(userDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUserDto = userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDto);
    }

    @PostMapping("/otp/generate")
    public ResponseEntity<Void> generateAndSaveOTP(@RequestBody UserDto userDto) {
        userService.generateAndSaveOTP(userDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/otp/validate")
    public ResponseEntity<String> validateOTP(@RequestBody UserDto userDto, @RequestParam String otp) {
        boolean isOTPValid = userService.validateOTP(userDto, otp);
        if (isOTPValid) {
            return ResponseEntity.ok("OTP validation successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP");
        }
    }
}
