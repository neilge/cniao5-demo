package demo.service;

import demo.model.Account;

import java.util.List;

/**
 * @author Neo
 * @since 10/17/2020-7:47 PM
 */
public interface AccountService {

  List<Account> getAllAccounts();

  Account creatAccount(Account account, String verificationCode, String encryptedCode);

  Account getAccount(long id);

  Account getAccount(String email);

  String generateCaptcha(String email);

  String login(Account account);
}
