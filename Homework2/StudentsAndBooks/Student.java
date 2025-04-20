package Homework2.StudentsAndBooks;

import java.util.List;

class Student {
    private String name;
    private List<Book> books;

    Student(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Студент: " + name + " | Книги: " + books;
    }
}