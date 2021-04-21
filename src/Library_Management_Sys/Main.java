/*
 * Licensed to -> ENG: Ahmed Nasser
 *             -> email: ahmednasser1601@gmail.com
 *             -> phone: +201270800202
 */
package Library_Management_Sys;

import java.util.*;

public class Main {

    Scanner input = new Scanner(System.in);
    static Scanner inputStatic = new Scanner(System.in);

    static int choise = 0;
    static int back_option = 1;

    static int bookID;
    static int readerID;
    static int d;
    static int m;
    static int y;

    static Librarian l = new Librarian(111, "1234", "a", "AA", "Teacher", 123456789, "Cairo", "A@gmail.com", true);
    static Reader r = new Reader(222, "5678", "b", "BB", "Student", 987654321, "Giza", "B@gmail.com", false);

    public static void main(String[] args) {
        l.preRegistered();  //Calls a mithod that has some data initialed into

        //////////////////////////////////////////////////--> Main >< Menu <--//////////////////////////////////////////////////
        do {
            back_option = 1;     //To Enter the (Do --> While) LOOP
            cls();

            System.out.print("\n\t\t"
                    + "\t\t   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\t\t"
                    + "\t\t @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\t\t"
                    + "\t\t@@@@ -------> WELCOME to: <------- @@@@\n\t\t"
                    + "\t\t@@@@-> Library Management System <-@@@@\n\t\t"
                    + "\t\t @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\t\t"
                    + "\t\t   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\n");

            ////////////////////--> Options <--////////////////////
            System.out.print("\n"
                    + "\t° Enter >-[1]-> to:-> Register User\t"
                    + "\t   ° Enter >-[2]-> to:-> Search Book\n\n"
                    + "\t° Enter >-[3]-> to:-> Add Reader to Book"
                    + "\t   ° Enter >-[4]-> to:-> Remove Reader from Book\n\n"
                    + "\t° Enter >-[5]-> to:-> Add new Books\t"
                    + "\t   ° Enter >-[6]-> to:-> Remove Books\n\n"
                    + "\t° Enter >-[7]-> to:-> Rent/Buy Book\t"
                    + "\t   ° Enter >-[8]-> to:-> Block Reader\n\n"
                    + "\t° Enter >-[9]-> to:-> Search User\t"
                    + "\t   ° Enter >-[10]-> to:-> Check Return Date\n\n"
                    + "\t° Enter >-[11]-> to:-> Display Books\t"
                    + "\t   ° Enter >-[12]-> to:-> Display Readers\n\n"
                    + "\t° Enter >-[13]-> to:-> Number of Books\t"
                    + "\t   ° Enter >-[14]-> to:-> Number of Readers\n\n"
                    + "\t° Enter >-[15]-> to:-> Pay a Late Fine\t"
                    + "\t   ° Enter >-[0]-> to:-> EXIT\n"
                    + "\n\n****************************************************************************************************\n\n"
                    + "\t° -> Your Choise is:-> ");
            choise = inputStatic.nextInt();

            switch (choise) {
                case 1:     //Register User
                    cls();
                    if (Login() == 1) {
                        l.addReader();
                    } else {
                        System.out.println("\n\n\tSorry you aren't Allowed to do This Operation\n\n");
                    }

                    Back_Option(back_option);     //Returns to Menu
                    continue;
                //////////////////////////////////////////////////

                case 2:     //Search Book
                    cls();

                    if (Login() != 0) {
                        System.out.print("\n\t-> Enter Book ID: ");
                        bookID = inputStatic.nextInt();
                        System.out.println("\tBook's Name is: " + l.Search_For_Book(bookID));
                    }

                    Back_Option(back_option);
                    continue;
                //////////////////////////////////////////////////

                case 3:     //Add Reader to Book
                    cls();

                    if (Login() == 1) {
                        System.out.print("\n\t-> Enter Reader ID: ");
                        readerID = inputStatic.nextInt();

                        System.out.print("\n\t-> Enter Book ID: ");
                        bookID = inputStatic.nextInt();

                        System.out.print("\n\t-> Enter Reader Name: ");
                        String readerName = inputStatic.next();

                        l.Add_ReaderToBook(readerID, bookID, readerName);
                    } else {
                        System.out.println("\n\n\tSorry you aren't Allowed to do This Operation\n\n");
                    }

                    Back_Option(back_option);
                    continue;
                //////////////////////////////////////////////////

                case 4:     //Remove Reader from Book
                    cls();
                    if (Login() == 1) {
                        System.out.print("\n\t-> Enter Book ID: ");
                        bookID = inputStatic.nextInt();

                        l.Remove_ReaderFromBook(bookID);
                    } else {
                        System.out.println("\n\n\tSorry you aren't Allowed to do This Operation\n\n");
                    }

                    Back_Option(back_option);
                    continue;
                //////////////////////////////////////////////////

                case 5:     //Add new Books
                    cls();
                    if (Login() == 1) {
                        l.addBook();
                    } else {
                        System.out.println("\n\n\tSorry you aren't Allowed to do This Operation\n\n");
                    }

                    Back_Option(back_option);
                    continue;
                //////////////////////////////////////////////////

                case 6:     //Remove Books
                    cls();
                    if (Login() == 1) {
                        System.out.print("\n\t-> Enter Book ID: ");
                        bookID = inputStatic.nextInt();

                        l.removeBook(bookID);
                    } else {
                        System.out.println("\n\n\tSorry you aren't Allowed to do This Operation\n\n");
                    }

                    Back_Option(back_option);
                    continue;
                //////////////////////////////////////////////////

                case 7:     //Rent/Buy Book
                    cls();
                    if (Login() != 0) {
                        l.rentBook();
                    }

                    Back_Option(back_option);
                    continue;
                //////////////////////////////////////////////////

                case 8:     //Block Reader
                    cls();
                    if (Login() == 1) {
                        System.out.print("\n\t-> Enter Reader ID: ");
                        readerID = inputStatic.nextInt();

                        l.blockUser(readerID);
                    } else {
                    }

                    Back_Option(back_option);
                    continue;
                //////////////////////////////////////////////////

                case 9:     //Search User
                    cls();
                    if (Login() == 1) {
                        System.out.print("\n\t-> Enter User's ID: ");
                        readerID = inputStatic.nextInt();
                        System.out.println("\tUser's Name is:" + l.searchUser(readerID));
                    } else {
                        System.out.println("\n\n\tSorry you aren't Allowed to do This Operation\n\n");
                    }

                    Back_Option(back_option);
                    continue;
                //////////////////////////////////////////////////

                case 10:     //Check Return Date
                    cls();
                    if (Login() == 1) {
                        System.out.print("\n\t-> Enter Rental Date:-");

                        System.out.print("\n\t\t\t-> Day: ");
                        d = inputStatic.nextInt();

                        System.out.print("\n\t\t\t-> Month: ");
                        m = inputStatic.nextInt();

                        System.out.print("\n\t\t\t-> Year: ");
                        y = inputStatic.nextInt();

                        if (l.checkReturnDate(d, m, y)) {
                            System.out.println("\n\n\t-> Valid Date, Haven't Exceeded a Week");
                        } else {
                            System.out.println("\n\n\t-> Invalid Date, Exceeded a Week");
                        }
                    } else {
                        System.out.println("\n\n\tSorry you aren't Allowed to do This Operation\n\n");
                    }

                    Back_Option(back_option);
                    continue;
                //////////////////////////////////////////////////

                case 11:     //Display Books
                    cls();
                    if (Login() != 0) {
                        l.displayBooks();
                    }

                    Back_Option(back_option);
                    continue;
                //////////////////////////////////////////////////

                case 12:     //Display Readers
                    cls();
                    if (Login() == 1) {
                        l.displayReaders();
                    } else {
                        System.out.println("\n\n\tSorry you aren't Allowed to do This Operation\n\n");
                    }

                    Back_Option(back_option);
                    continue;
                //////////////////////////////////////////////////

                case 13:     //Number of Books
                    cls();
                    if (Login() == 1) {
                        Librarian.booksNum();
                    } else {
                        System.out.println("\n\n\tSorry you aren't Allowed to do This Operation\n\n");
                    }

                    Back_Option(back_option);
                    continue;
                //////////////////////////////////////////////////

                case 14:     //Number of Readers
                    cls();
                    if (Login() == 1) {
                        Librarian.readerNum();
                    } else {
                        System.out.println("\n\n\tSorry you aren't Allowed to do This Operation\n\n");
                    }

                    Back_Option(back_option);
                    continue;
                //////////////////////////////////////////////////

                case 15:     //Pay Fine
                    cls();
                    if (Login() != 0) {
                        System.out.print("\n\t-> Enter Reader ID: ");
                        readerID = inputStatic.nextInt();

                        System.out.print("\n\t-> Enter Book ID: ");
                        bookID = inputStatic.nextInt();

                        System.out.print("\n\t-> Enter Rental Date:-");

                        System.out.print("\n\t\t\t-> Day: ");
                        d = inputStatic.nextInt();

                        System.out.print("\n\t\t\t-> Month: ");
                        m = inputStatic.nextInt();

                        System.out.print("\n\t\t\t-> Year: ");
                        y = inputStatic.nextInt();

                        if (l.checkReturnDate(d, m, y)) {
                            System.out.println("\n\n\t-> No Fine, You will Pay Book's Price Only:-"
                                    + "\t\t\tPay: " + l.payFine(readerID, bookID, d, m, y));
                        } else {
                            System.out.println("\n\n\t-> Fine 10%, You will Pay Book's Price + Fine:-"
                                    + "\t\t\tPay: " + l.payFine(readerID, bookID, d, m, y));
                        }
                    }

                    Back_Option(back_option);
                    continue;
                //////////////////////////////////////////////////

                case 0:     //EXIT
                    cls();
                    System.out.println("\t\t*-> Program  Ended <-*\n\n"
                            + "\t\t    *-> Thanks<-*\n\n\n\n\n\n\n\n\n");
                    back_option = 0;
                //////////////////////////////////////////////////
            }

        } while (back_option != 0);     //LOOPs --> During Back_fn is true
    } //////////////////////////////////////////////--> End >< Of >< Program <--//////////////////////////////////////////////

