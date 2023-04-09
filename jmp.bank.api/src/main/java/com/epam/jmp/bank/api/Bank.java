package com.epam.jmp.bank.api;

import com.epam.jmp.dto.model.BankCard;
import com.epam.jmp.dto.model.BankCardType;
import com.epam.jmp.dto.model.User;

public interface Bank {
    BankCard createBankCard(User user, BankCardType cardType);
}
