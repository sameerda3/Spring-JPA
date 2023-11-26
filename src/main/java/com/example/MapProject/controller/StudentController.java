package com.example.MapProject.controller;

import com.example.MapProject.model.Student;
import com.example.MapProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public List<Student> getStudent(@PathVariable(required = false) Long id) {
        return studentService.getStudentDetails(id);
    }

    @PostMapping
    public ResponseEntity<Void> saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<Void> assignCourseToStudent(
            @PathVariable("studentId") Long studentId,
            @PathVariable("courseId") Long courseId) {
        studentService.assignCourseToStudent(studentId, courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
