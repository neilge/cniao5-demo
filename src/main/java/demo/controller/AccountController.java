package demo.controller;

import demo.common.BackendException;
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
import java.util.List;

/**
 * @author Neo
 * @since 10/17/2020-7:51 PM
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping("/captcha")
    public String sendCaptcha(@RequestBody String email) {
        return accountService.sendCaptcha(email);
    }

    @PostMapping("/registration/{verificationCode}")
    public JsonResponse registerAccount(@RequestBody Account account, @PathVariable String verificationCode, HttpServletRequest request) {
        String encryptedCode = request.getHeader("token");
        JsonResponse response = new JsonResponse();
        try {
            response.setCode(1);
            response.setMessage("succeed");
            response.setData(accountService.creatAccount(account, verificationCode, encryptedCode));
            return response;
        } catch (BackendException exception) {
            response.setCode(0);
            response.setMessage(exception.getMessage());
            return response;
        }
    }
}
