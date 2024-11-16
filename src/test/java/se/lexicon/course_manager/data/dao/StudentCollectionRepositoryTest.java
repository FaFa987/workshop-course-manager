package se.lexicon.course_manager.data.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager.data.sequencers.StudentSequencer;
import se.lexicon.course_manager.model.Student;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {StudentCollectionRepository.class})
public class StudentCollectionRepositoryTest {

    @Autowired
    private StudentDao testObject;

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertFalse(testObject == null);
    }

    // TODO Write your tests here


    @AfterEach
    void tearDown() {
        testObject.clear();
        StudentSequencer.setStudentSequencer(0);
    }

    @Test
    void createStudent() {

        Student create = testObject.createStudent("TEST" , "test@gmail" , "hhfdccfyfcy");
        assertNotNull(create);
    }

    @Test
    void findById() {

        Student create = testObject.createStudent("TEST" , "test@gmail" , "hhfdccfyfcy");
        Student found = testObject.findById(create.getId());
        assertEquals(create, found);
    }
}
