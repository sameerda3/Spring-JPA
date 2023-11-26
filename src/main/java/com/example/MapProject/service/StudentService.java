package com.example.MapProject.service;

import com.example.MapProject.model.Course;
import com.example.MapProject.model.Student;
import com.example.MapProject.repository.CourseRepository;
import com.example.MapProject.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public void saveStudent(Student studentid) {
        studentRepository.save(studentid);
    }

    public List<Student> getStudentDetails(Long studentId) {
        if (studentId != null) {
            return studentRepository.findAllByStudentid(studentId);
        } else {
            return studentRepository.findAll();
        }
    }

    public void deleteStudent(Long studentid) {
        studentRepository.deleteById(studentid);
    }

    public Student assignCourseToStudent(Long studentId, Long courseId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Optional<Course> optionalCourse = courseRepository.findById(courseId);

        if (optionalStudent.isPresent() && optionalCourse.isPresent()) {
            Student student = optionalStudent.get();
            Course course = optionalCourse.get();

            Set<Course> courseSet = student.getAssignedCourse();
            courseSet.add(course);
            student.setAssignedCourse(courseSet);

            return studentRepository.save(student);
        } else {
            return null;
        }
    }

}