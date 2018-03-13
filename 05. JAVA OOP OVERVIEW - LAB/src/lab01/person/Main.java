package lab01.person;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);
        Map<Integer, BankAccount> bank = new HashMap<>();
        String input = scan.nextLine();

        while (!input.equals("END")) {

            String[] inputArgs = input.split(" ");
            String command = inputArgs[0];
            int id = 0;
            double amount = 0f;
            switch (command) {
                case "Create": createAcc(bank); break;
                case "Deposit": depositAm(bank, inputArgs); break;
                case "Withdraw": withdrawAm(bank, inputArgs); break;
                case "SetInterest": setInterest(inputArgs); break;
                case "GetInterest": getInterest(bank, inputArgs); break;
                case "CollectInterest":
                    id = Integer.parseInt(inputArgs[1]);
                    int years = Integer.parseInt(inputArgs[2]);

                    for (int i = 0; i < years; i++) {
                        double profitForOneYear = (bank.get(id).getBalance() * BankAccount.getInterestRate());
                        bank.get(id).deposit(profitForOneYear);
                        System.out.println(bank.get(id).toString());
                    }
                    break;
                case "Print": printAcc(bank, inputArgs); break;
            }
            input = scan.nextLine();
        }

    }

    private static void getInterest(Map<Integer, BankAccount> bank, String[] inputArgs) {
        int id;
        id = Integer.parseInt(inputArgs[1]);
        int years = Integer.parseInt(inputArgs[2]);
        double result = bank.get(id).getBalance() * BankAccount.getInterestRate() * years;
        System.out.println(String.format("%.2f", result));
    }

    private static void setInterest(String[] inputArgs) {
        double amount;
        amount = Double.parseDouble(inputArgs[1]);
        BankAccount.setInterestRate(amount);
        System.out.println("Changed interest rate!");
    }

    private static void printAcc(Map<Integer, BankAccount> bank, String[] inputArgs) {
        int id = Integer.parseInt(inputArgs[1]);
        if (!bank.containsKey(id)) { System.out.println("Account does not exist");
        } else {
            System.out.println(bank.get(id).toString()); }
    }

    private static void withdrawAm(Map<Integer, BankAccount> bank, String[] inputArgs) {
        int id = Integer.parseInt(inputArgs[1]);
        double amount = Double.parseDouble(inputArgs[2]);
        if (!bank.containsKey(id)) { System.out.println("Account does not exist");
        } else { bank.get(id).withdraw(amount); }
    }

    private static void depositAm(Map<Integer, BankAccount> bank, String[] inputArgs) {
        int id = Integer.parseInt(inputArgs[1]);
        double amount = Double.parseDouble(inputArgs[2]);
        if (!bank.containsKey(id)) { System.out.println("Account does not exist");
        } else { bank.get(id).deposit(amount); }
    }

    private static void createAcc(Map<Integer, BankAccount> bank) {
        BankAccount acc = new BankAccount();
        if (!bank.containsKey(acc.getId())) { bank.put(acc.getId(), acc);
        } else { System.out.println("Account already exists!"); }
    }
}
