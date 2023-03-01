/*Пусть дан список сотрудников:Иван Иванов, Светлана Петрова, Кристина Белова,Анна Мусина,
        Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова,
        Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова,
        Иван Мечников, Петр Петин,Иван Ежов
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
 Отсортировать по убыванию популярности.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class task02 {
    public static void main(String[] args) {
        String[] workers = new String[]{"Иван Иванов", "Светлана Петрова", "Кристина Белова",
                "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов",
                "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова",
                "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"};

        ArrayList<String> workersName = new ArrayList<>();
        for (String item : workers) {
            workersName.add(item.split(" ")[0]);
        }

        Map<String, Integer> name = new HashMap<>();
        for (int i = 0; i < workersName.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < workersName.size(); j++) {
                if (workersName.get(i).equals(workersName.get(j))) {
                    count++;
                }
            }
            if (name.containsKey(workersName.get(i)) == false) {
                name.put(workersName.get(i), count);
            }
        }
        ArrayList<Integer> listCount = new ArrayList<>();
        for (var item : name.entrySet()) {
            if (listCount.contains(item.getValue()) == false) listCount.add(item.getValue());
        }
        System.out.println("Повторяющиеся имена с количеством повторений и отсортированные по убыванию: ");
        listCount.sort(null);
        for (int i = listCount.size() - 1; i >= 0; i--) {
            for (var item : name.entrySet()) {
                if (listCount.get(i) == item.getValue()) {
                    System.out.println(item.getKey() + " - " + item.getValue());
                }
            }
        }
    }
}