package demo.controller;

import demo.controller.common.JsonResponse;
import demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

  @Autowired private TeacherService teacherService;

  @GetMapping("/teachers")
  public JsonResponse getAllTeachers() {
    return JsonResponse.newSucceedBuilder().setData(teacherService.getAllTeachers()).build();
  }
}
