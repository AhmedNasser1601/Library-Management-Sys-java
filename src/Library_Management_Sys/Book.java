/*
 * Licensed to -> ENG: Ahmed Nasser
 *             -> email: ahmednasser1601@gmail.com
 *             -> phone: +201270800202
 */
package Library_Management_Sys;

public class Book {

    private int book_id;
    private String name;
    private float price;
    private String author;
    private String publisher;
    private String reader_name;
    private int reader_id;

    public Book() {
    }

    public Book(int book_id, String name, float price, String author, String publisher) {
        this.book_id = book_id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_name(String reader_name) {
        this.reader_name = reader_name;
    }

    public String getReader_name() {
        return reader_name;
    }

    public void setId(int book_id) {
        this.book_id = book_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return book_id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public float getPrice() {
        return price;
    }
}
