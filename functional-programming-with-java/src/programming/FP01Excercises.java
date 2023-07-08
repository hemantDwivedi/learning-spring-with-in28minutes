package programming;

import java.util.List;

public class FP01Excercises {
    public static void main(String[] args) {
        List<String> courses = List.of("spring boot", "spring", "microservices", "aws", "learn docker", "devOps");
//        printAllCoursesIndividual(courses);
//        printSpecificCourse(courses);
//        printSpecificLengthOfCourse(courses);
        printNumberOfCharactersInEachCourse(courses);
    }

    private static void printNumberOfCharactersInEachCourse(List<String> courses) {
        courses
                .stream()
                .map(course -> course + " " + course.length())
                .forEach(System.out::println);
    }

    private static void printSpecificLengthOfCourse(List<String> courses) {
        courses
                .stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printSpecificCourse(List<String> courses) {
        courses
                .stream()
                .filter(course -> course.contains("spring"))
                .forEach(System.out::println);
    }

    private static void printAllCoursesIndividual(List<String> courses) {
        courses
                .stream()
                .forEach(System.out::println);
    }
}
