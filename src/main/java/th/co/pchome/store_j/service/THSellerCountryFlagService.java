package th.co.pchome.store_j.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import th.co.pchome.store_j.entity.ThSellerCountryFlagLog;
import th.co.pchome.store_j.repository.ThSellerCountryFlagDao;
import th.co.pchome.store_j.util.LogUtil;

@Service
public class THSellerCountryFlagService {

	@Autowired
	ThSellerCountryFlagDao thSellerCountryFlagDao;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	String firstDate = "1900-01-01 00:00";
	String lastDate = "2999-12-31 23:59";

	public List<ThSellerCountryFlagLog> findAll() throws Exception {
		return thSellerCountryFlagDao.findAll();

	}

	

	public ThSellerCountryFlagLog findBySmID(String smId) throws Exception {
		ThSellerCountryFlagLog dBThSellerCountryFlagLog = null;
		try {
			dBThSellerCountryFlagLog = thSellerCountryFlagDao.findBySmId(smId);
		} catch (Exception e) {
			LogUtil.log.error(e.getMessage(), e);
		}
		if (dBThSellerCountryFlagLog != null) {
			System.err.println("if");

			return dBThSellerCountryFlagLog;
		} else {
			System.err.println("else");
			return null;
		}
	}


	public void saveOrUpdate(ThSellerCountryFlagLog t, String smId) throws Exception {
		Timestamp time = new Timestamp(new Date().getTime());
		
		if (ObjectUtils.isEmpty(t)) {
			t = new ThSellerCountryFlagLog();
			t.setSmId(Long.valueOf(smId));
		}
		
		t.setUpdateDate(time);
		t.setUpdateUser("pchomeian");
		thSellerCountryFlagDao.save(t);
	}
}
