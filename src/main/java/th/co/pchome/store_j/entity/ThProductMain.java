package th.co.pchome.store_j.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TH_PRODUCT_MAIN")
public class ThProductMain {
	@Id
	@Column(name="TP_PROD_ID")
	private Long tpProdId;
	@Column(name="SM_ID")
	private Long smId;
	@Column(name="TP_PRD_FLAG")
	private String tpPrdFlag;
	@Column(name="TP_PRD_NAME")
	private String tpPrdName;
	@Column(name="TP_PRD_NAME_ZH")
	private String tpPrdNameZh;
	@Column(name="TP_PRD_NAME_EN")
	private String tpPrdNameEn;
	@Column(name="TP_PRD_PRICE")
	private Float tpPrdPrice;
	@Column(name="TP_PRD_PRICE_SG")
	private Float tpPrdPriceSg;
	@Column(name="TP_PRD_UP_DATE")
	private Date tpPrdUpDate;
	@Column(name="TP_PRD_END_DATE")
	private Date tpPrdEndDate;
	@Column(name="TP_PRD_PAYWAY")
	private Integer tpPrdPayWay;
	@Column(name="TP_PRD_MAXBUY")
	private Integer tpPrdMaxBuy;
	@Column(name="TP_PRD_IMG_B")
	private String tpPrdImgB;
	@Column(name="TP_PRD_IMG_S")
	private String tpPrdImgS;
	@Column(name="TP_PRD_ISNEW")
	private String tpPrdIsNew;
	@Column(name="TP_PRD_INTRO")
	private String tpPrdIntro;
	@Column(name="TP_PRD_FROM")
	private String tpPrdFrom;
	@Column(name="TP_MV_PRD_ID")
	private String tpMvPrdId;
	@Column(name="TP_INS_DATE")
	private Date tpInsDate;
	@Column(name="TP_INS_USER_ID")
	private String tpInsUserId;
	@Column(name="TP_UPD_DATE")
	private Date tpUpdDate;
	@Column(name="TP_UPD_USER_ID")
	private String tpUpdUserId;
	@Column(name="TP_EXH")
	private String tpEXH;
	@Column(name="TP_SPECNAME")
	private String tpSpecName;
	@Column(name="TP_EXH_LIST")
	private String tpExhList;
	@Column(name="TP_PRD_IMG_O")
	private String tpPrdImgO;
	@Column(name="TP_BATCHID")
	private String tpBatchId;
	@Column(name="TP_UID")
	private String tpUid;
	@Column(name="TP_PRD_PREM")
	private String tpPrdPrem;
	@Column(name="TP_PRD_SIZE")
	private String tpPrdSize;
	@Column(name="TP_STOCK_DAY")
	private Integer tpStockDay;
	@Column(name="TP_SHIPPING_PRICE")
	private Float tpShippingPrice;
	@Column(name="TP_WARRANTY_TIME")
	private Integer tpWarrantyTime;
	@Column(name="TP_WARRANTY_UNIT")
	private String tpWarrantyUnit;
	@Column(name="TP_PRD_PRICE_OVERSEA")
	private Float tpPrdPriceOversea;
	@Column(name="TP_PRD_PRICE_SG_OVERSEA")
	private Float tpPrdPriceSgOversea;
	@Column(name="TP_PRD_OVERSEA_CURRENCY")
	private String tpPrdOverseaCurrency;

	@Transient
	private String imgPath;
	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Long getTpProdId() {
		return tpProdId;
	}

	public void setTpProdId(Long tpProdId) {
		this.tpProdId = tpProdId;
	}

	public Long getSmId() {
		return smId;
	}

	public void setSmId(Long smId) {
		this.smId = smId;
	}

	public String getTpPrdFlag() {
		return tpPrdFlag;
	}

	public void setTpPrdFlag(String tpPrdFlag) {
		this.tpPrdFlag = tpPrdFlag;
	}

	public String getTpPrdName() {
		return tpPrdName;
	}

	public void setTpPrdName(String tpPrdName) {
		this.tpPrdName = tpPrdName;
	}

	public String getTpPrdNameZh() {
		return tpPrdNameZh;
	}

	public void setTpPrdNameZh(String tpPrdNameZh) {
		this.tpPrdNameZh = tpPrdNameZh;
	}

	public String getTpPrdNameEn() {
		return tpPrdNameEn;
	}

	public void setTpPrdNameEn(String tpPrdNameEn) {
		this.tpPrdNameEn = tpPrdNameEn;
	}

	public Float getTpPrdPrice() {
		return tpPrdPrice;
	}

	public void setTpPrdPrice(Float tpPrdPrice) {
		this.tpPrdPrice = tpPrdPrice;
	}

	public Float getTpPrdPriceSg() {
		return tpPrdPriceSg;
	}

	public void setTpPrdPriceSg(Float tpPrdPriceSg) {
		this.tpPrdPriceSg = tpPrdPriceSg;
	}

	public Date getTpPrdUpDate() {
		return tpPrdUpDate;
	}

	public void setTpPrdUpDate(Date tpPrdUpDate) {
		this.tpPrdUpDate = tpPrdUpDate;
	}

	public Date getTpPrdEndDate() {
		return tpPrdEndDate;
	}

	public void setTpPrdEndDate(Date tpPrdEndDate) {
		this.tpPrdEndDate = tpPrdEndDate;
	}

	public Integer getTpPrdPayWay() {
		return tpPrdPayWay;
	}

