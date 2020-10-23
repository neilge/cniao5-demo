package demo.controller;

import demo.controller.common.JsonResponse;
import demo.model.Account;
import demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Neo
 * @since 10/17/2020-7:51 PM
 */
@RestController
@RequestMapping("/account")
public class AccountController {

  @Autowired AccountService accountService;

  @GetMapping("/accounts")
  public JsonResponse getAllAccounts() {
    return JsonResponse.newBuilder()
        .setCode(1)
        .setMessage("succeed")
        .setData(accountService.getAllAccounts())
        .build();
  }

  @GetMapping("/id/{id}")
  public JsonResponse getAccountById(@PathVariable("id") long id) {
    return JsonResponse.newBuilder()
        .setCode(1)
        .setMessage("succeed")
        .setData(accountService.getAccount(id))
        .build();
  }

  @GetMapping("/email/{email}")
  public JsonResponse getAccountByEmail(@PathVariable("email") String email) {
    return JsonResponse.newBuilder()
        .setCode(1)
        .setMessage("succeed")
        .setData(accountService.getAccount(email))
        .build();
  }

  @PostMapping("/captcha")
  public JsonResponse sendCaptcha(@RequestBody Account account) {
    return JsonResponse.newBuilder()
        .setCode(1)
        .setMessage("succeed")
        .setData(accountService.sendCaptcha(account.getEmail()))
        .build();
  }

  @PostMapping("/registration/{verificationCode}")
  public JsonResponse registerAccount(
      @RequestBody Account account,
      @PathVariable String verificationCode,
      HttpServletRequest request) {
    String encryptedCode = request.getHeader("token");
    return JsonResponse.newBuilder()
        .setCode(1)
        .setMessage("succeed")
        .setData(accountService.creatAccount(account, verificationCode, encryptedCode))
        .build();
  }
}
