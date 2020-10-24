package demo.service;

import demo.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();

    Course getCourseById(long id);

    Course createCourse(Course course);
}
