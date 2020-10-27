package demo.service;

import demo.model.Account;

import java.util.List;

/**
 * @author Neo
 * @since 10/17/2020-7:47 PM
 */
public interface AccountService {

  Account createAccount(Account account, String verificationCode, String encryptedCode);

  Account getAccount(Long id);

  String generateCaptcha(String email);

  String login(Account account);
}
