package org.example;


import org.example.ui.MainMenu;

import java.util.InputMismatchException;

public class App {


    public static void main( String[] args )
    {
        try{
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

                default:
                    System.out.println("please enter valid input");
            }
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }

    }
}
