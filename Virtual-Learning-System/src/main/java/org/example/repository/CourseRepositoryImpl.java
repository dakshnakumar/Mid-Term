package org.example.repository;

import org.example.database.DatabaseConnection;
import org.example.model.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CourseRepositoryImpl implements CourseRepository{

    DatabaseConnection databaseConnection = new DatabaseConnection();

// using validateUser method to validate the user , since in interface only loggedIn is mentioned.
    public Boolean loggedIn(String email , String password){
        return validateUser(email , password);
    }

    // business logic to validate user
    public Boolean validateUser(String email , String password){
        try{
            Statement statement = databaseConnection.getConnection();
            String sql = "SELECT * FROM login where gmail='" + email + "';";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                String gmail = resultSet.getString("gmail");
                String pass = resultSet.getString("password");
                if (gmail.equals(email)) {
                    return pass.equals(password);
                } else return false;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Boolean signUp(String name , String email , String password){
        try{
            Statement statement = databaseConnection.getConnection();
            String sql = "INSERT into login (name,gmail,password) VALUES('"+name+"','"+email+"','"+password+"');";
            int affectedRows = statement.executeUpdate(sql);
            return affectedRows >0;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }


    //to search course in the db
    public List<Course> searchCourse(String courseName){
        return searchCourseInDb(courseName);
    }


    public List<Course> searchCourseInDb(String courseName){
        try{
            List<Course> courses = new ArrayList<>();
            Statement statement = databaseConnection.getConnection();
            String sql = "SELECT * FROM course where courseName='" + courseName + "';";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String courseNameFromDb = resultSet.getString("CourseName");
                String author = resultSet.getString("authorName");
                String duration = resultSet.getString("duration");
                courses.add(new Course(courseNameFromDb,author,duration));
            }
            return courses;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Collections.emptyList();
    }

    public List<Course> display(int limit){
        try{
            List<Course> courses = new ArrayList<>();
            Statement statement = databaseConnection.getConnection();
            String sql = "SELECT * FROM course limit='" + limit + "';";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String courseName = resultSet.getString("CourseName");
                String author = resultSet.getString("authorName");
                String duration = resultSet.getString("duration");
                courses.add(new Course(courseName,author,duration));
            }
            return courses;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Collections.emptyList();
    }
}
