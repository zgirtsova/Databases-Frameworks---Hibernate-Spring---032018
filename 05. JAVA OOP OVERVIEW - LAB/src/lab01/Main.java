package lab01;

import lab01.person.BankAccount;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);
        Map<Integer, BankAccount> bank = new HashMap<>();
        String input = scan.nextLine();

        while (!input.equals("END")) {

            String[] inputArgs = input.split(" ");
            String command = inputArgs[0];
            int id = Integer.parseInt(inputArgs[1]);
            double amount = 0f;
            switch (command) {
                case "Create": createAcc(bank, id); break;
                case "Deposit": depositAm(bank, inputArgs, id); break;
                case "Withdraw": withdrawAm(bank, inputArgs, id); break;
                case "Print": printAcc(bank, inputArgs, id); break;
            }
            input = scan.nextLine();
        }

    }

    private static void printAcc(Map<Integer, BankAccount> bank, String[] inputArgs, int id) {
        double amount;
        amount = Double.parseDouble(inputArgs[2]);
        if (!bank.containsKey(id)) { System.out.println("Account does not exist");
        } else {
            System.out.println(bank.get(id).toString()); }
    }

    private static void withdrawAm(Map<Integer, BankAccount> bank, String[] inputArgs, int id) {
        double amount;
        amount = Double.parseDouble(inputArgs[2]);
        if (!bank.containsKey(id)) { System.out.println("Account does not exist");
        } else { bank.get(id).withdraw(amount); }
    }

    private static void depositAm(Map<Integer, BankAccount> bank, String[] inputArgs, int id) {
        double amount;
        amount = Double.parseDouble(inputArgs[2]);
        if (!bank.containsKey(id)) { System.out.println("Account does not exist");
        } else { bank.get(id).deposit(amount); }
    }

    private static void createAcc(Map<Integer, BankAccount> bank, int id) {
        BankAccount acc = new BankAccount();
        if (!bank.containsKey(id)) { bank.put(id, acc);
        } else { System.out.println("Account already exists!"); }
    }
}
