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
}
