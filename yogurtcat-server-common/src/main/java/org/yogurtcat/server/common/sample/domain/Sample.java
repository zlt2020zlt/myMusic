package org.yogurtcat.server.common.sample.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description 上传标本申请表（样本）
 * @Author Echo
 * @Date 2020/8/25 上午9:14
 **/
@SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "KP_barCode_info")
public class Sample implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 外送的样本单号（主键）
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ExternalBarCode", length = 32, nullable = false)
    private String externalBarCode;

    /**
     * 医院代码
     */
    @Column(name = "hospitalCode", length = 32, nullable = false)
    private String hospitalCode;

    /**
     * 医院条形码
     */
    @Column(name = "InternalBarCode", length = 32, nullable = false)
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
     * 性别
     * 1 男 2 女
     */
    @Column(name = "PSex", length = 1)
    private String pSex;

    /**
     * 出生日期
     */
    @Column(name = "dateOfbirth")
    private Date dateOfBirth;

    /**
     * 年龄
     */
    @Column(name = "PAge")
    private Integer pAge;

    /**
     * 年龄单位
     * 1 岁 2 月 3 天 4 时 5 分
     */
    @Column(name = "AgeUnit")
    private String ageUnit;

    /**
     * 身份证号
     */
    @Column(name = "IdentityCardNo", length = 20)
    private String identityCardNo;

    /**
     * 病人类型
     * 1 门诊 2 住院 3 体检
     */
    @Column(name = "PType")
    private Integer pType;

    /**
     * 就诊日期
     */
    @Column(name = "AdmDate")
    private Date admDate;

    /**
     * 门诊号、住院号、体检号等
     */
    @Column(name = "AdmNo", length = 25)
    private String admNo;

    /**
     * 床号
     */
    @Column(name = "BedNO", length = 8)
    private String bedNo;

    /**
     * 送检科室
     */
    @Column(name = "Department", length = 20)
    private String department;

    /**
     * 送检医生
     */
    @Column(name = "DoctorName", length = 20)
    private String doctorName;

    /**
     * 临床诊断
     */
    @Column(name = "Diagnose", length = 40)
    private String diagnose;

    /**
     * 标本类型
     */
    @Column(name = "SpecimensType", length = 16)
    private String specimensType;

    /**
     * 试管数
     */
    @Column(name = "Tubes")
    private Integer tubes;

    /**
     * 标本状态
     * 已上传（检验科上传到中间库）
     * 已下载（第三方标本下载）
     */
    @Column(name = "SpecimensStatus", length = 20)
    private String specimensStatus;

    /**
     * 送检日期
     */
    @Column(name = "SendDate")
    private Date sendDate;

    /**
     * 送检项目代码
     * 单个1001
     * 多个测试用逗号相隔如（1001，1002）
     */
    @Column(name = "TestDestCode", length = 256)
    private String testDestCode;

    /**
     * 送检项目名称
     * 多个项目用逗号相隔
     */
    @Column(name = "TestDest", length = 8000)
    private String testDest;

    /**
     * 采样时间
     */
    @Column(name = "CollectTime")
    private Date collectTime;

    /**
     * 接收时间
     */
    @Column(name = "RecieveTime")
    private Date recieveTime;

    /**
     * 备注
     */
    @Column(name = "Notes", length = 100)
    private String notes;

    /**
     * 特殊说明
     */
    @Column(name = "SpecialDes", length = 256)
    private String specialDes;

    /**
     * 个人编码
     */
    @Column(name = "GRBM", length = 50)
    private String personCode;

    /**
     * 外送单位名称
     */
    @Column(name = "WSDWMC", length = 50)
    private String logisticsName;
}