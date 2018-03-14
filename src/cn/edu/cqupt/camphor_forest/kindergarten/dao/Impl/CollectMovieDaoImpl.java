package cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.CollectMovieDao;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectMovie;


public class CollectMovieDaoImpl extends JDBCTemplates<CollectMovie> implements CollectMovieDao{

	@Override
	public int insertcollectmovie(CollectMovie collectMovie) {
		 String sql="INSERT INTO collectmovie (cm_id,cm_userid,cm_name)VALUES(?,?,?)";
	     Object[] param={UUID.randomUUID().toString().replace("-", ""),collectMovie.getCmuserid(),"您的个人收藏视频"};
		 return update(sql,param);
	  
	}

	@Override
	protected CollectMovie rowMapper(ResultSet rs) {
		CollectMovie collectMovie=new CollectMovie();
		try {
			collectMovie.setCmid(rs.getString("cm_id"));
			collectMovie.setCmuserid(rs.getString("cm_userid"));
			collectMovie.setCmname(rs.getString("cm_name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return collectMovie;
	}

	@Override
	public CollectMovie showcollectmoviecontentAp(String userid) {
		String sql="SELECT*FROM collectmovie WHERE cm_userid=?";
		Object[] param={userid};
		return selectOne(sql,param);
	}

}
