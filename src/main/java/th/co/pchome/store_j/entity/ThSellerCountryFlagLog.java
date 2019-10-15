package th.co.pchome.store_j.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalIdCache;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@NaturalIdCache
@Table(name = "TH_SELLER_COUNTRYFLAG_LOG")
public class ThSellerCountryFlagLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SM_ID")
	private Long smId;
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name = "UPDATE_DATE")
	private Timestamp updateDate;
	@Column(name = "UPDATE_USER")
	private String updateUser;

	
	public Long getSmId() {
		return smId;
	}

	public void setSmId(Long smId) {
		this.smId = smId;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}
