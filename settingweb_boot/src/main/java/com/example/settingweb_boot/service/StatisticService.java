package com.example.settingweb_boot.service;

import java.util.HashMap;

public interface StatisticService {
	// 해당 년도의 로그인 수
    public HashMap<String,Object> yearloginNum (String year);
    
}