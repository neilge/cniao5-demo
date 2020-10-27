package demo.controller;

import demo.controller.common.JsonResponse;
import demo.service.CourseService;
import demo.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class VideoController {

    @Autowired private JWTUtil jwtUtil;
    @Autowired private CourseService courseService;

    @GetMapping("/video/{key}")
    public JsonResponse getVideo(@PathVariable("key") String key, HttpServletRequest request) {
        // 通过JWT获取用户信息
        String token = request.getHeader("Authorization");
        long accountId = jwtUtil.parseId(token);
        return JsonResponse.newSucceedBuilder().setData(courseService.getVideo(accountId, key)).build();
    }
}
