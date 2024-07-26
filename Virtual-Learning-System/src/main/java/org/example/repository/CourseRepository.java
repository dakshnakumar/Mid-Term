package org.example.repository;

import org.example.model.Course;

import java.util.List;

public interface CourseRepository {

    Boolean loggedIn(String email , String password);
     List<Course> display(int limit);
     List<Course> searchCourse(String courseName);
     Boolean signUp(String name , String gmail , String password);
}
