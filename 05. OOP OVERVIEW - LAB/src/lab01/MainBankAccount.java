package lab01;

import lab01.person.BankAccount;

import java.io.PrintStream;

public class MainBankAccount {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();

        acc.deposit(15);
        acc.withdraw(5);

        try (PrintStream printf = System.out.printf(
                "Account %s, balance %.2f",
                acc,
                acc.getBalance())) {
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

