package org.yogurtcat.server.modules.system.user.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.yogurtcat.server.modules.system.user.domain.UserVo;

/**
 * 用户业务接口
 * @author heaven
 *
 */
public interface UserService {
	
	/**
	 * 根据账号密码查询用户
	 * @param username
	 * @param password
	 * @return
	 */
	UserVo findUser(String username, String password);

	/**
	 * 使用token获取用户信息
	 * @param username
	 * @return
	 */
	UserVo findUserByUsername(String username);
	
	/**
	 * 分页条件查询
	 * @param condition
	 * @param pageable
	 * @return
	 */
	Page<UserVo> list(Optional<UserVo> condition, Pageable pageable);

	/**
	 * 新增或修改
	 * @param data
	 * @return
	 */
	UserVo save(UserVo data);

	/**
	 * 删除
	 * @param data
	 */
	void delete(UserVo data);
	
}
