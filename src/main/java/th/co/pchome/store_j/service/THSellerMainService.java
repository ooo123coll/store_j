package th.co.pchome.store_j.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import th.co.pchome.store_j.entity.ThSellerMain;
import th.co.pchome.store_j.repository.ThSellerMainDao;
import th.co.pchome.store_j.util.LogUtil;
import th.co.pchome.store_j.vo.NationalFlagSearchVo;

@Service
public class THSellerMainService {

	@Autowired
	ThSellerMainDao thSellerMainDao;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	String firstDate = "1900-01-01 00:00";
	String lastDate = "2999-12-31 23:59";

	public ThSellerMain findBySmId(String smId) throws Exception {

		ThSellerMain thSellerMain = thSellerMainDao.getOne(Long.valueOf(smId));
		return thSellerMain;
	}

	public ThSellerMain update(ThSellerMain thSellerMain) throws Exception {
		ThSellerMain dBThSellerMain = thSellerMainDao.save(thSellerMain);
		return dBThSellerMain;
	}

	public List<ThSellerMain> findAll() throws Exception {
		return thSellerMainDao.findAll();

	}

	@SuppressWarnings("serial")
	public List<ThSellerMain> findAll(NationalFlagSearchVo nationalFlagSearchVo) throws Exception {
		Specification<ThSellerMain> specification = new Specification<ThSellerMain>() {

			@Override
			public Predicate toPredicate(Root<ThSellerMain> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 用于暂时存放查询条件的集合
				List<Predicate> predicatesList = new ArrayList<>();
				// 判斷用email或電話號碼 當作搜尋帳號的條件
				if ("email".equals(nationalFlagSearchVo.getSearchAccountType())) {
					if (!ObjectUtils.isEmpty(nationalFlagSearchVo.getSearchAccountTypeValue())) {
						Predicate tmEmail = cb.equal(root.get("thMember").get("tmEmail"),
								nationalFlagSearchVo.getSearchAccountTypeValue());
						predicatesList.add(tmEmail);
					}
				} else {
					if (!ObjectUtils.isEmpty(nationalFlagSearchVo.getSearchAccountTypeValue())) {
						Predicate tmPhoneCode = cb.equal(root.get("thMember").get("tmPhoneCode"),
								nationalFlagSearchVo.getSearchAccountType());
						Predicate tmPhone = cb.equal(root.get("thMember").get("tmPhone"),
								nationalFlagSearchVo.getSearchAccountTypeValue());
						predicatesList.add(tmPhoneCode);
						predicatesList.add(tmPhone);
					}
				}
				// 賣家SMID
				if (!ObjectUtils.isEmpty(nationalFlagSearchVo.getStoreId())) {
					Predicate smId = cb.equal(root.get("smId"), nationalFlagSearchVo.getStoreId());
					predicatesList.add(smId);
				}

				// 會員註冊日期
				if (!ObjectUtils.isEmpty(nationalFlagSearchVo.getsCreatDate())) {
					if (!ObjectUtils.isEmpty(nationalFlagSearchVo.geteCreatDate())) {
						try {
							Timestamp sTime = new Timestamp(
									sdf.parse(nationalFlagSearchVo.getsCreatDate() + " 00:00").getTime());
							Timestamp eTime = new Timestamp(
									sdf.parse(nationalFlagSearchVo.geteCreatDate() + " 23:59").getTime());
							Predicate createDate = cb.between(root.get("thMember").get("tmCreated"), sTime, eTime);
							predicatesList.add(createDate);
						} catch (ParseException e) {
							LogUtil.log.error(e.getMessage(), e);
						}
					} else {
						try {
							Timestamp sTime = new Timestamp(
									sdf.parse(nationalFlagSearchVo.getsCreatDate() + " 00:00").getTime());
							Timestamp defaultETime = new Timestamp(sdf.parse(lastDate).getTime());
							Predicate createDate = cb.between(root.get("thMember").get("tmCreated"), sTime,
									defaultETime);
							predicatesList.add(createDate);
						} catch (ParseException e) {
							LogUtil.log.error(e.getMessage(), e);
						}
					}
				}
				if (!ObjectUtils.isEmpty(nationalFlagSearchVo.geteCreatDate())) {
					if (!ObjectUtils.isEmpty(nationalFlagSearchVo.getsCreatDate())) {
						try {
							Timestamp sTime = new Timestamp(
									sdf.parse(nationalFlagSearchVo.getsCreatDate() + " 00:00").getTime());
							Timestamp eTime = new Timestamp(
									sdf.parse(nationalFlagSearchVo.geteCreatDate() + " 23:59").getTime());
							Predicate createDate = cb.between(root.get("thMember").get("tmCreated"), sTime, eTime);
							predicatesList.add(createDate);
						} catch (ParseException e) {
							LogUtil.log.error(e.getMessage(), e);
						}
					} else {
						try {
							Timestamp defaultSTime = new Timestamp(sdf.parse(firstDate).getTime());
							Timestamp eTime = new Timestamp(
									sdf.parse(nationalFlagSearchVo.geteCreatDate() + " 23:59").getTime());
							Predicate createDate = cb.between(root.get("thMember").get("tmCreated"), defaultSTime,
									eTime);
							predicatesList.add(createDate);
						} catch (ParseException e) {
							LogUtil.log.error(e.getMessage(), e);
						}
					}
				}

				// 賣家國別
				if (!ObjectUtils.isEmpty(nationalFlagSearchVo.getMemberCountry())) {
					if ("TH".equals(nationalFlagSearchVo.getMemberCountry())) {
						Predicate tmCountry = cb.isNull(root.get("thMember").get("tmCountry"));
						predicatesList.add(tmCountry);
					} else {
						Predicate tmCountry = cb.equal(root.get("thMember").get("tmCountry"),
								nationalFlagSearchVo.getMemberCountry());
						predicatesList.add(tmCountry);
					}
				}

				// 商店國旗（專營國別）
				if (!"all".equals(nationalFlagSearchVo.getSellerCountryFlag())) {
					Predicate tmCountry = cb.equal(root.get("countryFlag"),
							nationalFlagSearchVo.getSellerCountryFlag());
					predicatesList.add(tmCountry);
				}

				// 商店國旗（專營國別）修改日期
				if (!ObjectUtils.isEmpty(nationalFlagSearchVo.getsUpdateDate())) {
					if (!ObjectUtils.isEmpty(nationalFlagSearchVo.geteUpdateDate())) {
						try {
							Timestamp sTime = new Timestamp(
									sdf.parse(nationalFlagSearchVo.getsUpdateDate() + " 00:00").getTime());
							Timestamp eTime = new Timestamp(
									sdf.parse(nationalFlagSearchVo.geteUpdateDate() + " 23:59").getTime());
							Predicate updateDate = cb.between(root.get("thSellerCountryFlagLog").get("updateDate"),
									sTime, eTime);
							predicatesList.add(updateDate);
						} catch (ParseException e) {
							LogUtil.log.error(e.getMessage(), e);
						}
					} else {
						try {
							Timestamp sTime = new Timestamp(
									sdf.parse(nationalFlagSearchVo.getsUpdateDate() + " 00:00").getTime());
							Timestamp defaultETime = new Timestamp(sdf.parse(lastDate).getTime());
							Predicate updateDate = cb.between(root.get("thSellerCountryFlagLog").get("updateDate"),
									sTime, defaultETime);
							predicatesList.add(updateDate);
						} catch (ParseException e) {
							LogUtil.log.error(e.getMessage(), e);
						}
					}
				}
				if (!ObjectUtils.isEmpty(nationalFlagSearchVo.geteUpdateDate())) {
					if (!ObjectUtils.isEmpty(nationalFlagSearchVo.getsUpdateDate())) {
						try {
							Timestamp sTime = new Timestamp(
									sdf.parse(nationalFlagSearchVo.getsUpdateDate() + " 00:00").getTime());
							Timestamp eTime = new Timestamp(
									sdf.parse(nationalFlagSearchVo.geteUpdateDate() + " 23:59").getTime());
							Predicate updateDate = cb.between(root.get("thSellerCountryFlagLog").get("updateDate"),
									sTime, eTime);
							predicatesList.add(updateDate);
						} catch (ParseException e) {
							LogUtil.log.error(e.getMessage(), e);
						}

					} else {
						try {
							Timestamp defaultSTime = new Timestamp(sdf.parse(firstDate).getTime());
							Timestamp eTime = new Timestamp(
									sdf.parse(nationalFlagSearchVo.geteCreatDate() + " 23:59").getTime());
							Predicate updateDate = cb.between(root.get("thSellerCountryFlagLog").get("updateDate"),
									defaultSTime, eTime);
							predicatesList.add(updateDate);
						} catch (ParseException e) {
							LogUtil.log.error(e.getMessage(), e);
						}
					}
				}
				// 排序

//				if("DESC".equals(nationalFlagSearchVo.getOrderBy())) {					
//					query.orderBy(cb.asc(root.get("thSellerCountryFlagLog").get("updateDate")),cb.asc(root.get("thMember").get("tmCreated")));	
//				}else {
//					query.orderBy(cb.desc(root.get("thSellerCountryFlagLog").get("updateDate")),cb.desc(root.get("thMember").get("tmCreated")));
//				}

				// 最终将查询条件拼好然后return
				Predicate[] predicates = new Predicate[predicatesList.size()];
				return cb.and(predicatesList.toArray(predicates));
			}
		};

		return thSellerMainDao.findAll(specification);
	}

}
