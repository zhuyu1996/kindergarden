package cn.edu.cqupt.camphor_forest.kindergarten.service.impl;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl.MovieContentDaoImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.MovieContentservice;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.MovieContent;

public class MovieContentservieImpl implements MovieContentservice{

	MovieContentDaoImpl moviecontentdaoimpl=new MovieContentDaoImpl();
	@Override
	public int addMovieContent(MovieContent moviecontent) {
		return moviecontentdaoimpl.insertMovieContent(moviecontent);
	}

	@Override
	public void delMovieContent(String[] mcid) {
		moviecontentdaoimpl.deletMovieContent(mcid);
	}

	@Override
	public int updMovieContent(MovieContent moviecontent) {
        return moviecontentdaoimpl.updateMovieContent(moviecontent);
	}

	@Override
	public Paging showMCByclass(String classid,int pageNum) {
	    return moviecontentdaoimpl.selectMCByclass(classid,pageNum);
	}

	@Override
	public Paging showMCByAdmi(int pageNum) {
		return moviecontentdaoimpl.selectMCByAdmi(pageNum);
	}

	@Override
	public Paging showMCByclassApp(String classid,int pageNum) {
	    return moviecontentdaoimpl.selectMCByclassApp(classid,pageNum);
	}

}
