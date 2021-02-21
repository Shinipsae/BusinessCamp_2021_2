package com.example.settingweb_boot.dao;

import java.util.LinkedHashMap;
 
public interface  StatisticMapper {
    public LinkedHashMap<String, Object> selectYearLogin(String year);
    public LinkedHashMap<String, Object> selectMonth(String yearMonth);
    public LinkedHashMap<String, Object> selectDate(String yearMonthDate);
    public LinkedHashMap<String, Object> avgDay(String yearMonth);
    public LinkedHashMap<String, Object> selectphLogin(String yearMonth);
    public LinkedHashMap<String, Object> selectOrgLogin(String yearMonth, String org);
}