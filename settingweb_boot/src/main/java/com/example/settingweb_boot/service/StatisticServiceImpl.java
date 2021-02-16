package com.example.settingweb_boot.service;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.settingweb_boot.dao.StatisticMapper;

@Service
public class StatisticServiceImpl implements StatisticService {

	@Autowired
	private StatisticMapper uMapper;

	// 해당년도의 로그인 수
	@Override
	public LinkedHashMap<String, Object> yearloginNum(String year) {
		// JSON을 만들기 위해 HashMap 형태로 return함
		LinkedHashMap<String, Object> retVal = new LinkedHashMap<String, Object>();

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

	// 월별 접속자 수
	@Override
	public LinkedHashMap<String, Object> selectMonth(String yearMonth) {
		String year = yearMonth.substring(0, 2);
		String month = yearMonth.substring(2);

		// JSON을 만들기 위해 HashMap 형태로 return함
		LinkedHashMap<String, Object> retVal = new LinkedHashMap<String, Object>();

		try { // 쿼리로 가져온 cnt 값으로 json 값을 만듦
			retVal = uMapper.selectMonth(yearMonth);
			retVal.put("year", year);
			retVal.put("month", month);
			retVal.put("is_success", true);

		} catch (Exception e) {
			retVal.put("totCnt", -999);
			retVal.put("year", year);
			retVal.put("month", month);
			retVal.put("is_success", false);
		}

		return retVal;
	}

	// 일별 접속자 수
	@Override
	public LinkedHashMap<String, Object> selectDate(String yearMonthDate) {
		String year = yearMonthDate.substring(0, 2);
		String month = yearMonthDate.substring(2, 4);
		String date = yearMonthDate.substring(4);

		// JSON을 만들기 위해 HashMap 형태로 return함
		LinkedHashMap<String, Object> retVal = new LinkedHashMap<String, Object>();

		try { // 쿼리로 가져온 cnt 값으로 json 값을 만듦
			retVal = uMapper.selectDate(yearMonthDate);
			retVal.put("year", year);
			retVal.put("month", month);
			retVal.put("date", date);
			retVal.put("is_success", true);

		} catch (Exception e) {
			retVal.put("totCnt", -999);
			retVal.put("year", year);
			retVal.put("month", month);
			retVal.put("date", date);
			retVal.put("is_success", false);
		}

		return retVal;
	}

	@Override
	public LinkedHashMap<String, Object> avgDay(String yearMonth) {
		String year = yearMonth.substring(0, 2);
		String month = yearMonth.substring(2);

		// JSON을 만들기 위해 HashMap 형태로 return함
		LinkedHashMap<String, Object> retVal = new LinkedHashMap<String, Object>();

		try { // 쿼리로 가져온 cnt 값으로 json 값을 만듦
			retVal = uMapper.avgDay(yearMonth);
			retVal.put("year", year);
			retVal.put("month", month);
			retVal.put("is_success", true);
			
			// 월을 구해서 나눔
			long total = (long)retVal.get("loginAvg");
			switch (month) {
				case "01": total /= 31.0; break;
				case "02": total /= 28.0; break;
				case "03": total /= 31.0; break;
				case "04": total /= 30.0; break;
				case "05": total /= 31.0; break;
				case "06": total /= 30.0; break;
				case "07": total /= 31.0; break;
				case "08": total /= 31.0; break;
				case "09": total /= 30.0; break;
				case "10": total /= 31.0; break;
				case "11": total /= 30.0; break;
				case "12": total /= 31.0; break;
				default: total = 0;
			}
			
			Object avg = (Object)total;
			retVal.put("loginAvg", avg);

		} catch (Exception e) {
			retVal.put("loginAvg", -999);
			retVal.put("year", year);
			retVal.put("month", month);
			retVal.put("is_success", false);
			e.printStackTrace();
		}

		return retVal;

	}

	@Override
	public LinkedHashMap<String, Object> selectmonthLogin(String month) {

		return null;
	}

	@Override
	public LinkedHashMap<String, Object> selectOrgLogin(String month) {

		return null;
	}

}