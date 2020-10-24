package demo.dao;

import demo.model.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseDaoTest {

  @Autowired private CourseDao courseDao;

  @Test
  public void testCourseDao() {
    List<Course> courses = courseDao.findAll();
    System.out.println(courses);
  }

  @Test
  public void testGetCourseWithLessons() {
    Course course = courseDao.findById(1);
    System.out.println(course);
    System.out.println(course.getLessons());
  }

  @Test
  public void testGetAllCourseForAnAccount() {
    List<Course> courses = courseDao.findAllByAccountId(3);
    System.out.println(courses);
  }
}
