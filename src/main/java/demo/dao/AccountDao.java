package demo.dao;

import demo.model.Account;

import java.util.List;

/**
 * @author Neo
 * @since 10/17/2020-7:36 PM
 */
public interface AccountDao {

  /** 查询所有用户 */
  List<Account> findAll();

  /**
   * 添加一个新用户
   *
   * @param account
   */
  void addOne(Account account);
}
