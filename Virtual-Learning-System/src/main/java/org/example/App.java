package org.example;


import org.example.ui.MainMenu;

public class App {


    public static void main( String[] args )
    {
        MainMenu mainMenu = new MainMenu();
            int respones = mainMenu.Menu();

            switch (respones) {
                case 1:
                    mainMenu.login();
                    break;
                case 2:
                    mainMenu.signUp();
                    break;
                case 3:
                    break;
        }

    }
}
