package programming;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 4, 13, 25, 13, 12, 57, 80);
//        printEvenNumbersInListFunctional(numbers);
//        printOddNumbersInListFunctional(numbers);
//        printSquaresOfEvenNumbersInListFunctional(numbers);
        printSquaresOfOddNumbersInListFunctional(numbers);
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        numbers
                .stream()
                .forEach(System.out::println); // Method Reference
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers
                .stream()
                .filter(number -> number % 2 == 0) // Lambda Expression
                .forEach(System.out::println);

        // .filter(FP01Functional::isEven)
    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        numbers
                .stream()
                .filter(number -> number % 2 != 0)
                .forEach(System.out::println);
    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers
                .stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number*number)
                .forEach(System.out::println);
    }
    private static void printSquaresOfOddNumbersInListFunctional(List<Integer> numbers) {
        numbers
                .stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number*number)
                .forEach(System.out::println);
    }

}
