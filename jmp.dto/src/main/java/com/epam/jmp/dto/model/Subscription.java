package com.epam.jmp.dto.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subscription {
    private String bankcard;
    private LocalDate startDate;
}
