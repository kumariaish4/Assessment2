package com.Assessment2.payload;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OtpDto {
    private Long id;
    private String recipient;
    private String otpCode;
    private LocalDateTime expiryDateTime;
}
