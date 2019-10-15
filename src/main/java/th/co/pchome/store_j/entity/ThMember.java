package th.co.pchome.store_j.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Transient;


@Entity
@Table(name="TH_MEMBER")
public class ThMember {
	@Id
	@Column(name="TM_MEMID", nullable=false)
	private Long tmMemId;
	@Column(name="TM_EMAIL")
	private String tmEmail;
	@Column(name="TM_ENCPWD")
	private String tmEncPwd;
	@Column(name="TM_MEMGENDER")
	private String tmMemGender;
	@Column(name="TM_NAME")
	private String tmName;
	@Column(name="TM_MOBILE")
	private String tmMobile;
	@Column(name="TM_STATUS")
	private String tmStatus;
	@Column(name="TM_CREATED")
	private Date tmCreated;
	@Column(name="TM_FBID")
	private String tmFbId;
	@Column(name="TM_BLOCK")
	private String tmBlock;
	@Column(name="TM_BLKDATE")
	private Date tmBlkDate;
	@Column(name="TM_PAYEEDATE")
	private Date tmPayEEDate;
	@Column(name="TM_LAST_LOGIN")
	private Date tmLastLogin;
	@Column(name="TM_NICKNAME")
	private String tmNickName;
	@Column(name="TM_PFLAG")
	private String tmPFlag;
	@Column(name="TM_CHKPOLICY_DATE")
	private Date tmChkPolicyDate;
	@Column(name="TM_FROM")
	private String tmFrom;
	@Column(name="TM_COUNTRY")
	private String tmCountry;
	@Column(name="TM_KYC_STATUS")
	private String tmKycStatus;
	@Column(name="TM_SMS_ALLOW")
	private Integer tmSmsAllow;
	@Column(name="TM_PHONE")
	private String tmPhone;
	@Column(name="TM_CONTACT_EMAIL")
	private String tmContractEmail;
	@Column(name="TM_NOTICE_LANGUAGE")
	private String tmNoticeLanguage;
	@Column(name="TM_REGISTER_TYPE")
	private String tmRegisterType;
	@Column(name="TM_EMAIL_STATUS")
	private String tmEmailStatus;
	@Column(name="TM_PHONE_CODE")
	private String tmPhoneCode;
	

	@Transient
	private String tmShowId;
	

	public Long getTmMemId() {
		return tmMemId;
	}
	public void setTmMemId(Long tmMemId) {
		this.tmMemId = tmMemId;
	}
	public String getTmEmail() {
		return tmEmail;
	}

	public void setTmEmail(String tmEmail) {
		this.tmEmail = tmEmail;
	}
	public String getTmShowId() {
		return tmShowId;
	}
	public void setTmShowId(String tmShowId) {
		this.tmShowId = tmShowId;
	}
	public String getTmEncPwd() {
		return tmEncPwd;
	}
	public void setTmEncPwd(String tmEncPwd) {
		this.tmEncPwd = tmEncPwd;
	}
	public String getTmMemGender() {
		return tmMemGender;
	}
	public void setTmMemGender(String tmMemGender) {
		this.tmMemGender = tmMemGender;
	}
	public String getTmName() {
		return tmName;
	}
	public void setTmName(String tmName) {
		this.tmName = tmName;
	}
	public String getTmMobile() {
		return tmMobile;
	}
	public void setTmMobile(String tmMobile) {
		this.tmMobile = tmMobile;
	}
	public String getTmStatus() {
		return tmStatus;
	}
	public void setTmStatus(String tmStatus) {
		this.tmStatus = tmStatus;
	}
	public Date getTmCreated() {
		return tmCreated;
	}
	public void setTmCreated(Date tmCreated) {
		this.tmCreated = tmCreated;
	}
	public String getTmFbId() {
		return tmFbId;
	}
	public void setTmFbId(String tmFbId) {
		this.tmFbId = tmFbId;
	}
	public String getTmBlock() {
		return tmBlock;
	}
	public void setTmBlock(String tmBlock) {
		this.tmBlock = tmBlock;
	}
	public Date getTmBlkDate() {
		return tmBlkDate;
	}
	public void setTmBlkDate(Date tmBlkDate) {
		this.tmBlkDate = tmBlkDate;
	}
	public Date getTmPayEEDate() {
		return tmPayEEDate;
	}
	public void setTmPayEEDate(Date tmPayEEDate) {
		this.tmPayEEDate = tmPayEEDate;
	}
	public Date getTmLastLogin() {
		return tmLastLogin;
	}
	public void setTmLastLogin(Date tmLastLogin) {
		this.tmLastLogin = tmLastLogin;
	}
	public String getTmNickName() {
		return tmNickName;
	}
	public void setTmNickName(String tmNickName) {
		this.tmNickName = tmNickName;
	}
	public String getTmPFlag() {
		return tmPFlag;
	}
	public void setTmPFlag(String tmPFlag) {
		this.tmPFlag = tmPFlag;
	}
	public Date getTmChkPolicyDate() {
		return tmChkPolicyDate;
	}
	public void setTmChkPolicyDate(Date tmChkPolicyDate) {
		this.tmChkPolicyDate = tmChkPolicyDate;
	}
	public String getTmFrom() {
		return tmFrom;
	}
	public void setTmFrom(String tmFrom) {
		this.tmFrom = tmFrom;
	}
	public String getTmCountry() {
		return tmCountry;
	}
	public void setTmCountry(String tmCountry) {
		this.tmCountry = tmCountry;
	}
	public String getTmKycStatus() {
		return tmKycStatus;
	}
	public void setTmKycStatus(String tmKycStatus) {
		this.tmKycStatus = tmKycStatus;
	}
	public Integer getTmSmsAllow() {
		return tmSmsAllow;
	}
	public void setTmSmsAllow(Integer tmSmsAllow) {
		this.tmSmsAllow = tmSmsAllow;
	}
	public String getTmPhone() {
		return tmPhone;
	}
	public void setTmPhone(String tmPhone) {
		this.tmPhone = tmPhone;
	}
	public String getTmContractEmail() {
		return tmContractEmail;
	}
	public void setTmContractEmail(String tmContractEmail) {
		this.tmContractEmail = tmContractEmail;
	}
	public String getTmNoticeLanguage() {
		return tmNoticeLanguage;
	}
	public void setTmNoticeLanguage(String tmNoticeLanguage) {
		this.tmNoticeLanguage = tmNoticeLanguage;
	}
	public String getTmRegisterType() {
		return tmRegisterType;
	}
	public void setTmRegisterType(String tmRegisterType) {
		this.tmRegisterType = tmRegisterType;
	}
	public String getTmEmailStatus() {
		return tmEmailStatus;
	}
	public void setTmEmailStatus(String tmEmailStatus) {
		this.tmEmailStatus = tmEmailStatus;
	}
	public String getTmPhoneCode() {
		return tmPhoneCode;
	}
	public void setTmPhoneCode(String tmPhoneCode) {
		this.tmPhoneCode = tmPhoneCode;
	}

}
