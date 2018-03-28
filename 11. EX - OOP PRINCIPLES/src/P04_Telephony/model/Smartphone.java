package P04_Telephony.model;

import P04_Telephony.contracts.Browseable;
import P04_Telephony.contracts.Callable;

public class Smartphone implements Browseable, Callable {
    @Override
    public void browse(String site) {
        if (isSiteValid(site)) {
            System.out.println("Browsing: " + site + "!");
        } else {
            throw new IllegalArgumentException("Invalid URL!");
        }
    }

    @Override
    public void call(String number) {
        if (isNumberValid(number)) {
            System.out.println("Calling... " + number);
        } else {
            throw new IllegalArgumentException("Invalid number!");
        }
    }

    private boolean isSiteValid(String site) {
        return site.matches("\\D*");
    }

    private boolean isNumberValid(String site) {
        return site.matches("\\d+");
    }
}
