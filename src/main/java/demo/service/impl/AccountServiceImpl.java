package demo.service.impl;

import demo.dao.AccountDao;
import demo.model.Account;
import demo.service.AccountService;
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
    public AccountDao accountDao;

    @Override
    public List<Account> getAllAccounts() {
        return accountDao.findAll();
    }
}
