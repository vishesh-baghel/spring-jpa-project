package com.example.spring.jpa.tutorial.repository;

import com.example.spring.jpa.tutorial.entity.Course;
import com.example.spring.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

//    @Test
//    public void saveCourseWithTeacher() {
//        Teacher teacher = Teacher.builder()
//                .firstName("John")
//                .lastName("Doe")
//                .build();
//
//        Course course = Course.builder()
//                .title("Python")
//                .credit(10)
//                .teacher(teacher)
//                .build();
//        courseRepository.save(course);
//    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
        Pageable secondPageWithTwoElements = PageRequest.of(1, 2);

        long totalElements = courseRepository.findAll(firstPageWithTwoElements).getTotalElements();
        List<Course> courses = courseRepository.findAll(secondPageWithTwoElements).getContent();

        long totalPages = courseRepository.findAll(firstPageWithTwoElements).getTotalPages();
        System.out.println("courses = " + courses);
        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages = " + totalPages);
    }

    @Test
    public void findAllWithSorting() {
        Pageable sortByTitleDesc = PageRequest.of(0, 2, Sort.by("title").descending());

        Pageable sortByCreditAsc = PageRequest.of(0, 2, Sort.by("credit").ascending());

        List<Course> courses = courseRepository.findAll(sortByTitleDesc).getContent();
        List<Course> courses1 = courseRepository.findAll(sortByCreditAsc).getContent();

        System.out.println("courses = " + courses);
        System.out.println("courses1 = " + courses1);
    }

    @Test
    public void findByTitleContaining() {
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
        Pageable secondPageWithTwoElements = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findByTitleContaining("Java", firstPageWithTwoElements).getContent();
        List<Course> courses1 = courseRepository.findByTitleContaining("Java", secondPageWithTwoElements).getContent();

        System.out.println("courses = " + courses);
        System.out.println("courses1 = " + courses1);
    }
}