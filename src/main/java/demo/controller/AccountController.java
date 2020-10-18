package demo.controller;

import demo.model.Account;
import demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