    public static int Login() {
        int Id;
        String Password;

        {//Input Part
            System.out.println("\t\t-> Please Login First <-\n\t\t*************************\n\n");

            System.out.print("\n\n\tEnter User ID: ");
            Id = inputStatic.nextInt();

            System.out.print("\n\n\tEnter Password: ");
            Password = inputStatic.next();
        }

        {//Check Part
            if (Id == l.getId() && Password.equals(l.getPassword())) {
                //Librarian role
                cls();
                return 1;
            } else if (Id == r.getId() && Password.equals(r.getPassword())) {
                //Reader role
                cls();
                return 2;
            } else {
                //Invalid and try again
                cls();
                System.out.println("\n\n\tInvalid Login\n\n");
            }
        }
        return 0;
    }

    public static boolean Back_Option(int back_option) {
        System.out.print("\n\n\n****************************************************************************************************\n"
                + "\n\t° --> To Return Menu,, Enter [0] --> ");
        back_option = inputStatic.nextInt();

        if (back_option == 0) {
            return true;     //Back Successed,, Returning to Menu
        }

        while (back_option != 0) { //Invalid input & Try again
            System.out.print("\n\t\tInvalid "
                    + "\n\t° --> To Return Menu,, Enter [0] --> ");

            back_option = inputStatic.nextInt();

            if (back_option == 0) {
                return true;
            }
        }
        cls();
        return false;
    }

    public static void cls() {
        /*-> This static method is used specially
        to tric the user that the screen is cleared
        by adding 50 lines in series
        it can be called through -> cls();
         */
        for (int i = 1; i <= 50; i++) {
            System.out.print("\n");
        }
    }
}
