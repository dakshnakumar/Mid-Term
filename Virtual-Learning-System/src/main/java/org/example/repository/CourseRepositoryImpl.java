package org.example.repository;

import org.example.database.DatabaseConnection;
import org.example.model.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseRepositoryImpl {

    DatabaseConnection databaseConnection = new DatabaseConnection();
//    Map<String,String> logInDetailsFromDb = new HashMap<>();

    public Boolean validateUser(String email , String password){
        try{
            String gmail;
            String pass;
            Statement statement = databaseConnection.getConnection();
            String sql = "SELECT * FROM login where gmail='" + email + "';";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                gmail = resultSet.getString("gmail");
                pass = resultSet.getString("password");
                if (gmail.equals(email)) {
                    if (pass.equals(password)) {
                        return true;
                    } else return false;
                } else return false;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Course> searchCourseInDb(String courseName){
        try{
            List<Course> courses = new ArrayList<>();
            Statement statement = databaseConnection.getConnection();
            String sql = "SELECT * FROM course where courseName='" + courseName + "';";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String CourseName = resultSet.getString("CourseName");
                String author = resultSet.getString("authorName");
                String duration = resultSet.getString("duration");
                courses.add(new Course(CourseName,author,duration));
            }
            return courses;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Course> display(int limit){
        try{
            List<Course> courses = new ArrayList<>();
            Statement statement = databaseConnection.getConnection();
            String sql = "SELECT * FROM course limit='" + limit + "';";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String CourseName = resultSet.getString("CourseName");
                String author = resultSet.getString("authorName");
                String duration = resultSet.getString("duration");
                courses.add(new Course(CourseName,author,duration));
            }
            return courses;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
