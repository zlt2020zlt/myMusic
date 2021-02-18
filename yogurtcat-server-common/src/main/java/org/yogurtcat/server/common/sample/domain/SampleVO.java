package org.yogurtcat.server.common.sample.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 样本信息表
 * @Author Echo
 * @Date 2020/8/25 上午9:14
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SampleVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 外送的样本单号（主键）
     */
    private String externalBarCode;

    /**
     * 姓名
     */
    private String pName;

    /**
     * 性别
     * 1 男 2 女
     */
    private String pSex;

    /**
     * 出生日期
     */
    private Date dateOfBirth;

    /**
     * 标本类型
     */
    private String specimensType;

    /**
     * 试管数
     */
    private Integer tubes;

    /**
     * 标本状态
     * 已上传（检验科上传到中间库）
     * 已下载（第三方标本下载）
     */
    private String specimensStatus;

    /**
     * 送检日期
     */
    private Date sendDate;

    /**
     * 送检项目代码
     * 单个1001
     * 多个测试用逗号相隔如（1001，1002）
     */
    private String testDestCode;

    /**
     * 送检项目名称
     * 多个项目用逗号相隔
     */
    private String testDest;

    /**
     * 采样时间
     */
    private Date collectTime;

    /**
     * 接收时间
     */
    private Date recieveTime;

}