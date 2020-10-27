package demo.controller;

import demo.controller.common.JsonResponse;
import demo.controller.common.VerificationRequest;
import demo.model.Account;
import demo.service.AccountService;
import demo.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Neo
 * @since 10/17/2020-7:51 PM
 */
@RestController
@RequestMapping("/account")
public class AccountController {

  @Autowired AccountService accountService;

  @Autowired private JWTUtil jwtUtil;

  @Autowired HttpServletRequest request;

  @GetMapping("/my_account")
  public JsonResponse getMyAccount() {
    Long accountId = jwtUtil.parseId(request.getHeader("Authorization"));
    return JsonResponse.newSucceedBuilder().setData(accountService.getAccount(accountId)).build();
  }

  @PostMapping("/captcha")
  public JsonResponse sendCaptcha(@RequestBody Account account) {
    return JsonResponse.newSucceedBuilder()
        .setData(accountService.generateCaptcha(account.getEmail()))
        .build();
  }

  @PostMapping("/registration")
  public JsonResponse registerAccount(
      @RequestBody VerificationRequest verificationRequest) {
    String encryptedCode = request.getHeader("token");
    return JsonResponse.newSucceedBuilder()
        .setData(
            accountService.createAccount(
                verificationRequest.getAccount(),
                verificationRequest.getVerificationCode(),
                encryptedCode))
        .build();
  }

  @PostMapping("/login")
  public JsonResponse login(@RequestBody Account account) {
    String jwt = accountService.login(account);
    return JsonResponse.newSucceedBuilder().setData(jwt).build();
  }
}
