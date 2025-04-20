package Homework2.StudentsAndBooks;

class Book implements Comparable<Book> {
    private String author;
    private int year;
    private int pages;

    Book(String author, int year, int pages) {
        this.author = author;
        this.year = year;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Автор: " + author + " | Год: " + year + " | Страницы: " + pages;
    }

    @Override
    public int compareTo(Book o) {
        return Integer.compare(getPages(), o.getPages());
    }
}