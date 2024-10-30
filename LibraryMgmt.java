import java.util.Scanner;

public class LibraryMgmt {

    // Book class
    static class Book {
        private int bookID;
        private String title;
        private String author;
        private boolean isAvailable;

        // Constructor
        public Book(int bookID, String title, String author) {
            this.bookID = bookID;
            this.title = title;
            this.author = author;
            this.isAvailable = true; // Books are available upon creation
        }

        // Getters
        public int getBookID() {
            return bookID;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        // Method to borrow the book
        public void borrow() {
            if (isAvailable) {
                isAvailable = false;
                System.out.println("You have borrowed: " + title);
            } else {
                System.out.println("Sorry, " + title + " is currently not available.");
            }
        }

        // Method to return the book
        public void returnBook() {
            isAvailable = true;
            System.out.println("You have returned: " + title);
        }
    }

    // Library class
    static class Library {
        private Book[] books;
        private int bookCount;

        // Constructor
        public Library(int size) {
            books = new Book[size];
            bookCount = 0;
        }

        // Method to add a book to the library
        public void addBook(Book book) {
            if (bookCount < books.length) {
                books[bookCount] = book;
                bookCount++;
                System.out.println("Added book: " + book.getTitle());
            } else {
                System.out.println("Library is full, cannot add more books.");
            }
        }

        // Method to remove a book by ID
        public void removeBook(int bookID) {
            for (int i = 0; i < bookCount; i++) {
                if (books[i].getBookID() == bookID) {
                    for (int j = i; j < bookCount - 1; j++) {
                        books[j] = books[j + 1]; // Shift books to the left
                    }
                    books[bookCount - 1] = null; // Remove last reference
                    bookCount--;
                    System.out.println("Removed book with ID: " + bookID);
                    return;
                }
            }
            System.out.println("Book with ID " + bookID + " not found.");
        }

        // Method to search for a book by ID
        public Book searchBook(int bookID) {
            for (int i = 0; i < bookCount; i++) {
                if (books[i].getBookID() == bookID) {
                    return books[i];
                }
            }
            return null; // Book not found
        }

        // Method to display all books in the library
        public void displayBooks() {
            if (bookCount == 0) {
                System.out.println("No books in the library.");
                return;
            }
            System.out.println("Library Books:");
            for (int i = 0; i < bookCount; i++) {
                Book book = books[i];
                System.out.println("ID: " + book.getBookID() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Available: " + book.isAvailable());
            }
        }
    }

    // Main method to demonstrate the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(10); // Create a library with capacity for 10 books

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Book
                    System.out.print("Enter book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;

                case 2: // Remove Book
                    System.out.print("Enter book ID to remove: ");
                    int removeID = scanner.nextInt();
                    library.removeBook(removeID);
                    break;

                case 3: // Search Book
                    System.out.print("Enter book ID to search: ");
                    int searchID = scanner.nextInt();
                    Book foundBook = library.searchBook(searchID);
                    if (foundBook != null) {
                        System.out.println("Found Book: ID: " + foundBook.getBookID() + ", Title: " + foundBook.getTitle() + ", Author: " + foundBook.getAuthor() + ", Available: " + foundBook.isAvailable());
                    } else {
                        System.out.println("Book with ID " + searchID + " not found.");
                    }
                    break;

                case 4: // Display All Books
                    library.displayBooks();
                    break;

                case 5: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
