package th.co.pchome.store_j.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import th.co.pchome.store_j.enums.ShipFromType;

@Entity
@Table(name = "TH_SELLER_MAIN")
public class ThSellerMain implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "SM_ID")
	private Long smId;
	@Column(name = "TM_MEMID")
	private Long tmMemId;
	@Column(name = "SM_STORE_NAME")
	private String smStoreName;
	@Column(name = "SM_STORE_IMG")
	private String smStoreImg;
	@Column(name = "SM_SELLER_TYPE")
	private String smSellerType;
	@Column(name = "SM_FORUM_NA")
	private Integer smForumNa;
	@Column(name = "SM_SERVICE_NA")
	private Integer smServiceNa;
	@Column(name = "SM_INS_DATE")
	private Date smInsDate;
	@Column(name = "SM_UPD_DATE")
	private Date smUpdDate;
	@Column(name = "SM_BANK_ACC")
	private String smBankAcc;
	@Column(name = "SM_UID")
	private String smUid;
	@Column(name = "SM_FROM")
	private String smFrom;
	@Column(name = "SM_PAYTYPE")
	private String smPaytype;
	@Enumerated(EnumType.STRING)
	@Column(name = "ship_from_type")
	private ShipFromType shipFromType;
	@Column(name = "ship_country")
	private String shipCountry;
	@Column(name = "ship_post_code")
	private String shipPostCode;
	@Column(name = "ship_province")
	private String shipProvince;
	@Column(name = "ship_district")
	private String shipDistrict;
	@Column(name = "prepare_day")
	private Integer prepareDay;
	@Column(name = "SM_STORE_FLAG")
	private String smStoreFlag;
	@Column(name = "COUNTRY_FLAG")
	private String countryFlag;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TM_MEMID", insertable = false, updatable = false)
	private ThMember thMember;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SM_ID")
	private ThSellerCountryFlagLog thSellerCountryFlagLog;

	@Transient
	private Integer sellerProductCount;

	public Integer getSellerProductCount() {
		return sellerProductCount;
	}

	public void setSellerProductCount(Integer sellerProductCount) {
		this.sellerProductCount = sellerProductCount;
	}

	public ThSellerCountryFlagLog getThSellerCountryFlagLog() {
		return thSellerCountryFlagLog;
	}

	public void setThSellerCountryFlagLog(ThSellerCountryFlagLog thSellerCountryFlagLog) {
		this.thSellerCountryFlagLog = thSellerCountryFlagLog;
	}

	public ThMember getThMember() {
		return thMember;
	}

	public void setThMember(ThMember thMember) {
		this.thMember = thMember;
	}

	public void setSmId(Long smId) {
		this.smId = smId;
	}

	public Long getSmId() {
		return this.smId;
	}

	public void setTmMemId(Long tmMemId) {
		this.tmMemId = tmMemId;
	}

	public Long getTmMemId() {
		return this.tmMemId;
	}

	public void setSmStoreName(String smStoreName) {
		this.smStoreName = smStoreName;
	}

	public String getSmStoreName() {
		return this.smStoreName;
	}

	public void setSmStoreImg(String smStoreImg) {
		this.smStoreImg = smStoreImg;
	}

	public String getSmStoreImg() {
		return this.smStoreImg;
	}

	public void setSmSellerType(String smSellerType) {
		this.smSellerType = smSellerType;
	}

	public String getSmSellerType() {
		return this.smSellerType;
	}

	public void setSmForumNa(Integer smForumNa) {
		this.smForumNa = smForumNa;
	}

	public Integer getSmForumNa() {
		return this.smForumNa;
	}

	public void setSmServiceNa(Integer smServiceNa) {
		this.smServiceNa = smServiceNa;
	}

	public Integer getSmServiceNa() {
		return this.smServiceNa;
	}

	public void setSmInsDate(Date smInsDate) {
		this.smInsDate = smInsDate;
	}

	public Date getSmInsDate() {
		return this.smInsDate;
	}

	public void setSmUpdDate(Date smUpdDate) {
		this.smUpdDate = smUpdDate;
	}

	public Date getSmUpdDate() {
		return this.smUpdDate;
	}

	public void setSmBankAcc(String smBankAcc) {
		this.smBankAcc = smBankAcc;
	}

	public String getSmBankAcc() {
		return this.smBankAcc;
	}

	public void setSmUid(String smUid) {
		this.smUid = smUid;
	}

	public String getSmUid() {
		return this.smUid;
	}

	public void setSmFrom(String smFrom) {
		this.smFrom = smFrom;
	}

	public String getSmFrom() {
		return this.smFrom;
	}

	public void setSmPaytype(String smPaytype) {
		this.smPaytype = smPaytype;
	}

	public String getSmPaytype() {
		return this.smPaytype;
	}

	public ShipFromType getShipFromType() {
		return shipFromType;
	}

	public void setShipFromType(ShipFromType shipFromType) {
		this.shipFromType = shipFromType;
	}

	public String getShipCountry() {
		return shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

	public String getShipPostCode() {
		return shipPostCode;
	}

	public void setShipPostCode(String shipPostCode) {
		this.shipPostCode = shipPostCode;
	}

	public String getShipProvince() {
		return shipProvince;
	}

	public void setShipProvince(String shipProvince) {
		this.shipProvince = shipProvince;
	}

	public String getShipDistrict() {
		return shipDistrict;
	}

	public void setShipDistrict(String shipDistrict) {
		this.shipDistrict = shipDistrict;
	}

	public Integer getPrepareDay() {
		return prepareDay;
	}

	public void setPrepareDay(Integer prepareDay) {
		this.prepareDay = prepareDay;
	}

	public String getSmStoreFlag() {
		return smStoreFlag;
	}

	public void setSmStoreFlag(String smStoreFlag) {
		this.smStoreFlag = smStoreFlag;
	}

	public String getCountryFlag() {
		return countryFlag;
	}

	public void setCountryFlag(String countryFlag) {
		this.countryFlag = countryFlag;
	}

}
