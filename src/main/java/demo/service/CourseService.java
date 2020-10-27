package demo.service;

import demo.model.Course;
import demo.model.Video;

import java.util.List;

public interface CourseService {
  List<Course> getAllCourses();

  List<Course> getAllPurchasedCourses(Long id);

  Course getCourse(Long accountId, Long courseId);

  Course createCourse(Course course);

  Course purchaseCourse(Long courseId, Long accountId);

  Video getVideo(Long accountId, String key);
}
