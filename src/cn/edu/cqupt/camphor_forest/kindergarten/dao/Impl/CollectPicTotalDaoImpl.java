package cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.CollectPicTotalDao;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.SiChanping;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectPicTotal;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Picture;

public class CollectPicTotalDaoImpl extends JDBCTemplates<CollectPicTotal> implements CollectPicTotalDao {

	@Override
	protected CollectPicTotal rowMapper(ResultSet rs) {
		CollectPicTotal collectPicTotal=new CollectPicTotal();
		
		try {
			collectPicTotal.setpId(rs.getString("p_id"));
			collectPicTotal.setXcAdress(rs.getString("x_link"));
			collectPicTotal.setXcDate(rs.getString("x_time"));
			collectPicTotal.setXcId(rs.getString("x_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return collectPicTotal;
	}

	@Override
	public int insertcollectPictal(String pictureid, String pmid) {
		//p_id是封面，x——link是图片地址
		
		 String sql="INSERT INTO collectpicbelong(x_id,p_id,x_link)VALUES(?,?,?)";
	     Object[] param={UUID.randomUUID().toString().replace("-", ""),pmid,pictureid};
	     return update(sql,param);
	}

	@Override
	public List<String> showcollectPictal(String mcid) {
		String sql1="SELECT x_link FROM collectpicbelong WHERE p_id=?";
		Object[] param={mcid};
		List<String>  piscturelist=onestringlist(sql1,param);
		return piscturelist;
	}

	@Override
	public void deletepicture(String[] picturreid) {
		 String sql="DELETE FROM collectpicbelong WHERE x_link=?";
	     String[] param=picturreid;
	     batchupdate(sql,param);
	}

}
