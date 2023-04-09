package com.epam.jmp.service.api;

import com.epam.jmp.dto.model.BankCard;
import com.epam.jmp.dto.model.User;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Flow.Subscription;

public interface Service {

    void subscribe(BankCard bankCard);
    Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);
    List<User> getAllUsers();

}
