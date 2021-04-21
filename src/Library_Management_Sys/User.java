/*
 * Licensed to -> ENG: Ahmed Nasser
 *             -> email: a1h1m1e1d1.00@gmail.com
 *             -> phone: +201270800202
 */
package Library_Management_Sys;

public interface User {

    public int searchBook(int book_id);

    public String Search_For_Book(int bookId);

    public int searchUser(int user_id);

    public void rentBook();
}
