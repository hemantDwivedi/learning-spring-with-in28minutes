package programming;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class OptionalConcept {
    public static void main(String[] args) {

        List<String> fruits = List.of("apple", "banana", "mango");

        Predicate<? super String> predicate = fruit -> fruit.startsWith("c");
        Optional<String> optionalFruit = fruits
                .stream()
                .filter(predicate)
                .findFirst();

        System.out.println(optionalFruit);
        System.out.println(optionalFruit.isEmpty());
        System.out.println(optionalFruit.isPresent());
        System.out.println(optionalFruit.get());

        Optional<String> fruit = Optional.of("banana");
        Optional<Object> empty = Optional.empty();
    }
}
