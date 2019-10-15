package th.co.pchome.store_j.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import th.co.pchome.store_j.entity.ThSellerCountryFlagLog;
import th.co.pchome.store_j.entity.ThSellerMain;
import th.co.pchome.store_j.service.THPorductMainService;
import th.co.pchome.store_j.service.THSellerCountryFlagService;
import th.co.pchome.store_j.service.THSellerMainService;
import th.co.pchome.store_j.util.HibernateProxyTypeAdapter;
import th.co.pchome.store_j.util.LogUtil;
import th.co.pchome.store_j.vo.NationalFlagSearchVo;

/**
 * 設定商店國旗
 * @author ian
 */
@Controller
@RequestMapping(value = "/nationalFlag")
public class NationalFlagController {

	@Autowired
	THSellerCountryFlagService tHSellerCountryFlagService;
	@Autowired
	THSellerMainService thSellerMainService;
	@Autowired
	THPorductMainService tHPorductMainService;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	/**
	 * 設定商店國旗首頁
	 */
	@RequestMapping(value = "/index")
	public String index(Model model) {
		try {
			// 前端dialog用
			NationalFlagSearchVo nationalFlagSearchVo = new NationalFlagSearchVo();
			List<ThSellerMain> list = thSellerMainService.findAll(nationalFlagSearchVo);
			model.addAttribute("list", list);
		} catch (Exception e) {
			LogUtil.log.error(e.getMessage(), e);
		}
		return "national_flag_index";
	}

	/**
	 * 查詢列表
	 */
	@ResponseBody
	@RequestMapping(value = "/search")
	public String search(HttpServletRequest request, HttpServletResponse response, String showMode) {

		int pageNum = new Integer(request.getParameter("page")) - 1;
		int pageSize = new Integer(request.getParameter("rows"));
		int total = 0;

		String searchAccountType = request.getParameter("searchAccountType");
		String searchAccountTypeValue = request.getParameter("searchAccountTypeValue");
		String storeId = request.getParameter("storeId");
		String sCreatDate = request.getParameter("sCreatDate");
		String eCreatDate = request.getParameter("eCreatDate");
		String memberCountry = request.getParameter("memberCountry");
		String sellerCountryFlag = request.getParameter("sellerCountryFlag");
		String sUpdateDate = request.getParameter("sUpdateDate");
		String eUpdateDate = request.getParameter("eUpdateDate");
		String orderBy = request.getParameter("orderBy");

		NationalFlagSearchVo nationalFlagSearchVo = new NationalFlagSearchVo();
		nationalFlagSearchVo.setSearchAccountType(searchAccountType);
		nationalFlagSearchVo.setSearchAccountTypeValue(searchAccountTypeValue);
		nationalFlagSearchVo.setStoreId(storeId);
		nationalFlagSearchVo.setsCreatDate(sCreatDate);
		nationalFlagSearchVo.seteCreatDate(eCreatDate);
		nationalFlagSearchVo.setMemberCountry(memberCountry);
		nationalFlagSearchVo.setSellerCountryFlag(sellerCountryFlag);
		nationalFlagSearchVo.setsUpdateDate(sUpdateDate);
		nationalFlagSearchVo.seteUpdateDate(eUpdateDate);
		nationalFlagSearchVo.setOrderBy(orderBy);

		List<ThSellerMain> list = null;
		try {
			list = thSellerMainService.findAll(nationalFlagSearchVo);
			if (list == null)
				list = new ArrayList<ThSellerMain>();

			for (ThSellerMain thSellerMain : list) {
				if (ObjectUtils.isEmpty(thSellerMain.getThSellerCountryFlagLog())) {
					thSellerMain.setThSellerCountryFlagLog(new ThSellerCountryFlagLog());
				}
				Integer count = tHPorductMainService.countBySmId(thSellerMain.getSmId().toString());
				thSellerMain.setSellerProductCount(count);
			}
		} catch (Exception e) {
			LogUtil.log.error(e.getMessage(), e);
		}

		total = list.size();
		int fromIndex = pageNum * pageSize > total ? 0 : pageNum * pageSize;
		int toIndex = (pageNum + 1) * pageSize > total ? total : (pageNum + 1) * pageSize;
		Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
		String s = "{\"rows\":" + gson.toJson(list.subList(fromIndex, toIndex)) + ", \"total\":" + total + "}";
		LogUtil.log.warn("search list :" + s);

		return "{\"rows\":" + gson.toJson(list.subList(fromIndex, toIndex)) + ", \"total\":" + total + "}";
	}

	/**
	 * 更新國旗
	 */
	@ResponseBody
	@RequestMapping(value = "/update")
	public String update(String countryFlag, String smId) {
		try {
			ThSellerMain thSellerMain = thSellerMainService.findBySmId(smId);
			thSellerMain.setCountryFlag(countryFlag);
			ThSellerMain dbThSellerMain = thSellerMainService.update(thSellerMain);
			if (!ObjectUtils.isEmpty(dbThSellerMain)) {
				ThSellerCountryFlagLog thSellerCountryFlagLog = tHSellerCountryFlagService.findBySmID(smId);
				 tHSellerCountryFlagService.saveOrUpdate(thSellerCountryFlagLog,smId);
			} 
		} catch (Exception e) {
			LogUtil.log.error("ThSellerMain Update Error SM_ID = :{}", smId);
			LogUtil.log.error(e.getMessage(), e);
			return "error";
		}
		return "success";
	}

	/**
	 * AJAX點擊編輯後 搜尋賣家
	 * @param smId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findBySmId", produces = "application/json;charset=UTF-8")
	public String findBySmId(String smId) {
		try {
			ThSellerMain seller = thSellerMainService.findBySmId(smId);
			GsonBuilder b = new GsonBuilder();
			b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
			Gson gson = b.create();
			String json = gson.toJson(seller);
			return json;
		} catch (Exception e) {
			LogUtil.log.error(e.getMessage(), e);
			return e.getMessage();
		}
	}

	/*
	 * 新增國旗(測試用可刪)
	 **/
	@RequestMapping(value = "/save")
	public String save() {
		ThSellerCountryFlagLog thSellerCountryFlagLog = new ThSellerCountryFlagLog();
		Timestamp time = new Timestamp(new Date().getTime());

		thSellerCountryFlagLog.setSmId(Long.valueOf("20919007287"));
		thSellerCountryFlagLog.setUpdateDate(time);
		thSellerCountryFlagLog.setUpdateUser("pchomeian");
		try {
			tHSellerCountryFlagService.saveOrUpdate(null, "20919007287");
		} catch (Exception e) {
			LogUtil.log.error(e.getMessage(), e);
		}
		return "national_flag_index";

	}

}
