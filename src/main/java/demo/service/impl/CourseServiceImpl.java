package demo.service.impl;

import demo.common.BackendException;
import demo.dao.CourseDao;
import demo.model.Course;
import demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

  @Autowired private CourseDao courseDao;

  @Override
  public List<Course> getAllCourses() {
    return courseDao.findAll();
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
}
