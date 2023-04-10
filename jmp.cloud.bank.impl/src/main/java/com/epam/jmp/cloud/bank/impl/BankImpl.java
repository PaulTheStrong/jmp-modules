package com.epam.jmp.cloud.bank.impl;

import static com.epam.jmp.dto.model.BankCardType.CREDIT;
import static com.epam.jmp.dto.model.BankCardType.DEBIT;

import com.epam.jmp.bank.api.Bank;
import com.epam.jmp.dto.model.BankCard;
import com.epam.jmp.dto.model.BankCardType;
import com.epam.jmp.dto.model.CreditBankCard;
import com.epam.jmp.dto.model.DebitBankCard;
import com.epam.jmp.dto.model.User;

import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BankImpl implements Bank {

    private final Map<BankCardType, BiFunction<String, User, BankCard>> cardTypeBiFunctionMap;
    private final static Random RANDOM = new Random();

    public BankImpl() {
        cardTypeBiFunctionMap = Map.of(
            CREDIT, CreditBankCard::new,
            DEBIT, DebitBankCard::new
        );
    }

    @Override
    public BankCard createBankCard(User user, BankCardType cardType) {
        var cardNumber = IntStream.generate(() -> RANDOM.nextInt(0, 10))
            .limit(16)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining());
        return cardTypeBiFunctionMap.getOrDefault(cardType, (c, u) -> {
            throw new RuntimeException("This card type not supported: " + cardType.name());
        }).apply(cardNumber, user);
    }
}
