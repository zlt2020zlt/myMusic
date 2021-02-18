package org.yogurtcat.server.modules.system.dictionary.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.yogurtcat.server.modules.system.dictionary.domain.Dictionary;

/**
 * 字典业务接口
 * @author heaven
 *
 */
public interface DictionaryService {
	
	/**
	 * 分页条件查询
	 * @param condition
	 * @param pageable
	 * @return
	 */
	Page<Dictionary> list(Optional<Dictionary> condition, Pageable pageable);
	
	/**
	 * 字典查询
	 * @param name
	 * @return
	 */
	Dictionary get(String name);

	/**
	 * 新增或修改
	 * @param data
	 * @return
	 */
	Dictionary save(Dictionary data);

	/**
	 * 删除
	 * @param data
	 */
	void delete(Set<Long> ids);
	
}
