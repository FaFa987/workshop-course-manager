package se.lexicon.course_manager.data.dao;



import se.lexicon.course_manager.data.sequencers.StudentSequencer;
import se.lexicon.course_manager.model.Student;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;


public class StudentCollectionRepository implements StudentDao {

    private Collection<Student> students;

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public Student createStudent(String name, String email, String address) {

        Student newStudent = new Student(StudentSequencer.nextStudentId(), name , email , address);
        if(students.add(newStudent)) {
            return newStudent;
        }
        return null;

        //return student.add(newStudent) ? newStudent : null
    }


    @Override
    public Student findByEmailIgnoreCase(String email) {

        for(Student student : students) {
            if(student.getEmail().trim().equalsIgnoreCase(email))
                return student;
        }
        return null;
    }

    @Override
    public Collection<Student> findByNameContains(String name) {

        Collection<Student> foundMatches = new HashSet<>();

        for(Student s : students) {
            if(s.getName().trim().toLowerCase().contains(name.trim().toLowerCase()));
            foundMatches.add(s);
        }
        return foundMatches;
    }

    @Override
    public Student findById(int id) {

        for(Student student : students) {
            if(student.getId() == id)
                return student;
        }
        return null;

    }

    @Override
    public Collection<Student> findAll() {

        // return new HashSet<>(students);
        return Collections.unmodifiableCollection(students);
    }

    @Override
    public boolean removeStudent(Student student) {

        return students.remove(student);
    }

    @Override
    public void clear() {
        this.students = new HashSet<>();
    }
}
