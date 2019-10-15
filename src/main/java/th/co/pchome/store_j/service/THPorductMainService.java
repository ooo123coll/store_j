package th.co.pchome.store_j.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.pchome.store_j.repository.ThProductMainDao;

@Service
public class THPorductMainService {

	@Autowired 
	ThProductMainDao thProductMainDao;
	
	public Integer countBySmId(String smid) throws Exception{
		Integer count = thProductMainDao.countBySmId(smid);
		return count;
	}
}
