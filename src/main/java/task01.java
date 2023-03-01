
 // Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
 // что один человек может иметь несколько телефонов.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class task01 {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        phoneBook.put("Анна", List.of("8 926 574 57 48", "8 926 838 43 34"));
        phoneBook.put("Виталий", List.of("8 925 756 43 54", "8 925 383 39 38"));
        phoneBook.put("Роман", List.of("8 926 887 34 34", "8 926 223 44 55"));
        phoneBook.put("Дмитрий", List.of("8 924 553 43 65", "8 926 867 38 44"));
        phoneBook.put("Мария", List.of("8 926 647 37 48", "8 926 222 23 92"));

        menu(phoneBook);

    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
    }
    public static void find(Map<String, List<String>> phoneBook) {
        System.out.println("Введите имя: ");
        String name = scanner();
        System.out.println(phoneBook.get(name));
    }
    public static void allBook(Map<String, List<String>> phoneBook) {
        System.out.println(phoneBook);

    }
    public static Map<String, List<String>> add(Map<String, List<String>> phoneBook) {
        System.out.println("'Stop' для выхода");
        System.out.println("Введите имя: ");
        String name = scanner();
        List<String> number = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер: ");
            String phone = scanner();
            if (phone.equals("stop")) {
                break;
            } else {
                number.add(phone);
            }
        }
        phoneBook.put(name, number);

        return phoneBook;
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> phoneBook) {
        System.out.println(
                "Введите команду: find, add, all, exit");
        while (true) {
            String command = scanner();
            if (command.equals("exit")) {
                break;
            } else {
                switch (command) {
                    case "find":
                        find(phoneBook);
                        break;
                    case "add":
                        add(phoneBook);
                        break;
                    case "all":
                        allBook(phoneBook);
                        break;
                    default:
                        break;
                }
            }
        }
        return phoneBook;
    }
}