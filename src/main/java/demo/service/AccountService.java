package demo.service;

import demo.model.Account;

import java.util.List;

/**
 * @author Neo
 * @since 10/17/2020-7:47 PM
 */
public interface AccountService {

    List<Account> getAllAccounts();

    String sendCaptcha(String email);
}
