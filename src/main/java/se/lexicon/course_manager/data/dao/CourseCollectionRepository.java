package se.lexicon.course_manager.data.dao;



import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

// TODO provide proper implementation.

public class CourseCollectionRepository implements CourseDao{

    private Collection<Course> courses;


    public CourseCollectionRepository(Collection<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {


        return null;

    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public Collection<Course> findByNameContains(String name) {
        return null;
    }

    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {
        return null;
    }

    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {
        return null;
    }

    @Override
    public Collection<Course> findAll() {
        return null;
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {

        Collection<Course> coursesForSpecificStudent = new HashSet<>();

        for (Course course : courses) {
            for (Student s : course.getStudents()) {
                if (s.getId() == studentId) {
                    coursesForSpecificStudent.add(course);
                }
            }
        }

        return coursesForSpecificStudent;
    }

    @Override
    public boolean removeCourse(Course course) {
        return false;
    }

    @Override
    public void clear() {
        this.courses = new HashSet<>();
    }
}
