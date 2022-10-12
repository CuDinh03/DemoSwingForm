package Model;

import java.io.Serializable;

public class Admin extends User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String key;

    public Admin() {
    }

    public Admin(String key) {
        this.key = key;
    }

    public Admin(int id, String fullname, String user, String passWord, String gender, String email, String phone, String address, String key) {
        super(id, fullname, user, passWord, gender, email, phone, address);
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "key='" + key + '\'' +
                '}';
    }
}
