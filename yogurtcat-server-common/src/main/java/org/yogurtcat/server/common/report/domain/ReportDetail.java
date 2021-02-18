package org.yogurtcat.server.common.report.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description 上传明细结果表
 * @Author Echo
 * @Date 2020/8/25 下午2:04
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "KP_report_jyResult")
public class ReportDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 注入对象
     * 联合主键
     */
    @OneToOne
    @JoinColumn(name = "sampleNO")
    private Report sampleNO;

    /**
     * 记录号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportID")
    private Integer reportId;


    /**
     * 医院代码
     */
    @Column(name = "hospitalCode", length = 10, nullable = false)
    private String hospitalCode;

    /**
     * 外送的样本单号
     */
    @Column(name = "ExternalBarCode", length = 32, nullable = false)
    private String externalBarCode;

    /**
     * 医院条形码
     */
    @Column(name = "InternalBarCode", length = 32, nullable = false)
    private String internalBarCode;

    /**
     * 项目代码
     * 报告项目编码（回传的通道号对照）联合主键
     */
    @Column(name = "testCode", length = 20, nullable = false)
    private String testCode;

    /**
     * 项目名称
     */
    @Column(name = "testName",length = 60)
    private String testName;

    /**
     * 项目英文名称
     */
    @Column(name = "ItemNameEN", length = 50)
    private String itemNameEn;

    /**
     * 结果
     */
    @Column(name = "TestResult", length = 256)
    private String testResult;

    /**
     * 提示符
     * 正常N 高H 低L 异常A 警告W
     */
    @Column(name = "ResultTip", length = 10)
    private String resultTip;

    /**
     * 参考范围
     */
    @Column(name = "ItemRed", length = 256)
    private String itemRef;

    /**
     * 项目单位
     */
    @Column(name = "ItemUnit", length = 10)
    private String  itemUnit;

    /**
     * 危急警告
     * 1 危急
     */
    @Column(name = "CriticalFlag", length = 1)
    private String criticalFlag;

    /**
     * 检测方法
     */
    @Column(name = "Testmethod", length = 20)
    private String testMethod;

    /**
     * 显示顺序
     */
    @Column(name = "ResultOrder", length = 5)
    private String resultOrder;

    /**
     * 危急值提示
     * 当是危急值时提示信息
     */
    @Column(name = "CriticalMessage", length = 2000)
    private String criticalMessage;

    /**
     * 专家建议
     */
    @Column(name = "expertAdvice", length = 8000)
    private String expertAdvice;

}