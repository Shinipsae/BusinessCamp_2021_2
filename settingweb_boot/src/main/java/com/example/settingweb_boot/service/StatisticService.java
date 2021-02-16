package com.example.settingweb_boot.service;

import java.util.LinkedHashMap;

public interface StatisticService {
	// 해당 년도의 로그인 수
    public LinkedHashMap<String,Object> yearloginNum (String year);
    public LinkedHashMap<String, Object> selectMonth(String yearMonth);
    public LinkedHashMap<String, Object> selectDate(String yearMonthDate);
    public LinkedHashMap<String, Object> avgDay(String yearMonth);
    public LinkedHashMap<String, Object> selectmonthLogin(String month);
    public LinkedHashMap<String, Object> selectOrgLogin(String month);
}