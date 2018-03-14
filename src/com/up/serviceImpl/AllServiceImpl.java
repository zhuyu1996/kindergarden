package com.up.serviceImpl;

import java.util.Date;
import java.util.List;


import com.up.dao.AllDao;
import com.up.entity.News;
import com.up.service.AllService;


public class AllServiceImpl implements AllService {
AllDao alldao=new AllDao();
  @Override
	public int insertNews(News news) {
		// TODO Auto-generated method stub
		return alldao.add(news);
	}

	@Override
	public List<News> sreachAllState(String A, String B, String C, String D, int pageNum) {
		// TODO Auto-generated method stub
		return alldao.sreachAllState(A, B, C, D,pageNum);
	}

	
	@Override
	public List<News> NewsSreach(String title, String time, String issuer, int pageNum) {
		// TODO Auto-generated method stub
		return alldao.NewsSreach(title, time, issuer,pageNum);
	}

	@Override
	public int deleteNews(int idnews) {
		// TODO Auto-generated method stub
		return alldao.deleteNews(idnews);
	}

	
	public List<News> sreachAllState(String issuer, String a, String b, String c, String d, int pageNum) {
		// TODO Auto-generated method stub
		return alldao.sreachAllState(issuer, a, b, c,d,pageNum);
	}

	@Override
	public List<News> showAllSaveNews(int pageNum,String issuer) {
		// TODO Auto-generated method stub
		return alldao.showAllSaveNews(pageNum,issuer);
	}

	@Override
	public int changeState(int idnews, String state) {
		// TODO Auto-generated method stub
		return alldao.changeState(idnews,state);
	}

	@Override
	public News sreachByID(int idnews) {
		// TODO Auto-ygenerated method stub
		return alldao.sreachById(idnews);
	}
	@Override
	public int update(int idnews, String title,String message,String Url1,String Url2) {
		// TODO Auto-generated method stub
		return alldao.update(idnews,title,message,Url1,Url2);
	}

	public int update2(int idnews, String title, String message, String url1, String url2) {
		// TODO Auto-generated method stub
		return alldao.update2(idnews, title,message,url1,url2);
	}

}
