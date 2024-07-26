package org.example.service;

import org.example.model.Course;
import org.example.repository.CourseRepository;
import org.example.repository.CourseRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements CourseService{
    CourseRepository courseRepositoryImpl = new CourseRepositoryImpl();
    List<String> courses = new ArrayList<>();


    public Boolean logIn(String email , String password){
        return courseRepositoryImpl.loggedIn(email,password);
    }

    public List<Course> searchCourse(String courseName){
        return courseRepositoryImpl.searchCourse(courseName);
    }

    public List<Course> display(int limit){
        return courseRepositoryImpl.display(limit);
    }

    public void displayCart(){
        for (String c:courses){
            System.out.println(c);
        }
    }
    public boolean addToCart(String course){
        courses.add(course);
        return true;
    }

    public boolean deleteFromCart(String courseNameToDelete){
        courses.remove(courseNameToDelete);
        return true;
    }

}
