package com.example.jpa;

import com.example.jpa.post4.Account4;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountAuditAware implements AuditorAware<Account4> {

    @Override
    public Optional<Account4> getCurrentAuditor() {
        System.out.println("Looking for current user");
        return Optional.empty();
    }
}
