package Controller;


import Data.IOWriteAndRead;
import Model.Admin;
import Model.User;
import View.AdminView;

import java.io.File;
import java.util.ArrayList;

public class ControllerAccount {
    File file = new File("User.txt");
    IOWriteAndRead ioWriteAndRead = new IOWriteAndRead();

    ArrayList<User> listUser = ioWriteAndRead.read(file);

    User user = new User();


//    public void addAdmin(){
//        int i =0;
//        while (i<listUser.size()){
//            if (){
//
//            }
//        }
//    }

}
