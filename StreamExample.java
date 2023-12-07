import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        // Создание произвольной коллекции строк
        List<String> stringCollection = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");

        // Примеры запросов к коллекции:

        // 1. Фильтрация строк, длина которых больше 5 символов
        List<String> filteredStrings = stringCollection.stream()
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());
        System.out.println("Фильтрация строк с длиной больше 5 символов: " + filteredStrings);

        // 2. Преобразование строк в верхний регистр
        List<String> uppercasedList = stringCollection.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Преобразование строк в верхний регистр: " + uppercasedList);

        // 3. Ограничение вывода до 2 элементов
        List<String> limitedList = stringCollection.stream()
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("Ограничение вывода до 2 элементов: " + limitedList);

        // 4. Сортировка строк в обратном порядке
        List<String> reversedList = stringCollection.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Сортировка строк в обратном порядке: " + reversedList);

        // 5. Собрать строки в одну с использованием разделителя
        String concatenatedString = stringCollection.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Собрать строки в одну с разделителем: " + concatenatedString);
    }
}
