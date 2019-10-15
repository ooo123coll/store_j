package th.co.pchome.store_j.vo;

public class NationalFlagSearchVo {

	String searchAccountType;// 搜尋帳號方式,886/86/email
	String searchAccountTypeValue;// 搜尋帳號輸入值,分別為email與電話兩種型態
	String storeId; // 賣場id
	String sCreatDate; // 註冊開始日期
	String eCreatDate; // 註冊結束日期
	String memberCountry; // 賣家註冊國家
	String sellerCountryFlag; // 賣場註冊國旗（專營國家）
	String sUpdateDate; // 修改開始日期
	String eUpdateDate; // 修改結束日期
	String orderBy; // 排序

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getSearchAccountType() {
		return searchAccountType;
	}

	public void setSearchAccountType(String searchAccountType) {
		this.searchAccountType = searchAccountType;
	}

	public String getSearchAccountTypeValue() {
		return searchAccountTypeValue;
	}

	public void setSearchAccountTypeValue(String searchAccountTypeValue) {
		this.searchAccountTypeValue = searchAccountTypeValue;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getsCreatDate() {
		return sCreatDate;
	}

	public void setsCreatDate(String sCreatDate) {
		this.sCreatDate = sCreatDate;
	}

	public String geteCreatDate() {
		return eCreatDate;
	}

	public void seteCreatDate(String eCreatDate) {
		this.eCreatDate = eCreatDate;
	}

	public String getMemberCountry() {
		return memberCountry;
	}

	public void setMemberCountry(String memberCountry) {
		this.memberCountry = memberCountry;
	}

	public String getSellerCountryFlag() {
		return sellerCountryFlag;
	}

	public void setSellerCountryFlag(String sellerCountryFlag) {
		this.sellerCountryFlag = sellerCountryFlag;
	}

	public String getsUpdateDate() {
		return sUpdateDate;
	}

	public void setsUpdateDate(String sUpdateDate) {
		this.sUpdateDate = sUpdateDate;
	}

	public String geteUpdateDate() {
		return eUpdateDate;
	}

	public void seteUpdateDate(String eUpdateDate) {
		this.eUpdateDate = eUpdateDate;
	}

	@Override
	public String toString() {
		return "NationalFlagSearchVo [searchAccountType=" + searchAccountType + ", searchAccountTypeValue="
				+ searchAccountTypeValue + ", storeId=" + storeId + ", sCreatDate=" + sCreatDate + ", eCreatDate="
				+ eCreatDate + ", memberCountry=" + memberCountry + ", sellerCountryFlag=" + sellerCountryFlag
				+ ", sUpdateDate=" + sUpdateDate + ", eUpdateDate=" + eUpdateDate + "]";
	}

}
