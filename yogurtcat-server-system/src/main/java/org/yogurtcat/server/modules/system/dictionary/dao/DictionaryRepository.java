package org.yogurtcat.server.modules.system.dictionary.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;
import org.yogurtcat.server.modules.system.dictionary.domain.Dictionary;

/**
 * 字典操作持久化操作
 * @author s
 *
 */
public interface DictionaryRepository extends Repository<Dictionary, Long>, JpaSpecificationExecutor<Dictionary> {
	
	/**
	 * 新增或修改
	 * @param dictionary
	 * @return
	 */
	Dictionary save(Dictionary dictionary);

	/**
	 * 删除
	 * @param dictionary
	 */
	void deleteByIdIn(Set<Long> ids);

	/**
	 * 根据name查找
	 * @param username
	 * @return
	 */
	Dictionary findByName(String name);
}
