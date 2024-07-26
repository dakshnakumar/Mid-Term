package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCourse {
    Course course1;
    Course course2;

    @BeforeEach
    void setUp(){
        course1 = new Course("machine learning","kumar","4");
        course2 = new Course("deep learning","michiang","2");
    }

    @Test
    void TestSetName(){
        course1.setCourseName("computer networks");
        assertEquals("computer networks",course1.getCourseName());
    }

    @Test
    void TestSetAuthor(){
        course1.setAuthor("kumarasamy");
        assertEquals("kumarasamy",course1.getAuthor());
    }
    @Test
    void TestSetDuration(){
        course1.setDuration("2");
        assertEquals("2",course1.getDuration());
    }


}
