package demo.dao;

import demo.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeacherDaoTest {

  @Autowired private TeacherDao teacherDao;

  @Test
  public void testGetAll() {
    List<Teacher> teachers = teacherDao.findAll();

    System.out.println(teachers);
  }

  @Test
  public void testGetById() {
    Teacher teacher = teacherDao.findById(1L);
    System.out.println(teacher);
    System.out.println(teacher.getCourses());
  }
}
