package org.example.model;

public class Course {

    String courseName;
    String author;
    String duration;

    public Course(String courseName , String author , String duration ){
        this.courseName = courseName;
        this.author = author;
        this.duration = duration;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public String toString(){
        return "Course{"+this.courseName+","+this.author+","+this.duration+"};";
    }
}
