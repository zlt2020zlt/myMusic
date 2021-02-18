package org.yogurtcat.server.common.report.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 报告信息
 * @Author Echo
 * @Date 2020/8/25 下午3:46
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportVO implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 样本单位（主键）
     */
    private String sampleNo;

    /**
     * 外送的样本单号
     */
    private String externalBarCode;

    /**
     * 医院条形码
     */
    private String internalBarCode;

    /**
     * 姓名
     */
    private String pName;

    /**
     * 出生日期
     */
    private Date dateOfBirth;

    /**
     * 性别
     * 1 男 2 女
     */
    private String pSex;

    /**
     * 标本类型
     */
    private String specimensType;

    /**
     * 试管数
     */
    private Double tubes;

    /**
     * 标本状态
     * 已上传（检验科上传到中间库）
     * 已下载（第三方标本下载）
     */
    private String specimensStatus;

    /**
     * 采样时间
     * YYYY-mm-dd HH:MM:SS
     */
    private Date collectTime;

    /**
     * 检验日期
     * YYYY-mm-dd HH:MM:SS
     */
    private Date registerTime;

    /**
     * 检验医生名字
     */
    private String registerName;

    /**
     * 报告时间
     * YYYY-mm-dd HH:MM:SS
     */
    private Date reportTime;

    /**
     * 报告医生名字
     */
    private String reportName;

    /**
     * 接收标志
     * null/0 新写回本地未接受
     * 1 本地已接收
     * 2 结果有更改 本地未接受
     */
    private Integer saveFlag;

    /**
     * PDF文件BASE64
     */
    private String pdfData;

    /**
     * 结果
     */
    private String testResult;

    /**
     * 提示符
     * 正常N 高H 低L 异常A 警告W
     */
    private String resultTip;

    /**
     * 参考范围
     */
    private String itemRef;

    /**
     * 危急警告
     * 1 危急
     */
    private String criticalFlag;

    /**
     * 检测方法
     */
    private String testMethod;

    /**
     * 显示顺序
     */
    private String resultOrder;

    /**
     * 危急值提示
     * 当是危急值时提示信息
     */
    private String criticalMessage;

    /**
     * 专家建议
     */
    private String expertAdvice;

}