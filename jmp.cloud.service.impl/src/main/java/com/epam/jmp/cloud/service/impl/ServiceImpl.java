package com.epam.jmp.cloud.service.impl;

import com.epam.jmp.dto.model.BankCard;
import com.epam.jmp.dto.model.Subscription;
import com.epam.jmp.dto.model.User;
import com.epam.jmp.service.api.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class ServiceImpl implements Service {

    private final Map<User, List<Subscription>> subscriptions = new HashMap<>();

    @Override
    public void subscribe(BankCard bankCard) {
        var number = bankCard.getNumber();
        var user = bankCard.getUser();
        var subscription = new Subscription(number, LocalDate.now());

        subscriptions.computeIfAbsent(user, u -> new ArrayList<>()).add(subscription);
    }

    @Override
    public Subscription getSubscriptionByBankCardNumber(String cardNumber) {
        return subscriptions.values().stream()
            .flatMap(Collection::stream)
            .filter(subscription -> subscription.getBankcard().equals(cardNumber))
            .findFirst()
            .orElseThrow(SubscriptionNotFoundException::new);
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate) {
        return subscriptions.values().stream()
            .flatMap(Collection::stream)
            .filter(predicate)
            .toList();
    }

    @Override
    public List<User> getAllUsers() {
        return subscriptions.keySet().stream().toList();
    }
}
