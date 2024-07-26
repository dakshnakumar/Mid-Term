package org.example.service;

import org.example.model.Course;
import org.example.repository.CourseRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl {
    CourseRepositoryImpl courseRepositoryImpl = new CourseRepositoryImpl();
    List<String> courses = new ArrayList<>();

    public Boolean logIn(String email , String password){
        Boolean isPresent = courseRepositoryImpl.validateUser(email,password);
        return isPresent;
    }

    public List<Course> searchCourse(String courseName){
        return courseRepositoryImpl.searchCourseInDb(courseName);
    }

    public List<Course> display(int limit){
        List<Course> courses = courseRepositoryImpl.display(limit);
        return courses;
    }

    public boolean AddToCart(String course){
        courses.add(course);
        return true;
    }

    public boolean DeleteFromCart(String courseNameToDelete){
        courses.remove(courseNameToDelete);
        return true;
    }

}
