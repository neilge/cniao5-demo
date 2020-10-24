package demo.dao;

import demo.model.Course;

import java.util.List;

public interface CourseDao {

    List<Course> findAll();

    Course findById(long id);

    void addOne(Course course);

    void addOneToStudentCourse(long courseId, long accountId);

    List<Course> findAllByAccountId(long accountId);
}
