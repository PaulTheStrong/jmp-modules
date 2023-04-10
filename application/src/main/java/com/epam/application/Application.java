package com.epam.application;

import com.epam.jmp.bank.api.Bank;
import com.epam.jmp.cloud.bank.impl.BankImpl;
import com.epam.jmp.cloud.service.impl.ServiceImpl;
import com.epam.jmp.dto.model.BankCard;
import com.epam.jmp.dto.model.BankCardType;
import com.epam.jmp.dto.model.User;
import com.epam.jmp.service.api.Service;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        var service = new ServiceImpl();
        var bank = new BankImpl();

        var warrenBuffet = new User("Warren", "Buffet", LocalDate.of(1930, 8, 30));
        var elonMusk = new User("Elon", "Musk", LocalDate.of(1971, 6, 28));
        var elonSon = new User("X Æ A-12", "Musk", LocalDate.of(2020, 5, 4));

        var warrensCard = bank.createBankCard(warrenBuffet, BankCardType.CREDIT);
        var elonsCard = bank.createBankCard(elonMusk, BankCardType.DEBIT);

        service.subscribe(warrensCard);
        service.subscribe(elonsCard);

        System.out.println("All users: " + service.getAllUsers());
        System.out.println("Warren's subscription: " + service.getSubscriptionByBankCardNumber(warrensCard.getNumber()));
        System.out.println("Elon's subscription: " + service.getSubscriptionByBankCardNumber(elonsCard.getNumber()));
        System.out.println("Someone else's subscription: " + service.getSubscriptionByBankCardNumber("1234567812345678"));
        System.out.println("Average age: " + service.getAverageUsersAge());
        System.out.println("Is Elon payable user: " + Service.isPayableUser(elonMusk));
        System.out.println("Is X Æ A-12 payable user: " + Service.isPayableUser(elonSon));
    }

}
