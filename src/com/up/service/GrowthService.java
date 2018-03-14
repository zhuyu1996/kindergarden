package com.up.service;

import java.util.Date;
import java.util.List;

import com.up.entity.News;

public interface GrowthService {
	//添加成长知识
	int insertRecord(News news);
	
	//根据id删除文章
	int deleteNews(int idnews);
	//查询
	List<News> NewsSreach(String title,String time,String issuer,int pageNum);
	//显示所有成长知识
	List<News> ShowAllGrowth(int pagenum);
	
}
