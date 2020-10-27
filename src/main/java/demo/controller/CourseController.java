package demo.controller;

import demo.controller.common.JsonResponse;
import demo.model.Course;
import demo.service.CourseService;
import demo.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/course")
public class CourseController {

  @Autowired private CourseService courseService;

  @Autowired private JWTUtil jwtUtil;

  @Autowired HttpServletRequest request;

  @GetMapping("/courses")
  public JsonResponse getAllCourses() {
    return JsonResponse.newSucceedBuilder().setData(courseService.getAllCourses()).build();
  }

  @GetMapping("/my_courses")
  public JsonResponse getAllMyCourses() {
    return JsonResponse.newSucceedBuilder()
        .setData(courseService.getAllPurchasedCourses(getAccountId()))
        .build();
  }

  @GetMapping("/id/{id}")
  public JsonResponse getCourseById(@PathVariable("id") Long courseId) {
    return JsonResponse.newSucceedBuilder()
        .setData(courseService.getCourse(getAccountId(), courseId))
        .build();
  }

  @PostMapping("/create")
  public JsonResponse createCourse(@RequestBody Course course) {
    return JsonResponse.newSucceedBuilder().setData(courseService.createCourse(course)).build();
  }

  @GetMapping("/purchase/{courseId}")
  public JsonResponse purchaseCourse(@PathVariable("courseId") Long courseId) {
    return JsonResponse.newSucceedBuilder()
        .setData(courseService.purchaseCourse(courseId, getAccountId()))
        .build();
  }

  private Long getAccountId() {
    String token = request.getHeader("Authorization");
    return jwtUtil.parseId(token);
  }
}
