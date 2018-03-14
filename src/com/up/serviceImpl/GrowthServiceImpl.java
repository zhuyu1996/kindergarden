package com.up.serviceImpl;

import java.util.Date;
import java.util.List;

import com.up.dao.GrowthDao;
import com.up.entity.News;
import com.up.service.GrowthService;

public class GrowthServiceImpl implements GrowthService {
GrowthDao growthDao =new GrowthDao();
	@Override
	public int insertRecord(News news) {
		// TODO Auto-generated method stub
		return growthDao.insertRcord(news) ;
	}

	@Override
	public int deleteNews(int idnews) {
		// TODO Auto-generated method stub
		return growthDao.deleteNews(idnews);
	}

	@Override
	public List<News> NewsSreach(String title,String time, String issuer, int pageNum) {
		// TODO Auto-generated method stub
		return growthDao.NewsSreach(title,time,issuer,pageNum);
	}

	@Override
	public List<News> ShowAllGrowth(int pagenum) {
		// TODO Auto-generated method stub
		return growthDao.ShowAllGrowth(pagenum);
	}

	

}
