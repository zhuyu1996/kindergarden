package com.up.service;

import java.util.List;

import com.up.entity.News;

public interface GgService {
	//根据状态查询公告
	List<News> sreachGgState(String A,String B,String C,String D,int pageNum);


}
