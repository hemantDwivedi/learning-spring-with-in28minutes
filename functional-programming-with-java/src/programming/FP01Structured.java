package programming;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 4, 13, 25, 13, 12, 57, 80);
//        printAllNumbersInListStructured(numbers);
        printEvenNumbersInListStructured(numbers);
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        // Enhanced for loop
        for(int number: numbers) System.out.print(number + " ");
    }
    private static void printEvenNumbersInListStructured(List<Integer> numbers) {
        // Enhanced for loop
        for(int number: numbers) {
            if(number % 2 == 0) System.out.println(number);
        }
    }
}
