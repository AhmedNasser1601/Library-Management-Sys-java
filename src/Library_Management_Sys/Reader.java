/*
 * Licensed to -> ENG: Ahmed Nasser
 *             -> email: a1h1m1e1d1.00@gmail.com
 *             -> phone: +201270800202
 */
package Library_Management_Sys;

import java.util.*;
import java.time.LocalDate;
import static Library_Management_Sys.Librarian.*;

public class Reader extends Person implements User {

    Scanner input = new Scanner(System.in);

    private int id;
    private String password;
    ArrayList<Book> book_list = new ArrayList<Book>(50);
    ArrayList<Reader> reader_list = new ArrayList<Reader>(50);
    Librarian l = new Librarian();

    public Reader() {
    }

    public Reader(int id, String password, String fName, String lName, String type, long phone, String address, String email, boolean isBlock) {
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
    public int searchUser(int user_id) {
        for (int i = 0; i < readerCounter; i++) {
            if (user_id == reader_list.get(i).getId()) {
                return i;
            }
        }
        return -1;
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
            return (book_list.get(book_id).getPrice() - (book_list.get(book_id).getPrice()) * 0.1f);
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
                }

                reader_list.get(readerId).setIsBlock(true);
                System.out.println("You Should pay: " + payFine(readerId, bookId, d, m, y));
            }
        } else {
            System.out.println("Reader or Book not Found");
        }
    }

    @Override
    public String Search_For_Book(int book_id) {
        if (this.searchBook(book_id) != -1) {
            return book_list.get(book_id).getName();
        } else {
            System.out.println("id not found");
            return "Null";
        }
    }
}
