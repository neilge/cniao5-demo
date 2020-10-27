package demo.dao;

import demo.model.Course;
import demo.model.Lesson;

import java.util.List;

public interface CourseDao {

    List<Course> findAll();

    Course findCourseInfo(long accountId, long courseId);

    void addOne(Course course);

    void addOneToStudentCourse(long courseId, long accountId);

    List<Course> findAllByAccountId(long accountId);

    Lesson findLessonByKey(String key, long accountId);
}
