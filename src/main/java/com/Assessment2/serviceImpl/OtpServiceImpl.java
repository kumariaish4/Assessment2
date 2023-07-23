package com.Assessment2.serviceImpl;

import com.Assessment2.service.OtpService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OtpServiceImpl implements OtpService {
    private static final int OTP_LENGTH = 6;

    @Override
    public String generateOTP() {
        // Generate a random OTP of specified length
        StringBuilder otpBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < OTP_LENGTH; i++) {
            otpBuilder.append(random.nextInt(10));
        }

        return otpBuilder.toString();
    }
}

