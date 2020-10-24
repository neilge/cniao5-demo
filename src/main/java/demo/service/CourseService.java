package demo.service;

import demo.model.Course;

import java.util.List;

public interface CourseService {
  List<Course> getAllCourses();

  List<Course> getAllMyCourses(long accountId);

  Course getCourse(long id);

  Course createCourse(Course course);

  Course purchaseCourse(long courseId, long accountId);
}
