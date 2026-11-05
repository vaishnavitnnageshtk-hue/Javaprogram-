/*
 * Constructors | Q4
 * WAP to use the static keyword by creating a static variable and methods.
 * Create a class for a Library Book Counter, include title, author and price.
 *
 * - bookCount and totalValue are static: ONE copy shared by all LibraryBook objects.
 * - getBookCount() / displayLibrarySummary() are static methods: they can be called
 *   using the class name, without creating an object.
 */
class LibraryBook {
    // static variables (shared by all objects)
    private static int bookCount = 0;
    private static double totalValue = 0;

    // instance variables (separate for each object)
    private String title;
    private String author;
    private double price;

    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        bookCount++;            // every new book increases the shared counter
        totalValue += price;
    }

    // static methods
    static int getBookCount() {
        return bookCount;
    }

    static void displayLibrarySummary() {
        System.out.println("Total books in library : " + bookCount);
        System.out.println("Total value of books   : Rs." + totalValue);
    }

    // instance method
    void display() {
        System.out.println("Title: " + title + " | Author: " + author + " | Price: Rs." + price);
    }
}

public class Main {
    public static void main(String[] args) {
        // Static method called with the class name, before any object exists
        System.out.println("Books before adding any: " + LibraryBook.getBookCount());

        LibraryBook b1 = new LibraryBook("Java: The Complete Reference", "Herbert Schildt", 899.0);
        LibraryBook b2 = new LibraryBook("Head First Java", "Kathy Sierra", 650.0);
        LibraryBook b3 = new LibraryBook("Effective Java", "Joshua Bloch", 750.0);

        System.out.println("\nBook details:");
        b1.display();
        b2.display();
        b3.display();

        System.out.println("\nLibrary summary:");
        LibraryBook.displayLibrarySummary();
    }
}
