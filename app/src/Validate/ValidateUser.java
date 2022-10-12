package Validate;

import View.SignUp;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUser extends JDialog {
    public static final String regexname = "[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễếệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]+";
    public static final String regextelephone = "[+84][0-9]{3,15}";
    public static final String regexemail = "^[a-zA-Z]+[0-9_a-zA-z.]*@([a-z]+\\.[a-z]+)+";
    public static final String regexusername = "[a-z]{1,9}[0-9]{1,9}";
    public static final String regexpassword = "[a-z0-9]+";

    static SignUp signUp = new SignUp(null);

    public static String name(String name) {
        Pattern pattern = Pattern.compile(regexname);
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            return name;
        }
        return "";


    }

    public static String telephone(String phone) {
        Pattern pattern = Pattern.compile(regextelephone);
        Matcher matcher = pattern.matcher(phone);
        if (matcher.matches()) {
            return phone;

        }
        return "";


    }

    public static String email(String mail) {
        Pattern pattern = Pattern.compile(regexemail);
        Matcher matcher = pattern.matcher(mail);
        if (matcher.matches()) {
            return mail;
        }
        return "";

    }

    public static String username(String user) {
        Pattern pattern = Pattern.compile(regexusername);
        Matcher matcher = pattern.matcher(user);
        if (matcher.matches()) {
            return user;
        }
        return "";

    }

    public static String password(String pass) {
        Pattern pattern = Pattern.compile(regexpassword);
        Matcher matcher = pattern.matcher(pass);
        if (matcher.matches()) {
            return pass;
        }

        return "";
    }


}

