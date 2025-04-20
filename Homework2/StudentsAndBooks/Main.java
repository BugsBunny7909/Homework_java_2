package Homework2.StudentsAndBooks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static List<Student> students = new ArrayList<>();

    //Заполнение списка студентами
    static {
        students.add(new Student("Иван", Arrays.asList(
                new Book("Java Basics", 2005, 300),
                new Book("Spring Framework", 2015, 450),
                new Book("Clean Code", 2008, 400),
                new Book("Design Patterns", 1999, 500),
                new Book("Effective Java", 2017, 350)
        )));
        students.add(new Student("Мария", Arrays.asList(
                new Book("Python for Beginners", 2010, 250),
                new Book("Data Science", 2018, 600),
                new Book("Machine Learning", 2019, 550),
                new Book("Algorithms", 2001, 480),
                new Book("Database Systems", 2003, 520)
        )));
        students.add(new Student("Алексей", Arrays.asList(
                new Book("C++ Programming", 2007, 380),
                new Book("Game Development", 2016, 420),
                new Book("Computer Networks", 2004, 470),
                new Book("Operating Systems", 1998, 650),
                new Book("Software Engineering", 2012, 390)
        )));

    }

    public static void main(String[] args) {
        students.stream()
                .peek(System.out::println)
                .flatMap(s -> s.getBooks().stream())
                .sorted()
                .distinct()
                .filter(b -> b.getYear() > 2000)
                .limit(3)
                .map(b -> b.getYear())
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Такая книга отсутствует."));
    }
}