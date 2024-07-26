package org.example.service;

import org.example.model.Course;

import java.util.List;

public interface CourseService {

    public Boolean logIn(String email , String password);
    public List<Course> searchCourse(String courseName);
    public List<Course> display(int limit);
    public void displayCart();
    public boolean addToCart(String course);
    public boolean deleteFromCart(String courseNameToDelete);
}
