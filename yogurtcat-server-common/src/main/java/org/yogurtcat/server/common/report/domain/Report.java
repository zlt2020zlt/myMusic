package org.yogurtcat.server.common.report.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description 上传报告信息表
 * @Author Echo
 * @Date 2020/8/25 上午11:31
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "KP_report_info")
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 样本单位（主键）
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sampleNO", length = 30, nullable = false)
    private String sampleNo;

    /**
     * 医院代码
     */
    @Column(name = "hospitalCode", length = 10)
    private String hospitalCode;

    /**
     * 外送的样本单号
     */
    @Column(name = "ExternalBarCode", length = 32)
    private String externalBarCode;

    /**
     * 医院条形码
     */
    @Column(name = "InternalBarCode", length = 32)
    private String internalBarCode;

    /**
     * 病人ID号
     */
    @Column(name = "PatientID", length = 30)
    private String patientId;

    /**
     * 姓名
     */
    @Column(name = "PName", length = 20)
    private String pName;

    /**
     * 英文名
     */
    @Column(name = "PNameENG", length = 20)
    private String pNameEng;

    /**
     * 出生日期
     */
    @Column(name = "dateOfbirth")
    private Date dateOfBirth;

    /**
     * 性别
     * 1 男 2 女
     */
    @Column(name = "PSex", length = 1)
    private String pSex;


    /**
     * 年龄
     */
    @Column(name = "PAge", length = 5)
    private Integer pAge;

    /**
     * 年龄单位
     * 1 岁 2 月 3 天 4 时 5 分
     */
    @Column(name = "AgeUnit", length = 1)
    private String ageUnit;

    /**
     * 身份证号
     */
    @Column(name = "identityCardNo", length = 20)
    private String identityCardNo;

    /**
     * 病人类型
     * 1 门诊 2 住院 3 体检
     */
    @Column(name = "pType")
    private Double pType;

    /**
     * 门诊号、住院号、体检号等
     */
    @Column(name = "AdmNo", length = 25)
    private String admNo;

    /**
     * 就诊日期
     */
    @Column(name = "AdmDate")
    private Date admDate;

    /**
     * 床号
     */
    @Column(name = "BedNO", length = 8)
    private String bedNo;

    /**
     * 送检科室
     */
    @Column(name = "Department", length = 50)
    private String department;

    /**
     * 送检医生
     */
    @Column(name = "DoctorName", length = 20)
    private String doctorName;

    /**
     * 标本类型
     */
    @Column(name = "SpecimensType", length = 16)
    private String specimensType;

    /**
     * 临床诊断
     */
    @Column(name = "Diagnose", length = 40)
    private String diagnose;

    /**
     * 试管数
     */
    @Column(name = "Tubes")
    private Double tubes;

    /**
     * 标本状态
     * 已上传（检验科上传到中间库）
     * 已下载（第三方标本下载）
     */
    @Column(name = "SpecimensStatus", length = 20)
    private String specimensStatus;

    /**
     * 送检日期
     * YYYY-mm-dd HH:MM:SS
     */
    @Column(name = "SendDate")
    private Date sendDate;

    /**
     * 采样时间
     * YYYY-mm-dd HH:MM:SS
     */
    @Column(name = "CollectTime")
    private Date collectTime;

    /**
     * 接收时间
     * YYYY-mm-dd HH:MM:SS
     */
    @Column(name = "RecieveTime")
    private Date recieveTime;

    /**
     * 检验日期
     * YYYY-mm-dd HH:MM:SS
     */
    @Column(name = "registerTime")
    private Date registerTime;

    /**
     * 检验医生名字
     */
    @Column(name = "registerName", length = 50)
    private String registerName;

    /**
     * 报告时间
     * YYYY-mm-dd HH:MM:SS
     */
    @Column(name = "ReportTime")
    private Date reportTime;

    /**
     * 报告医生名字
     */
    @Column(name = "reportName", length = 50)
    private String reportName;

    /**
     * 微生物报告标志
     * 1-该结果为微生物报告
     */
    @Column(name = "MicroFlag", length = 1)
    private String microFlag;

    /**
     * 备注
     */
    @Column(name = "Notes", length = 100)
    private String notes;

    /**
     * PDF文件BASE64
     */
    @Column(name = "PDFData", length = 100)
    private String pdfData;

    /**
     * 接收标志
     * null/0 新写回本地未接受
     * 1 本地已接收
     * 2 结果有更改 本地未接受
     */
    @Column(name = "SaveFlag")
    private Integer saveFlag;
}