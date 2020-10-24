package demo.service.impl;

import demo.common.BackendException;
import demo.dao.AccountDao;
import demo.model.Account;
import demo.service.AccountService;
import demo.service.MailService;
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

  @Autowired private VerificationUtil verificationUtil;

  @Override
  public List<Account> getAllAccounts() {
    return accountDao.findAll();
  }

  @Override
  public Account getAccount(long id) {
    Account account = accountDao.findById(id);
    if (account == null) {
      throw new BackendException("用户" + id + "不存在");
    }
    return account;
  }

  @Override
  public Account getAccount(String email) {
    Account account = accountDao.findByEmail(email);
    if (account == null) {
      throw new BackendException("用户" + email + "不存在");
    }
    return account;
  }

  @Override
  public String generateCaptcha(String email) {
    if (accountDao.findByEmail(email) != null) {
      throw new BackendException("邮箱已被注册, 请选择其他邮箱");
    }
    String verificationCode = verificationUtil.generateVerificationCode();
    try {
      mailService.sendMail(email, "菜鸟窝注册验证", "验证码为: " + verificationCode);
      return verificationUtil.getVerificationToken(verificationCode);
    } catch (Exception e) {
      throw new BackendException("邮件发送失败");
    }
  }

  @Override
  public Account creatAccount(Account account, String verificationCode, String token) {
    if (verificationUtil.isTokenExpired(token)) {
      throw new BackendException("验证码已失效");
    }
    if (!verificationUtil.isVerificationTokenMatched(token, verificationCode)) {
      throw new BackendException("验证码错错误");
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
}
