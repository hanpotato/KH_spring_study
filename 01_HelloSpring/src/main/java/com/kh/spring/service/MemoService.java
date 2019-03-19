package com.kh.spring.service;

import java.util.List;
import java.util.Map;

public interface MemoService {

	int insertMemo(Map<String,String> map);
	List<Map<String,String>> selectMemo();
}
