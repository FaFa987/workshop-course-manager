package se.lexicon.course_manager.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseTest {

    Course course;
    Student student;


    @BeforeEach
    void setUp() {
        course = new Course(1);
        student = new Student(1);

    }

    @Test
    void enrollStudent() {
        course.enrollStudent(student);
        assertTrue(course.getStudents().contains(student));
    }

    @Test
    void unEnrollStudent() {

        course.setStudents(new ArrayList<>(Collections.singletonList(student)));

        assertTrue(course.unEnrollStudent(student));
        assertFalse(course.getStudents().contains(student));

    }
    // TODO Implement your tests here
}
