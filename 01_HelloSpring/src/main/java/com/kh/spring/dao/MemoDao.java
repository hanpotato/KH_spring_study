package com.kh.spring.dao;

import java.util.List;
import java.util.Map;

public interface MemoDao {

	int insertMemo(Map<String,String> map);
	List<Map<String,String>> selectMemo();
	
}
