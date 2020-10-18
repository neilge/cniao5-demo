package demo.service.impl;

import demo.dao.AccountDao;
import demo.model.Account;
import demo.service.AccountService;
import demo.service.MailService;
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

    @Override
    public List<Account> getAllAccounts() {
        return accountDao.findAll();
    }

    @Override
    public String sendCaptcha(String email) {
        mailService.sendMail(email, "菜鸟窝注册验证", "验证内容");
        return "success";
    }
}
