package demo.service;

import demo.model.Course;
import demo.controller.common.Video;

import java.util.List;

public interface CourseService {
  List<Course> getAllCourses();

  List<Course> getAllMyCourses(String jwt);

  Course getCourse(long accountId, long courseId);

  Course createCourse(Course course);

  Course purchaseCourse(long courseId, long accountId);

  Video getVideo(long accountId, String key);
}
