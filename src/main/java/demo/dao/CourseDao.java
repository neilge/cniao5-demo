package demo.dao;

import demo.model.Course;
import demo.model.Lesson;

import java.util.List;

public interface CourseDao {

    List<Course> findAll();

    Course findCourseInfo(Long accountId, Long courseId);

    void addOne(Course course);

    void addOneToStudentCourse(Long courseId, Long accountId);

    List<Course> findAllByAccountId(Long accountId);

    Lesson findLessonByKey(String key, Long accountId);
}