	public void setTpPrdPayWay(Integer tpPrdPayWay) {
		this.tpPrdPayWay = tpPrdPayWay;
	}

	public Integer getTpPrdMaxBuy() {
		return tpPrdMaxBuy;
	}

	public void setTpPrdMaxBuy(Integer tpPrdMaxBuy) {
		this.tpPrdMaxBuy = tpPrdMaxBuy;
	}

	public String getTpPrdImgB() {
		return tpPrdImgB;
	}

	public void setTpPrdImgB(String tpPrdImgB) {
		this.tpPrdImgB = tpPrdImgB;
	}

	public String getTpPrdImgS() {
		return tpPrdImgS;
	}

	public void setTpPrdImgS(String tpPrdImgS) {
		this.tpPrdImgS = tpPrdImgS;
	}

	public String getTpPrdIsNew() {
		return tpPrdIsNew;
	}

	public void setTpPrdIsNew(String tpPrdIsNew) {
		this.tpPrdIsNew = tpPrdIsNew;
	}

	public String getTpPrdIntro() {
		return tpPrdIntro;
	}

	public void setTpPrdIntro(String tpPrdIntro) {
		this.tpPrdIntro = tpPrdIntro;
	}

	public String getTpPrdFrom() {
		return tpPrdFrom;
	}

	public void setTpPrdFrom(String tpPrdFrom) {
		this.tpPrdFrom = tpPrdFrom;
	}

	public String getTpMvPrdId() {
		return tpMvPrdId;
	}

	public void setTpMvPrdId(String tpMvPrdId) {
		this.tpMvPrdId = tpMvPrdId;
	}

	public Date getTpInsDate() {
		return tpInsDate;
	}

	public void setTpInsDate(Date tpInsDate) {
		this.tpInsDate = tpInsDate;
	}

	public String getTpInsUserId() {
		return tpInsUserId;
	}

	public void setTpInsUserId(String tpInsUserId) {
		this.tpInsUserId = tpInsUserId;
	}

	public Date getTpUpdDate() {
		return tpUpdDate;
	}

	public void setTpUpdDate(Date tpUpdDate) {
		this.tpUpdDate = tpUpdDate;
	}

	public String getTpUpdUserId() {
		return tpUpdUserId;
	}

	public void setTpUpdUserId(String tpUpdUserId) {
		this.tpUpdUserId = tpUpdUserId;
	}

	public String getTpEXH() {
		return tpEXH;
	}

	public void setTpEXH(String tpEXH) {
		this.tpEXH = tpEXH;
	}

	public String getTpSpecName() {
		return tpSpecName;
	}

	public void setTpSpecName(String tpSpecName) {
		this.tpSpecName = tpSpecName;
	}

	public String getTpPrdImgO() {
		return tpPrdImgO;
	}

	public void setTpPrdImgO(String tpPrdImgO) {
		this.tpPrdImgO = tpPrdImgO;
	}

	public String getTpBatchId() {
		return tpBatchId;
	}

	public void setTpBatchId(String tpBatchId) {
		this.tpBatchId = tpBatchId;
	}

	public String getTpUid() {
		return tpUid;
	}

	public void setTpUid(String tpUid) {
		this.tpUid = tpUid;
	}

	public String getTpPrdPrem() {
		return tpPrdPrem;
	}

	public void setTpPrdPrem(String tpPrdPrem) {
		this.tpPrdPrem = tpPrdPrem;
	}

	public String getTpPrdSize() {
		return tpPrdSize;
	}

	public void setTpPrdSize(String tpPrdSize) {
		this.tpPrdSize = tpPrdSize;
	}

	public Integer getTpStockDay() {
		return tpStockDay;
	}

	public void setTpStockDay(Integer tpStockDay) {
		this.tpStockDay = tpStockDay;
	}

	public Float getTpShippingPrice() {
		return tpShippingPrice;
	}

	public void setTpShippingPrice(Float tpShippingPrice) {
		this.tpShippingPrice = tpShippingPrice;
	}

	public String getTpExhList() {
		return tpExhList;
	}

	public void setTpExhList(String tpExhList) {
		this.tpExhList = tpExhList;
	}

	public Integer getTpWarrantyTime() {
		return tpWarrantyTime;
	}

	public void setTpWarrantyTime(Integer tpWarrantyTime) {
		this.tpWarrantyTime = tpWarrantyTime;
	}

	public String getTpWarrantyUnit() {
		return tpWarrantyUnit;
	}

	public void setTpWarrantyUnit(String tpWarrantyUnit) {
		this.tpWarrantyUnit = tpWarrantyUnit;
	}

	public Float getTpPrdPriceOversea() {
		return tpPrdPriceOversea;
	}

	public void setTpPrdPriceOversea(Float tpPrdPriceOversea) {
		this.tpPrdPriceOversea = tpPrdPriceOversea;
	}

	public Float getTpPrdPriceSgOversea() {
		return tpPrdPriceSgOversea;
	}

	public void setTpPrdPriceSgOversea(Float tpPrdPriceSgOversea) {
		this.tpPrdPriceSgOversea = tpPrdPriceSgOversea;
	}

	public String getTpPrdOverseaCurrency() {
		return tpPrdOverseaCurrency;
	}

	public void setTpPrdOverseaCurrency(String tpPrdOverseaCurrency) {
		this.tpPrdOverseaCurrency = tpPrdOverseaCurrency;
	}



}