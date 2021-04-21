/*
 * Licensed to -> ENG: Ahmed Nasser
 *             -> email: a1h1m1e1d1.00@gmail.com
 *             -> phone: +201270800202
 */
package Library_Management_Sys;

import java.util.*;
import java.time.LocalDate;

public class Librarian extends Person implements User {

    Scanner input = new Scanner(System.in);

    private int id;
    private String password;
    public static int bookCounter = 0;
    public static int readerCounter = 0;
    ArrayList<Reader> reader_list = new ArrayList<Reader>(50);
    ArrayList<Book> book_list = new ArrayList<Book>(50);

    public Librarian() {
    }

    public Librarian(int id, String password, String fName, String lName, String type, long phone, String address, String email, boolean isBlock) {
        super(fName, lName, type, phone, address, email, isBlock);
        this.id = id;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public boolean book_id_Existance(Book book) {
        for (int i = 0; i < bookCounter; i++) {
            if (book.getId() == book_list.get(i).getId()) {
                System.out.println("book id already Exists");
                return false;
            }
        }
        return true;
    }

    public void addBook(Book newBook) {
        book_list.add(bookCounter, newBook);
    }

    public void preRegistered() {
        { //Pre-Registered => Readers
            Reader[] regReader = new Reader[2];

            regReader[0] = new Reader(1, "111", "A", "a", "Student", 012, "Aa", "A@gmail.com", false);
            regReader[1] = new Reader(2, "222", "B", "b", "Child", 011, "Bb", "B@gmail.com", true);

            for (int i = 0; i < regReader.length; i++) {
                this.addReader(regReader[i]);
                readerCounter++;
            }
        }

        { //Pre-Registered => Books
            Book[] regBook = new Book[10];

            regBook[0] = new Book(1, "Programming", 80.0f, "A", "a");
            regBook[1] = new Book(2, "English", 25.5f, "B", "b");
            regBook[2] = new Book(3, "Maths", 30.7f, "C", "c");
            regBook[3] = new Book(4, "History", 45.0f, "D", "d");
            regBook[4] = new Book(5, "Science", 50.2f, "E", "e");
            regBook[5] = new Book(6, "Geography", 36.8f, "F", "f");
            regBook[6] = new Book(7, "Physics", 43.0f, "G", "g");
            regBook[7] = new Book(8, "Psychology", 12.3f, "H", "h");
            regBook[8] = new Book(9, "Chemistry", 63.5f, "I", "i");
            regBook[9] = new Book(10, "Biology", 73.2f, "J", "j");

            for (int i = 0; i < regBook.length; i++) {
                this.addBook(regBook[i]);
                bookCounter++;
            }
        }
    }

    public void addBook() {
        System.out.print("\nEnter number of books you want to add: ");
        int number = input.nextInt();

        if (number <= (50 - bookCounter)) {
            for (int i = 0; i < number; i++) {
                System.out.print("Enter book_id: ");
                int book_id = input.nextInt();

                System.out.print("Enter name of the book: ");
                String name = input.next();

                System.out.print("Enter price of the book: ");
                float price = input.nextFloat();

                System.out.print("Enter author of the book: ");
                String author = input.next();

                System.out.print("Enter publisher of the book: ");
                String publisher = input.next();

                Book newBook = new Book(book_id, name, price, author, publisher);

                if (this.book_id_Existance(newBook)) {
                    this.addBook(newBook);
                    bookCounter++;
                }
            }
        } else {
            System.out.println("Array of Books is Full");
        }
    }

    public static void booksNum() {
        System.out.println("\nThere are ->(" + bookCounter + ")<- Books in the Library");
    }

    @Override
    public int searchBook(int book_id) {
        for (int i = 0; i < bookCounter; i++) {
            if (book_id == book_list.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String Search_For_Book(int book_id) {
        if (this.searchBook(book_id) != -1) {
            return book_list.get(book_id - 1).getName();
        } else {
            System.out.println("id not found");
            return "Null";
        }
    }

    public void removeBook(int book_id) {
        book_id -= 1;

        if (this.searchBook(book_id) != -1) {
            book_list.remove(book_id);
            bookCounter--;
        } else {
            System.out.println("id not found");
        }
    }

    public void displayBooks() {
        System.out.println("");
        for (int i = 0; i < bookCounter; i++) {
            System.out.println(book_list.get(i).getId()
                    + " -> " + book_list.get(i).getName()
                    + " -> " + book_list.get(i).getPrice()
                    + " -> " + book_list.get(i).getAuthor()
                    + " -> " + book_list.get(i).getPublisher()
                    + "\t->\tReader: " + book_list.get(i).getReader_id()
                    + ", " + book_list.get(i).getReader_name());
        }
    }

    public boolean reader_id_Existance(Reader reader) {
        for (int i = 0; i < readerCounter; i++) {
            if (reader.getId() == reader_list.get(i).getId()) {
                System.out.println("Reader id already Exists");
                return false;
            }
        }
        return true;
    }

    public void addReader(Reader newReader) {
        reader_list.add(readerCounter, newReader);
    }

    public void addReader() {
        System.out.print("\nEnter number of readers you want to add: ");
        int number_reader = input.nextInt();

        if (number_reader <= (50 - readerCounter)) {
            for (int i = 0; i < number_reader; i++) {
                System.out.print("enter reader's id please: ");
                int id = input.nextInt();

                System.out.print("enter reader's password please: ");
                String password = input.next();

                System.out.print("enter reader's first name please: ");
                String fName = input.next();

                System.out.print("enter reader's last name please: ");
                String lName = input.next();

                System.out.print("enter type of reader please: ");
                String type = input.next();

                System.out.print("enter reader's phone please: ");
                long phone = input.nextLong();

                System.out.print("enter reader's address please: ");
                String address = input.next();

                System.out.print("enter reader's email please: ");
                String email = input.next();

                System.out.print("Is the reader Blocked (true/false)?: ");
                boolean isBlock = input.nextBoolean();

                Reader newReader = new Reader(id, password, fName, lName, type, phone, address, email, isBlock);
                if (this.reader_id_Existance(newReader)) {
                    this.addReader(newReader);
                    readerCounter++;
                }
            }
        } else {
            System.out.println("No space to add more user");
        }
    }

    @Override
    public int searchUser(int user_id) {
        for (int i = 0; i < readerCounter; i++) {
            if (user_id == reader_list.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public void removeUser(int user_id) {
        user_id -= 1;

        if (this.searchUser(user_id) != -1) {
            reader_list.remove(user_id);
            readerCounter--;
        } else {
            System.out.println("Reader not found");
        }
    }

    public static void readerNum() {
        System.out.println("\nThere are ->(" + readerCounter + ")<- Readers in the Library");
    }

    public void displayReaders() {
        System.out.println("");
        for (int i = 0; i < readerCounter; i++) {
            System.out.println(reader_list.get(i).getId()
                    + " -> " + reader_list.get(i).getPassword()
                    + " -> " + reader_list.get(i).getfName()
                    + " -> " + reader_list.get(i).getlName()
                    + " -> " + reader_list.get(i).getType()
                    + " -> " + reader_list.get(i).getPhone()
                    + " -> " + reader_list.get(i).getAddress()
                    + " -> " + reader_list.get(i).getEmail()
                    + " -> " + "Block:" + reader_list.get(i).isIsBlock());
        }
    }

    public void Add_ReaderToBook(int reader_id, int book_id, String name) {
        if (this.searchUser(reader_id) != -1 && this.searchBook(book_id) != -1) {
            if (reader_list.get(reader_id).isIsBlock() && book_list.get(book_id).getReader_id() != 0) {
                System.out.println("Reader is Blocked or Book already Rented");
            } else {
                book_list.get(book_id).setReader_name(name);
                book_list.get(book_id).setReader_id(reader_id);
            }
        } else {
            System.out.println("Reader or Book not Found");
        }
    }

    public void Remove_ReaderFromBook(int book_id) {
        if (this.searchBook(book_id) != -1) {
            book_list.get(book_id).setReader_name(null);
            book_list.get(book_id).setReader_id(0);
        } else {
            System.out.println("book not found");
        }
    }

    public void blockUser(int user_id) {
        if (this.searchUser(user_id) != -1) {
            reader_list.get(user_id).setIsBlock(true);
        } else {
            System.out.println("reader not found");
        }
    }

    public Boolean checkReturnDate(int day, int month, int year) {
        LocalDate weekAgo = LocalDate.now().minusWeeks(1);
        LocalDate rentDate = LocalDate.of(year, month, day);
        if (rentDate.compareTo(weekAgo) >= 0 && rentDate.compareTo(weekAgo) <= 7) {
            return true; //Valid
        } else {
            return false; //Not-Valid
        }
    }

    public float payFine(int reader_id, int book_id, int day, int month, int year) {
        if (this.checkReturnDate(day, month, year)) {
            return book_list.get(book_id).getPrice();
        } else {
            //If checkReturnDate() is => False => then Fine 10% of the Book's Price
            return (book_list.get(book_id).getPrice() + (book_list.get(book_id).getPrice()) * 0.1f);
        }
    }

    @Override
    public void rentBook() {
        System.out.print("\nEnter reader's id: ");
        int readerId = input.nextInt();

        System.out.print("Enter book's id: ");
        int bookId = input.nextInt();

        if (this.searchUser(readerId) != -1 && this.searchBook(bookId) != -1) {
            if (reader_list.get(readerId).isIsBlock() && book_list.get(bookId).getReader_id() != 0) {
                System.out.println("Reader is Blocked or Book already Rented");
            } else {
                System.out.println("Enter Rental date =>");
                System.out.print("\t\tDay: ");
                int d = input.nextShort();
                System.out.print("\t\tMonth: ");
                int m = input.nextShort();
                System.out.print("\t\tYear: ");
                int y = input.nextInt();

                if (this.checkReturnDate(d, m, y)) {
                    System.out.println("\nIt is a Week ago, No Block, No Fine");
                } else {
                    System.out.println("\nExceeded a week, You are Blocked, Fine 10%");
                    reader_list.get(readerId).setIsBlock(true);
                }

                System.out.println("You Should pay: " + payFine(readerId, bookId, d, m, y));
            }
        } else {
            System.out.println("Reader or Book not Found");
        }
    }
}
