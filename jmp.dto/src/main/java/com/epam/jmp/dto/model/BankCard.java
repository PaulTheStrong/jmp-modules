package com.epam.jmp.dto.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BankCard {
    protected final String number;
    protected final User user;
}
