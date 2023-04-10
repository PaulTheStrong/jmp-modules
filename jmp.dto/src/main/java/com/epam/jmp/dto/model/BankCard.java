package com.epam.jmp.dto.model;

import lombok.Data;

@Data
public abstract class BankCard {
    protected final String number;
    protected final User user;
}
