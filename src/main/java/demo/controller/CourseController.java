package demo.controller;

import demo.controller.common.JsonResponse;
import demo.controller.common.PurchaseRequest;
import demo.model.Course;
import demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/course")
public class CourseController {

  @Autowired private CourseService courseService;

  @GetMapping("/courses")
  public JsonResponse getAllCourses() {
    return JsonResponse.newSucceedBuilder().setData(courseService.getAllCourses()).build();
  }

  @GetMapping("/my_courses/{id}")
  public JsonResponse getAllMyCourses(@PathVariable("id") long id) {
    return JsonResponse.newSucceedBuilder().setData(courseService.getAllMyCourses(id)).build();
  }

  @GetMapping("/my_courses")
  public JsonResponse getAllMyCourses(HttpServletRequest request) {
    String token = request.getHeader("Authorization");
    return JsonResponse.newSucceedBuilder().setData(courseService.getAllMyCourses(token)).build();
  }

  @GetMapping("/id/{id}")
  public JsonResponse getCourseById(@PathVariable("id") long id) {
    return JsonResponse.newSucceedBuilder().setData(courseService.getCourse(id)).build();
  }

  @PostMapping("/create")
  public JsonResponse createCourse(@RequestBody Course course) {
    return JsonResponse.newSucceedBuilder().setData(courseService.createCourse(course)).build();
  }

  @PostMapping("/purchase")
  public JsonResponse purchaseCourse(@RequestBody PurchaseRequest request) {
    return JsonResponse.newSucceedBuilder()
        .setData(courseService.purchaseCourse(request.getCourseId(), request.getAccountId()))
        .build();
  }
}
