package cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.CollectMovTotalDao;
import cn.edu.cqupt.camphor_forest.kindergarten.dao.CollectMovieDao;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectMovTotal;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectMovie;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Movie;

public class CollectMovTotalDaoImpl extends JDBCTemplates<CollectMovTotal> implements CollectMovTotalDao{


	@Override
	protected CollectMovTotal rowMapper(ResultSet rs) {
		CollectMovTotal collectMovTotal=new CollectMovTotal();
		try {
			collectMovTotal.setMcId(rs.getString("mv_id"));
			collectMovTotal.setMface(rs.getString("mv_picture"));
			collectMovTotal.setMvAdress(rs.getString("mv_adress"));
			collectMovTotal.setMvDate(rs.getString("mv_date"));
			collectMovTotal.setMvId(rs.getString("mv_belong"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return collectMovTotal;
	}

	@Override
	public List<String> showcollectMovtal(String mcid) {
		String sql1="SELECT mv_belong FROM collectmovbelong WHERE mv_picid=?";
		Object[] param={mcid};
		List<String>  movidlist=onestringlist(sql1,param);
		return movidlist;
	}


//belong是图片。picid是目录
	@Override
	public int insertcollectMovtal(String Movid, String pmid) {
		String sql="INSERT INTO collectmovbelong(mv_id,mv_belong,mv_picid)VALUES(?,?,?)";
	     Object[] param={UUID.randomUUID().toString().replace("-", ""),Movid,pmid};
	     return update(sql,param);
	}



}
