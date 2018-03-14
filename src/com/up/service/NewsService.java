package com.up.service;

import java.util.List;

import com.up.entity.News;

public interface NewsService {
	//根据状态查询xinwen
		List<News> sreachNewsState(String A,String B,String C,String D,int pageNum);	

}
