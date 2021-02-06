package com.example.settingweb_boot.service;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.settingweb_boot.dao.StatisticMapper;

@Service
public class StatisticServiceImpl implements StatisticService {

	@Autowired
	private StatisticMapper uMapper;

	@Override
	public HashMap<String, Object> yearloginNum(String year) {
		// JSON을 만들기 위해 HashMap 형태로 return함
		HashMap<String, Object> retVal = new HashMap<String, Object>();

		try { // 쿼리로 가져온 cnt 값으로 json 값을 만듦
			retVal = uMapper.selectYearLogin(year);
			retVal.put("year", year);
			retVal.put("is_success", true);

		} catch (Exception e) {
			retVal.put("totCnt", -999);
			retVal.put("year", year);
			retVal.put("is_success", false);
		}

		return retVal;
	}

}