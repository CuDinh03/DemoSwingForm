package Model;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String fullname;
    private String user; // ten dang nhap
    private String passWord; // pass

    private String gender;

    private String email;

    private String phone;

    private String address;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String fullname) {

        this.fullname = fullname;


    }

    public User(int id, String fullname, String user, String passWord, String gender, String email, String phone, String address) {
        this.id = id;
        this.fullname = fullname;
        this.user = user;
        this.passWord = passWord;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public User(String fullname, String user, String passWord, String gender, String email, String phone, String address) {
        this.fullname = fullname;
        this.user = user;
        this.passWord = passWord;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", user='" + user + '\'' +
                ", passWord='" + passWord + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
