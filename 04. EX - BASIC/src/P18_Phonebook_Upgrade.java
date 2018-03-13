import java.util.*;

public class P18_Phonebook_Upgrade {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);

        String[] commands = scan.nextLine().split(" ");
        Map<String, String> phoneBook = new TreeMap<>();

        while (!commands[0].equals("END")) {
            String command = commands[0];

            switch (command) {
                case "A": {
                    String name = commands[1];
                    String phone = commands[2];
                    phoneBook.put(name, phone); break;
                }
                case "S": {
                    String name = commands[1];
                    if (phoneBook.containsKey(name)) {
                        System.out.printf("%s -> %s%n", name, phoneBook.get(name));
                    }
                    else {
                        System.out.printf("Contact %s does not exist.%n", name);
                    }
                    break;
                }
                case "ListAll": {
                    for (String name: phoneBook.keySet()) {
                        System.out.printf("%s -> %s%n", name, phoneBook.get(name));
                    }
                }
            }
            commands = scan.nextLine().split(" ");
        }
    }
}
