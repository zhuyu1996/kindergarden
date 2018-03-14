package com.up.serviceImpl;

import java.util.List;


import com.up.dao.NewsDao;
import com.up.entity.News;
import com.up.service.NewsService;

public class NewsServiceImpl implements NewsService {
NewsDao newsDao=new NewsDao();
	@Override
	public List<News> sreachNewsState(String A, String B, String C, String D, int pageNum) {
		// TODO Auto-generated method stub
		return newsDao.sreachNewsState(A, B, C, D, pageNum);
	}
	public List<com.up.entity.News> sreachNewsState(String issuer, String a, String b, String c, String d,
			int pageNum) {
		// TODO Auto-generated method stub
	 return newsDao.sreachNewsState(issuer,a, b, c, d, pageNum);
	}
	public List<com.up.entity.News> sreachNewsState3(String a, String b, String c, String d, int pageNum) {
		// TODO Auto-generated method stub
		 return newsDao.sreachNewsState3(a, b, c, d, pageNum);
	}
	
}
