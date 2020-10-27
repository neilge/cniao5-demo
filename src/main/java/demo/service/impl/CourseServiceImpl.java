package demo.service.impl;

import demo.common.BackendException;
import demo.dao.CourseDao;
import demo.model.Course;
import demo.model.Lesson;
import demo.controller.common.Video;
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
  public Course getCourse(long accountId, long courseId) {
    return courseDao.findCourseInfo(accountId, courseId);
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
    return courseDao.findCourseInfo(accountId, courseId);
  }

  @Override
  public Video getVideo(long accountId, String key) {
    Lesson lesson = courseDao.findLessonByKey(key, accountId);
    if (lesson.getCourse().isPurchased()
        || lesson.isFree()
        || lesson.getCourse().isFree()) {
      String uri = getUriByKey(key);
      return Video.newBuilder().setKey(key).setTitle(lesson.getName()).setUrl(uri).build();
    }
    throw new BackendException("您没有权限访问该视频");
  }

  private String getUriByKey(String key) {
    return "https://dummyvideosrouce.com/video/" + key;
  }
}
