package com.epam.jmp.service.api;

import com.epam.jmp.dto.model.BankCard;
import com.epam.jmp.dto.model.Subscription;
import com.epam.jmp.dto.model.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Predicate;

public interface Service {

    void subscribe(BankCard bankCard);
    Subscription getSubscriptionByBankCardNumber(String cardNumber);
    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate);
    List<User> getAllUsers();

    default double getAverageUsersAge() {
        return getAllUsers().stream()
            .map(User::getBirthday)
            .map(birthday -> ChronoUnit.YEARS.between(birthday, LocalDate.now()))
            .mapToLong(Long::longValue)
            .average()
            .orElseThrow(() -> new RuntimeException("No users present"));
    }

    static boolean isPayableUser(User user) {
        return ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now()) >= 18;
    }

}
