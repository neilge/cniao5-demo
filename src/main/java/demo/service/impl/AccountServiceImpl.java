package demo.service.impl;

import demo.dao.AccountDao;
import demo.model.Account;
import demo.service.AccountService;
import demo.service.MailService;
import demo.util.AESUtil;
import demo.util.VerificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Neo
 * @since 10/17/2020-7:48 PM
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private MailService mailService;

    @Autowired
    private AESUtil aesUtil;

    @Override
    public List<Account> getAllAccounts() {
        return accountDao.findAll();
    }

    @Override
    public String sendCaptcha(String email) {
        String verificationCode = VerificationUtil.generateVerificationCode();
        mailService.sendMail(email, "菜鸟窝注册验证", "验证码为: " + verificationCode);
        return aesUtil.encrypt(verificationCode);
    }
}
