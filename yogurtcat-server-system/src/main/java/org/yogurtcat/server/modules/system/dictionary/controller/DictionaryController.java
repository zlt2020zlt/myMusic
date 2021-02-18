package org.yogurtcat.server.modules.system.dictionary.controller;

import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yogurtcat.server.common.constant.Module;
import org.yogurtcat.server.commons.constant.ResultCode;
import org.yogurtcat.server.commons.exception.BusinessException;
import org.yogurtcat.server.commons.response.ResponseResult;
import org.yogurtcat.server.modules.monitor.operationlog.annotation.OperationLog;
import org.yogurtcat.server.modules.system.dictionary.domain.Dictionary;
import org.yogurtcat.server.modules.system.dictionary.service.DictionaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "字典管理")
@RestController
@RequestMapping("dictionary")
public class DictionaryController {

	@Autowired
	private DictionaryService dictionaryService;

	/**
	 * 查询字典列表
	 * 
	 * @param condition
	 * @return
	 * @throws BusinessException
	 */
	@ApiOperation("查询字典列表")
	@GetMapping(path = "list")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseResult list(Dictionary condition, @RequestParam(defaultValue = "20") Integer limit,
			@RequestParam(defaultValue = "1") Integer page) throws BusinessException {
		Page<Dictionary> list = dictionaryService.list(Optional.ofNullable(condition), PageRequest.of(page - 1, limit));
		if (Optional.ofNullable(list).isPresent()) {
			return ResponseResult.builder().data(list).build();
		} else {
			throw BusinessException.builder().code(ResultCode.SYSTEM_ERROR.getCode())
					.message(ResultCode.SYSTEM_ERROR.getMessage()).build();
		}
	}

	/**
	 * 创建字典
	 * 
	 * @param data
	 * @return
	 * @throws BusinessException
	 */
	@ApiOperation("创建字典")
	@OperationLog(logCode = "saveDictionary", module = Module.新增字典)
	@PostMapping(path = "create", consumes = "application/json")
	public ResponseResult create(@Valid @RequestBody Dictionary data) throws BusinessException {
		Dictionary oldDictionary = dictionaryService.get(data.getName());
		if (oldDictionary != null) {
			throw BusinessException.builder().code(ResultCode.NAME_EXITS_ERROR.getCode())
					.message(ResultCode.NAME_EXITS_ERROR.getMessage()).build();
		}
		Dictionary project = dictionaryService.save(data);
		return ResponseResult.builder().data(project).build();
	}

	/**
	 * 修改字典
	 * 
	 * @param data
	 * @return
	 * @throws BusinessException
	 */
	@ApiOperation("修改字典")
	@OperationLog(logCode = "Dictionary", module = Module.修改字典)
	@PutMapping(path = "update", consumes = "application/json")
	public ResponseResult update(@RequestBody Dictionary data) throws BusinessException {
		Dictionary oldDictionary = dictionaryService.get(data.getName());
		if (oldDictionary != null && !oldDictionary.getId().equals(data.getId())) {
			throw BusinessException.builder().code(ResultCode.NAME_EXITS_ERROR.getCode())
					.message(ResultCode.NAME_EXITS_ERROR.getMessage()).build();
		}
		Dictionary project = dictionaryService.save(data);
		return ResponseResult.builder().data(project).build();
	}

	/**
	 * 删除字典
	 * 
	 * @param data
	 * @return
	 * @throws BusinessException
	 */
	@ApiOperation("删除字典")
	@OperationLog(logCode = "Dictionary", module = Module.删除字典)
	@DeleteMapping(path = "delete", consumes = "application/json")
	public ResponseResult delete(@RequestBody Set<Long> ids) throws BusinessException {
		dictionaryService.delete(ids);
		return ResponseResult.builder().build();
	}

}
