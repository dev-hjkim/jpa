package com.example.jpa.account;

import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class Account2RepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void crud() {
        QAccount2 account2 = QAccount2.account2;
        Predicate predicate = account2
                .firstName.containsIgnoreCase("h")
                .and(account2.lastName.startsWith("k"));

        Optional<Account2> one = accountRepository.findOne(predicate);
        assertThat(one).isEmpty();
    }

}