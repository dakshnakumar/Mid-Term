package org.example.service;

import org.example.model.Course;
import org.example.repository.CourseRepository;
import org.example.repository.CourseRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements CourseService{

    CourseRepository courseRepositoryImpl = new CourseRepositoryImpl();
    List<Course> courses = new ArrayList<>();

    //realted to db
    public Boolean logIn(String email , String password){
        return courseRepositoryImpl.loggedIn(email,password);
    }

    public Boolean signUp(String name , String email , String password){
        return courseRepositoryImpl.signUp(name,email,password);
    }
    public List<Course> searchCourse(String courseName){
        return courseRepositoryImpl.searchCourse(courseName);
    }


    // realted to cart
    public List<Course> display(int limit){
        return courseRepositoryImpl.display(limit);
    }

    public void displayCart(){
        for (Course c:courses){
            System.out.println(c.toString());
        }
    }
    public boolean addToCart(Course course){
        courses.add(course);
        return true;
    }

    public boolean deleteFromCart(Course course){
        courses.remove(course);
        return true;
    }

}
