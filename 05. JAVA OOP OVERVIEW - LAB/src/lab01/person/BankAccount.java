package lab01.person;

public class BankAccount {
    private int id;
    private double balance;

    private static int bankAccountsCount = 0;

    private final static double DEFAULT_INTEREST = 0.02;
    private static double interestRate = DEFAULT_INTEREST;

    public BankAccount() {
        this.setId(++bankAccountsCount);
    }

    public static double getInterestRate(){
        return interestRate;
    }

    public static void setInterestRate(double interest){
        interestRate = interest;
    }

    public int getId(){
        return this.id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
        else {
            System.out.println("You cannot deposit negative amounts!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        }
        else {
            System.out.println("You cannot withdraw!");
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Your bank account is with ID%d and balance %.2f",
                this.id,
                this.balance
        );
    }
}
