package com.up.service;

import java.util.Date;
import java.util.List;

import com.up.entity.News;


public interface AllService {
	//新增新闻或者公告
int insertNews(News news);
//根据状态全部，通过，等状态进行查询
List<News> sreachAllState(String A,String B,String C,String D,int pageNum);

List<News> NewsSreach(String title,String time,String issuer,int pageNum);
//根据id删除文章
int deleteNews(int idnews);
//显示草稿
List <News> showAllSaveNews(int pageNum,String issuer);
//修改状态
int changeState(int idnews,String state);
//
News sreachByID(int idnews);
//
int update(int idnews, String title,String message,String Url1,String Url2);
}
