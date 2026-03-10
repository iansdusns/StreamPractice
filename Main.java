import java.util.*;
import java.util.stream.Collectors;
class Student {
    String name;
    String group;
    double gpa;
    public Student(String name, String group, double gpa) {
        this.name = name;
        this.group = group;
        this.gpa = gpa;
    }
    public String toString() {
        return name + " (" + group + ", GPA=" + gpa + ")";
    }
}
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(7, 4, 10, 3, 6, 8, 4);
        List<String> names = Arrays.asList("Aizada", "Bekzat", "Adilet", "Nurbol");
        // Students list
        List<Student> students = Arrays.asList(
                new Student("Aizada", "SE-1", 3.7),
                new Student("Bekzat", "SE-1", 3.1),
                new Student("Adilet", "CS-2", 3.9),
                new Student("Nurbol", "CS-2", 3.6),
                new Student("Meerim", "SE-1", 3.3)
        );
        // 1 Filter a list of integers to include only even numbers.
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);
        // 2 Convert a list of strings to uppercase.
        List<String> upperNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase names: " + upperNames);
        // 3 Count how many strings in a list start with a specific letter.
        long countA = names.stream()
                .filter(n -> n.startsWith("A"))
                .count();
        System.out.println("Names starting with A: " + countA);
        // 4 Sort a list of numbers in descending order.
        List<Integer> sortedDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Sorted descending: " + sortedDesc);
        // 5 Find the maximum and minimum number in a list.
        int max = numbers.stream().max(Integer::compare).get();
        int min = numbers.stream().min(Integer::compare).get();
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        // 6 Remove duplicate elements from a list.
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Without duplicates: " + uniqueNumbers);
        // 7 Concatenate a list of strings into a single comma-separated string.
        String joined = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Joined string: " + joined);
        // 8 Group a list of Student objects by their group field.
        Map<String, List<Student>> groupedStudents =
                students.stream()
                        .collect(Collectors.groupingBy(s -> s.group));
        System.out.println("Grouped students: " + groupedStudents);
        // 9 Calculate the average GPA of all students.
        double avgGpa = students.stream()
                .mapToDouble(s -> s.gpa)
                .average()
                .orElse(0);
        System.out.println("Average GPA: " + avgGpa);
        // 10 Find the first 3 student that matches a condition (e.g., first student with GPA > 3.5).
        List<Student> topStudents = students.stream()
                .filter(s -> s.gpa > 3.5)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("First 3 students GPA > 3.5: " + topStudents);
        // 11 Find how many students who have a GPA greater than 3.5.
        long countHighGpa = students.stream()
                .filter(s -> s.gpa > 3.5)
                .count();
        System.out.println("Students GPA > 3.5: " + countHighGpa);
    }
}