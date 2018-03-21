package P06_Shopping_Spree;

import java.util.ArrayList;

public class Person {

    private String name;
    private int money;
    private ArrayList<String> bag;

    public Person(String name, int money) {
        this.setName(name);
        this.setMoney(money);
        this.bag = new ArrayList<>();

    }

    public String getName() {
        return this.name;
    }

    public int getMoney() {
        return this.money;
    }

    private int bagSize() {
        return this.bag.size();
    }

    public void addToBag(String product, int money) {
        if (this.money >= money) {
            System.out.printf("%s bought %s\n", this.name, product);
            this.money -= money;
            this.bag.add(product);
        } else {
            System.out.printf("%s can't afford %s\n", this.name, product);
        }
    }

    public void getPurchases() {
        if (bagSize() == 0) {
            System.out.printf("%s - Nothing bought\n", this.name);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s - ", this.name));
            for (String product : this.bag) {
                sb.append(String.format("%s, ", product));
            }
            sb.deleteCharAt(sb.length() - 2);
            System.out.println(sb.toString());
        }
    }

    private void setName(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }
}
