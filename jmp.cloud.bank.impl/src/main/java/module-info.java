import com.epam.jmp.bank.api.Bank;
import com.epam.jmp.cloud.bank.impl.BankImpl;

module jmp.cloud.bank.impl {
    requires transitive jmp.bank.api;
    requires jmp.dto;
    provides Bank with BankImpl;

    exports com.epam.jmp.cloud.bank.impl;
}