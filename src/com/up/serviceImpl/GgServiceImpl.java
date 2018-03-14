package com.up.serviceImpl;

import java.util.List;


import com.up.dao.GgDao;
import com.up.entity.News;
import com.up.service.GgService;

public class GgServiceImpl implements GgService {
GgDao Ggdao=new GgDao();
	@Override
	public List<News> sreachGgState(String A, String B, String C, String D, int pageNum) {
		// TODO Auto-generated method stub
		return Ggdao.sreachGgState(A, B, C, D,pageNum);
	}
	public List<News> sreachGgState(String issuer, String a, String b, String c, String d, int pageNum) {
		// TODO Auto-generated method stub
		return Ggdao.sreachGgState(issuer, a, b, c,b ,pageNum);
	}
	public List<com.up.entity.News> sreachGgState3(String a, String b, String c, String d, int pageNum) {
		// TODO Auto-generated method stub
		return Ggdao.sreachGgState3( a, b, c,b ,pageNum);
	}
	

}
