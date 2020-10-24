package demo.dao;

import demo.model.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> findAll();
}
