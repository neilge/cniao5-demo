package demo.service.impl;

import demo.common.BackendException;
import demo.dao.CourseDao;
import demo.model.Course;
import demo.service.CourseService;
import demo.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

  @Autowired private JWTUtil jwtUtil;

  @Autowired private CourseDao courseDao;

  @Override
  public List<Course> getAllCourses() {
    return courseDao.findAll();
  }

  @Override
  public List<Course> getAllMyCourses(long accountId) {
    return courseDao.findAllByAccountId(accountId);
  }

  @Override
  public List<Course> getAllMyCourses(String jwt) {
    long id = 0;
    try {
      id = jwtUtil.parseId(jwt);
    } catch (Exception e) {
      e.printStackTrace();
      throw new BackendException("验证失败, 请重新登录");
    }
    return courseDao.findAllByAccountId(id);
  }

  @Override
  public Course getCourse(long id) {
    return courseDao.findById(id);
  }

  @Override
  public Course createCourse(Course course) {
    try {
      courseDao.addOne(course);
    } catch (Exception e) {
      e.printStackTrace();
      throw new BackendException("添加课程失败");
    }
    return course;
  }

  @Override
  public Course purchaseCourse(long courseId, long accountId) {
    try {
      courseDao.addOneToStudentCourse(courseId, accountId);
    } catch (Exception e) {
      e.printStackTrace();
      throw new BackendException("购买课程失败");
    }
    return courseDao.findById(courseId);
  }
}
