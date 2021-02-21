package com.example.settingweb_boot.test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.settingweb_boot.service.StatisticService;

@Controller
public class settingTest {

	@Autowired
	private StatisticService service;

	// 해당년도의 로그인 수
	@ResponseBody
	@RequestMapping("/sqlyearStatistic")
	public LinkedHashMap<String, Object> sqltest(String year) throws Exception {
		return service.yearloginNum(year);
	}

	// 월별 접속자 수
	@ResponseBody
	@RequestMapping("/sqlmonthStatistic")
	public LinkedHashMap<String, Object> getMonthCnt(String yearMonth) throws Exception {
		return service.selectMonth(yearMonth);
	}

	// 일자별 접속자 수
	@ResponseBody
	@RequestMapping("/sqldateStatistic")
	public LinkedHashMap<String, Object> getDateCnt(String yearMonthDate) throws Exception {
		return service.selectDate(yearMonthDate);
	}

	// 평균 하루 로그인 수 (월 기준)
	@ResponseBody
	@RequestMapping("/sqlavgStatistic")
	public LinkedHashMap<String, Object> getAvgCnt(String yearMonth) throws Exception {
		return service.avgDay(yearMonth);
	}

	// 휴일을 제외한 로그인 수 (월 기준)
	@ResponseBody
	@RequestMapping("/sqlholidayStatistic")
	public LinkedHashMap<String, Object> getphCnt(String yearMonth) throws Exception {
		return service.selectphLogin(yearMonth);
	}

	// 부서별 월별 로그인 수
	@ResponseBody
	@RequestMapping("/sqlorgStatistic")
	public LinkedHashMap<String, Object> getOrgCnt(String yearMonth, String org) throws Exception {
		return service.selectOrgLogin(yearMonth, org);
	}

	// test
	@RequestMapping("/test")
	public ModelAndView test() throws Exception {
		ModelAndView mav = new ModelAndView("test");
		mav.addObject("name", "ipsae");
		List<String> resultList = new ArrayList<String>();
		resultList.add("!!!HELLO WORLD!!!");
		resultList.add("설정 TEST!!!");
		resultList.add("설정 TEST!!!");
		resultList.add("설정 TEST!!!!!");
		resultList.add("설정 TEST!!!!!!");
		mav.addObject("list", resultList);
		return mav;
	}

}
