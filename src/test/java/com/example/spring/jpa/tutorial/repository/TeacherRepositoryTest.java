package com.example.spring.jpa.tutorial.repository;

import com.example.spring.jpa.tutorial.entity.Course;
import com.example.spring.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseCalculus = Course.builder()
                .title("Calculus")
                .credit(3)
                .build();

        Course coursePhysics = Course.builder()
                .title("Physics")
                .credit(3)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("John")
                .lastName("Doe")
                .courses(List.of(courseCalculus, coursePhysics))
                .build();
        teacherRepository.save(teacher);
    }
}