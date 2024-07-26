package org.example.ui;

import org.example.model.Course;
import org.example.service.CourseServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MainMenu {

    Scanner input  = new Scanner(System.in);
    CourseServiceImpl courseServiceImpl = new CourseServiceImpl();

    public int Menu(){
        System.out.println("1.LogIn");
        System.out.println("2.SignUp");
        System.out.println("3.Break");
        int response = input.nextInt();
        input.nextLine();
        return response;
    }

    public void login(){
        System.out.println("Enter the mail ID");
        String email = input.nextLine();
        System.out.println("Enter password");
        String password = input.nextLine();

        Boolean isPresent = courseServiceImpl.logIn(email,password);
        if(isPresent){
            System.out.println("Sucessfully loggedIn");
            System.out.println("---------------********-----------------");
            System.out.println("1.Search for the course");
            System.out.println("2.Display all the course");
            System.out.println("3.Add course to cart");
            System.out.println("4.Delete course from the cart");
            System.out.println("5.Enroll in the course");
            int response = input.nextInt();
            input.nextLine();

            switch (response){
                case 1:
                    System.out.println("Enter the course name you want to search");
                    String courseToSearch = input.nextLine();
                    List<Course> course = courseServiceImpl.searchCourse(courseToSearch);
                    for (Course course1:course){
                        System.out.println(course1.toString());
                    }
                    break;

                case 2:
                    System.out.println("Enter the number of records you want to show");
                    int limit = input.nextInt();
                    List<Course> courses = courseServiceImpl.display(limit);
                    for (Course course1:courses){
                        System.out.println(course1.toString());
                    }
                    break;

                case 3:
                    System.out.println("Enter the course you want to enter in the cart");
                    String courseName = input.nextLine();
                    boolean isAdded = courseServiceImpl.addToCart(courseName);
                    if(isAdded){
                        System.out.println("Successfully added to the cart");
                    } else System.out.println("course is not added to the cart");
                    break;

                case 4:
                    System.out.println("Enter the course name you want to delete in the cart");
                    String courseNameToDelete = input.nextLine();
                    boolean isDeleted = courseServiceImpl.deleteFromCart(courseNameToDelete);
                    if(isDeleted){
                        System.out.println("successfully deleted from cart");
                    } else System.out.println("not deleted from cart");
                    break;

                 default:
                    System.out.println("please enter valid input");
                    break;
//                case 5:
//                    System.out.println("Which course you want to enroll");
            }
        } else System.out.println("Please signUp");
    }

    public void signUp(){
        System.out.println("Enter the mail ID to register");
        String email = input.nextLine();
        System.out.println("Enter password to register");
        String password = input.nextLine();
    }
}
