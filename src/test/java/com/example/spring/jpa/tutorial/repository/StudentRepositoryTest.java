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

    @Test
    public void printStudentByLastNameNotNull() {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("meet");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameAndLastName() {
        List<Student> students = studentRepository.findByFirstNameAndLastName("vishesh", "baghel");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByEmailId() {
        Student student = studentRepository.getStudentByEmailId("vishesh@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailId() {
        String firstName = studentRepository.getStudentFirstNameByEmailId("vishesh@gmail.com");
        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printStudentByEmailIdNative() {
        Student student = studentRepository.getStudentByEmailIdNative("vishesh@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentByEmailIdNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailIdNativeNamedParam("vishesh@gmail.com");
        System.out.println("student = " + student);
    }

//    @Test
//    public void updateStudentNameByEmailId() {
//        studentRepository.updateStudentNameByEmailId("rishabh", "vishesh@gmail.com");
//    }
}