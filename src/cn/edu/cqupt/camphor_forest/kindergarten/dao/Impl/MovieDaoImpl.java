package cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.swing.plaf.synth.SynthSpinnerUI;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.MovieDao;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Movie;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Picture;

public class MovieDaoImpl extends JDBCTemplates<Movie> implements MovieDao{

	@Override
	public int insertMovie(Movie movie) {
		 String sql="INSERT INTO movie(mv_id,mv_date,mv_adress,mv_like,mv_belong,mv_picture)VALUES(?,?,?,?,?,?)";
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     Object[] param={UUID.randomUUID().toString().replace("-", ""),sdf.format(new Date()),movie.getMvAdress(),0,movie.getMcId(),movie.getMface()};
	     return update(sql,param);
	}

	@Override
	public void deleMovie(String[] mvid) {
		String sql="DELETE FROM movie WHERE mv_id=?";	
		batchupdate(sql,mvid);
	}

	@Override
	public Paging showMovieW(int pageNum,String mcid) {
		int pagesize=10;
		String sql1="SELECT * FROM movie WHERE mv_belong=? ORDER BY mv_date DESC";
		Object[] param={mcid};
		List<Movie> picturelist=selectAll(sql1,param);
		Paging page=new Paging(pageNum,pagesize,picturelist);
		String sql2="SELECT * FROM movie WHERE mv_belong=? ORDER BY mv_date DESC limit ?,?";
		int a[]=page.getMaindate(pageNum, pagesize);
		int pa2=a[0];
		int pa3=a[1];
		Object[] param2={mcid,pa2,pa3};
		List<Movie> movienewlist=selectAll(sql2,param2);
		page.getResult(movienewlist, page);
		return page;
	}

	@Override
	public List<Movie> showMovieAp(int pageNum,String mcid) {
		int pagesize=10;
		String sql1="SELECT * FROM movie WHERE mv_belong=? ORDER BY mv_date DESC";
		Object[] param={mcid};
		List<Movie> Movielist=selectAll(sql1,param);
		System.out.println("111"+Movielist);
		Paging page=new Paging(pageNum,pagesize,Movielist);
		String sql2="SELECT * FROM movie WHERE mv_belong=? ORDER BY mv_date DESC limit ?,?";
		int a[]=page.getMaindate(pageNum, pagesize);
		int pa2=a[0];
		int pa3=a[1];
		Object[] param2={mcid,pa2,pa3};
		List<Movie> movienewlist=selectAll(sql2,param2);
		return movienewlist;
	}

	@Override
	public int incrLike(String comId) {
		String sql2="UPDATE movie SET mv_like=mv_like+1 WHERE mv_id=?";
		Object[] param2={comId};
		 update(sql2, param2);
		 String sql="select mv_like from movie where mv_id=?";
		 Object[] param={comId};
		return oneInt(sql, param);
		}
	
	@Override
	protected Movie rowMapper(ResultSet rs) {
		Movie movie=new Movie();
		try {
			movie.setMvId(rs.getString("mv_id"));
			movie.setMvDate(rs.getString("mv_date"));
			movie.setMvAdress(rs.getString("mv_adress"));
			movie.setMvLike(rs.getString("mv_like"));
			movie.setMcId(rs.getString("mv_belong"));
			movie.setMface(rs.getString("mv_picture"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return movie;
	}

	
	
	@Override
	public List<Movie> showcollecrMovieAp(List<String> movid,int pageNum) {
		int pagesize=10;
		List<Movie> Movielist=new ArrayList<Movie>();
		for(int i=0;i<movid.size();i++){
			String sql1="SELECT * FROM movie WHERE mv_id=?";
		    Object[] param={movid.get(i)};
		    Movie Movie=selectOne(sql1,param);
		    Movielist.add(Movie);
		}
		return Movielist;
		}
}
