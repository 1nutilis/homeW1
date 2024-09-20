package com.library;

public class Main {
    public static void main(String[] args) {
        // Создаем библиотеку
        Library library = new Library();

        // Создаем книги
        Book book1 = new Book("Гарри Поттер и философский камень", " Дж.К. Роулинг", "123456789", 5);
        Book book2 = new Book("Гарри Поттер и Кубок огня", "Дж.К. Роулинг", "987654321", 3);

        // Добавляем книги в библиотеку
        library.addBook(book1);
        library.addBook(book2);

        // Создаем читателей
        Reader reader1 = new Reader("Артем", 1);
        Reader reader2 = new Reader("Санек", 2);

        // Регистрируем читателей
        library.registerReader(reader1);
        library.registerReader(reader2);

        // Показ всех книг
        System.out.println();
        library.showBooks();

        // Показ всех читателей
        System.out.println();
        library.showReaders();

        // Выдаем книгу
        System.out.println();
        library.lendBook("123456789", 1);

        // Возврат книги
        System.out.println();
        library.returnBook("123456789");

        // Удаление книги и читателя
        System.out.println();
        library.removeBook("987654321");
        library.removeReader(2);

        // Показ оставшихся книг и читателей
        System.out.println();
        library.showBooks();
        library.showReaders();
    }
}
