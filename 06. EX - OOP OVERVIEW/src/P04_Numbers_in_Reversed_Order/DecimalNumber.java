package P04_Numbers_in_Reversed_Order;

public class DecimalNumber {
    private String number;

    public DecimalNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String printReversedNumber() {
        String result = "";
        for (int i = this.getNumber().length() - 1; i>=0; i--) {
            result += this.getNumber().charAt(i);
        }
        return result;
    }
}
