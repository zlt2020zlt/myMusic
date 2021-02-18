package org.yogurtcat.server.modules.system.dictionary.service;

import java.util.Optional;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yogurtcat.server.modules.system.dictionary.dao.DictionaryRepository;
import org.yogurtcat.server.modules.system.dictionary.dao.DictionarySpec;
import org.yogurtcat.server.modules.system.dictionary.domain.Dictionary;

/**
 * 用户业务类
 * 
 * @author heaven
 *
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryRepository dictionaryRepository;

	@Override
	public Page<Dictionary> list(Optional<Dictionary> condition, Pageable pageable) {
		Page<Dictionary> dictionarys = dictionaryRepository
				.findAll(DictionarySpec.builder().condition(condition).build(), pageable);
		return new PageImpl<Dictionary>(dictionarys.getContent(), dictionarys.getPageable(),
				dictionarys.getTotalElements());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Dictionary save(Dictionary data) {
		return dictionaryRepository.save(data);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Set<Long> ids) {
		dictionaryRepository.deleteByIdIn(ids);
	}

	@Override
	public Dictionary get(String name) {
		return dictionaryRepository.findByName(name);
	}
}
