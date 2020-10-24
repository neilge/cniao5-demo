package demo.service;

import demo.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course getCourse(long id);

    Course createCourse(Course course);
}
