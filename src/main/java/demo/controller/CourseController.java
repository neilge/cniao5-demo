package demo.controller;

import demo.controller.common.Constant;
import demo.controller.common.JsonResponse;
import demo.model.Course;
import demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

  @Autowired private CourseService courseService;

  @GetMapping("/courses")
  public JsonResponse getAllCourses() {
    return JsonResponse.newSucceedBuilder()
        .setData(courseService.getAllCourses())
        .build();
  }

  @GetMapping("/id/{id}")
  public JsonResponse getCourseById(@PathVariable("id") long id) {
    return JsonResponse.newSucceedBuilder().setData(courseService.getCourseById(id)).build();
  }

  @PostMapping("/create")
  public JsonResponse createCourse(@RequestBody Course course) {
    return JsonResponse.newSucceedBuilder().setData(courseService.createCourse(course)).build();
  }
}
