package demo.controller.common;

import demo.common.BackendException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BackendExceptionHandler {
  @ExceptionHandler(value = BackendException.class)
  @ResponseBody
  public JsonResponse backendExceptionHandler(BackendException exception) {
    return JsonResponse.newBuilder().setCode(0).setMessage(exception.getMessage()).build();
  }
}
