package com.example.spring.jpa.tutorial.repository;

import com.example.spring.jpa.tutorial.entity.Guardian;
import com.example.spring.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("vishesh")
                .lastName("baghel")
                .emailId("vishal@gmail.com")
//                .guardianName("meet")
//                .guardianEmail("meet@gmail.com")
//                .guardianMobile("1234567890")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("meet")
                .email("meet@gmail.com")
                .mobile("1234567890")
                .build();

        Student student = Student.builder()
                .firstName("vishesh")
                .lastName("baghel")
                .emailId("vasubaghel@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("vishesh");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("vi");
        System.out.println("students = " + students);
    }
}