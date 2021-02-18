package org.yogurtcat.server.modules.system.dictionary.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.sql.Update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "sys_dict_detail")
@ApiModel("字典详情")
public class DictionaryDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "detail_id")
	@NotNull(groups = Update.class)
	@ApiModelProperty(value = "ID", hidden = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "dict_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@ApiModelProperty(value = "字典", hidden = true)
	private Dictionary dict;

	@ApiModelProperty(value = "字典标签")
	private String label;

	@ApiModelProperty(value = "字典值")
	private String value;

	@ApiModelProperty(value = "排序")
	private Integer dictSort = 999;

    @ApiModelProperty(value = "创建日期")
    @CreationTimestamp
    private Date createTime;		
}
