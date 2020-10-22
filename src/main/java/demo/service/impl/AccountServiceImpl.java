package demo.service.impl;

import demo.common.BackendException;
import demo.dao.AccountDao;
import demo.model.Account;
import demo.service.AccountService;
import demo.service.MailService;
import demo.util.AESUtil;
import demo.util.VerificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Neo
 * @since 10/17/2020-7:48 PM
 */
@Service
public class AccountServiceImpl implements AccountService {

  @Autowired private AccountDao accountDao;

  @Autowired private MailService mailService;

  @Autowired private AESUtil aesUtil;

  @Override
  public List<Account> getAllAccounts() {
    return accountDao.findAll();
  }

  @Override
  public Account creatAccount(Account account, String verificationCode, String encryptedCode) {
    if (!aesUtil.decrypt(encryptedCode).equals(verificationCode)) {
      throw new BackendException("验证码错误");
    }
    try {
      accountDao.addOne(account);
    } catch (Exception e) {
      if (e instanceof DuplicateKeyException) {
        throw new BackendException("邮箱已注册, 请选择其他邮箱");
      }
      throw new BackendException("数据库未知错误");
    }
    return account;
  }

  @Override
  public String sendCaptcha(String email) {
    String verificationCode = VerificationUtil.generateVerificationCode();
    mailService.sendMail(email, "菜鸟窝注册验证", "验证码为: " + verificationCode);
    return aesUtil.encrypt(verificationCode);
  }
}
