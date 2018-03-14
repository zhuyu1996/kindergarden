package cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.KaixueTimeDao;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.KaixueTime;

public class KaixueTimeDaoImpl extends JDBCTemplates<KaixueTime> implements KaixueTimeDao {

	@Override
	protected KaixueTime rowMapper(ResultSet rs) {
		KaixueTime kaixueTime=new KaixueTime();
		// TODO Auto-generated method stub
		try {
			kaixueTime.setK_id(rs.getString("k_id"));
			kaixueTime.setK_day(rs.getInt("k_day"));
			kaixueTime.setK_month(rs.getInt("k_month"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return kaixueTime;
	}

	@Override
	public int updatetime(KaixueTime kaixueTime) {
		String sql="UPDATE kaixueriqi set k_month=?,k_day=? WEHRE k_id=?";
		Object[] Param={kaixueTime.getK_month(),kaixueTime.getK_day(),"123456"};
		return update(sql,Param);
	}

	@Override
	public KaixueTime selecttime() {
		String sql="select*from kaixueriqi where k_id=?";
		Object[] Param={"123456"};
		return selectOne(sql,Param);
	}

}
