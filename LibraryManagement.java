public class LibraryManagement {

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

        // Method to display all books in the library
        public void displayBooks() {
            System.out.println("Library Books:");
            for (int i = 0; i < bookCount; i++) {
                Book book = books[i];
                System.out.println("ID: " + book.getBookID() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Available: " + book.isAvailable());
            }
        }

        // Method to borrow a book by its ID
        public void borrowBook(int bookID) {
            for (int i = 0; i < bookCount; i++) {
                if (books[i].getBookID() == bookID) {
                    books[i].borrow();
                    return;
                }
            }
            System.out.println("Book with ID " + bookID + " not found.");
        }

        // Method to return a book by its ID
        public void returnBook(int bookID) {
            for (int i = 0; i < bookCount; i++) {
                if (books[i].getBookID() == bookID) {
                    books[i].returnBook();
                    return;
                }
            }
            System.out.println("Book with ID " + bookID + " not found.");
        }
    }

    // Main method to demonstrate the program
    public static void main(String[] args) {
        Library library = new Library(5); // Create a library with capacity for 5 books

        // Create books
        Book book1 = new Book(1, "1984", "George Orwell");
        Book book2 = new Book(2, "To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book(3, "The Great Gatsby", "F. Scott Fitzgerald");

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Display all books
        library.displayBooks();

        // Borrow a book
        library.borrowBook(1); // Borrow "1984"
        library.displayBooks(); // Display books after borrowing

        // Return a book
        library.returnBook(1); // Return "1984"
        library.displayBooks(); // Display books after returning
    }
}
