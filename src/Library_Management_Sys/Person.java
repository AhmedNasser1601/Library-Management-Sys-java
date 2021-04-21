/*
 * Licensed to -> ENG: Ahmed Nasser
 *             -> email: a1h1m1e1d1.00@gmail.com
 *             -> phone: +201270800202
 */
package Library_Management_Sys;

public class Person {

    private String fName;
    private String lName;
    private String type;
    private long phone;
    private String address;
    private String email;
    private boolean isBlock;

    public Person() {
    }

    public Person(String fName, String lName, String type, long phone, String address, String email, boolean isBlock) {
        this.fName = fName;
        this.lName = lName;
        this.type = type;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.isBlock = isBlock;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsBlock(boolean isBlock) {
        this.isBlock = isBlock;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getType() {
        return type;
    }

    public long getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public boolean isIsBlock() {
        return isBlock;
    }
}
