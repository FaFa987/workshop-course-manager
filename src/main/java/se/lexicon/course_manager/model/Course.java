package se.lexicon.course_manager.model;

import se.lexicon.course_manager.data.sequencers.StudentSequencer;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

// TODO implement model
public class Course {
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private Collection<Student> students;

    public Course(String courseName, LocalDate startDate, int weekDuration, Collection<Student> students) {
        this.id = StudentSequencer.nextStudentId();
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = students;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getId() {
        return id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }
    public boolean enrollStudent(Student student) {

        return this.students.add(student);
    }
    public boolean unenrollStudent(Student student) {
        return this.students.remove(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && weekDuration == course.weekDuration && Objects.equals(courseName, course.courseName) && Objects.equals(startDate, course.startDate) && Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, startDate, weekDuration, students);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                '}';
    }
}
