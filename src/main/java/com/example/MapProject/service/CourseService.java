package com.example.MapProject.service;

import com.example.MapProject.model.Course;

import com.example.MapProject.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourseDetails(Long courseid) {
        if (null != courseid) {
            return courseRepository.findAllByCourseid(courseid);
        } else {
            return courseRepository.findAll();
        }
    }

    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(Long courseid) {
        courseRepository.deleteById(courseid);
    }
}
