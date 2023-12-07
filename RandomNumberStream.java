
import java.util.List;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RandomNumberStream {
    public static void main(String[] args) {
        List<Integer> randomNumbers = new Random()
                .ints(1000, 10, 10000)
                .boxed()
                .collect(Collectors.toList());


        List<Integer> collectedList = randomNumbers.stream()
                .collect(Collectors.toList());
        System.out.println("Собранная коллекция: " + collectedList);


        long countOfPrimes = randomNumbers.stream()
                .filter(RandomNumberStream::isPrime)
                .count();
        System.out.println("Количество простых чисел: " + countOfPrimes);


        int sum = randomNumbers.stream()
                .reduce(Integer::sum)
                .orElse(0);
        System.out.println("Сумма случайных чисел: " + sum);


        randomNumbers.forEach(System.out::println);

        Map<Integer, Integer> squareMap = randomNumbers.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        num -> num * num
                ));
        System.out.println("Карта квадратов чисел: " + squareMap);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
