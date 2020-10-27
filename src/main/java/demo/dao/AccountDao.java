package demo.dao;

import demo.model.Account;

import java.util.List;

/**
 * @author Neo
 * @since 10/17/2020-7:36 PM
 */
public interface AccountDao {

  /**
   * 通过Id查询用户
   */
  Account findById(Long id);

  /**
   * 通过Email查询用户
   */
  Account findByEmail(String email);

  /**
   * 添加一个新用户
   */
  void addOne(Account account);
}
