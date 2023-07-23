package com.Assessment2.repositories;

import com.Assessment2.entities.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepository extends JpaRepository<Otp, Long> {
   // Otp findByRecipientAndCode(String recipient, String code);
}

