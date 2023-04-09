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
import java.util.UUID;
import java.util.function.BiFunction;

public class BankImpl implements Bank {

    private final Map<BankCardType, BiFunction<String, User, BankCard>> cardTypeBiFunctionMap;

    public BankImpl() {
        cardTypeBiFunctionMap = Map.of(
            CREDIT, CreditBankCard::new,
            DEBIT, DebitBankCard::new
        );
    }

    @Override
    public BankCard createBankCard(User user, BankCardType cardType) {
        return cardTypeBiFunctionMap.getOrDefault(cardType, (c, u) -> {
            throw new RuntimeException("This card type not supported: " + cardType.name());
        }).apply(UUID.randomUUID().toString(), user);
    }
}
