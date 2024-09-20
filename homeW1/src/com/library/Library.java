package com.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Reader> readers;

    public Library() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
    }

    // Добавление книги
    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " добавлена в библиотеку");
    }

    // Удаление книги
    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
        System.out.println("Книга с ISBN " + isbn + " убрана из библиотеки");
    }

    // Регистрация читателя
    public void registerReader(Reader reader) {
        readers.add(reader);
        System.out.println(reader.getName() + " зарегистрирован");
    }

    // Удаление читателя
    public void removeReader(int readerId) {
        readers.removeIf(reader -> reader.getReaderId() == readerId);
        System.out.println("Читатель с ID " + readerId + " убран");
    }

    // Выдача книги
    public boolean lendBook(String isbn, int readerId) {
        Book book = findBook(isbn);
        if (book != null && book.borrowBook()) {
                System.out.println("Книга " + book.getTitle() + " выдана читателю с ID " + readerId);
            return true;
        } else {
            System.out.println("Книга недоступна или не найдена");
            return false;
        }
    }

    // Возврат книги
    public void returnBook(String isbn) {
        Book book = findBook(isbn);
        if (book != null) {
            book.returnBook();
            System.out.println("Книга " + book.getTitle() + " возвращена");
        } else {
            System.out.println("Книга не найдена");
        }
    }

    // Поиск книги по ISBN
    private Book findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Показ всех книг
    public void showBooks() {
        System.out.println("Книги в библиотеке:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Показ всех читателей
    public void showReaders() {
        System.out.println("Зарегистрированные читатели:");
        for (Reader reader : readers) {
            System.out.println(reader);
        }
    }
}

