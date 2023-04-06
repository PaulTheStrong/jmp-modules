package jmp.bank.api;

import jmp.dto.model.BankCard;
import jmp.dto.model.BankCardType;
import jmp.dto.model.User;

public interface Bank {
    BankCard createBankCard(User user, BankCardType cardType);
}
