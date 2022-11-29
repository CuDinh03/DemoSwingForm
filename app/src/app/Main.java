package app;

import View.LoginView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        LoginView loginView = new LoginView(null);
        loginView.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

    }


}
