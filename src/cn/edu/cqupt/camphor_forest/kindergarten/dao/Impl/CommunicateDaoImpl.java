package cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.CommunicateDao;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Communicate;

public class CommunicateDaoImpl  extends JDBCTemplates<Communicate> implements CommunicateDao{

	@Override
	public int deleteCom(String comId) {
	    String sql="DELETE FROM communicate WHERE com_id=?";
	    Object[] param={comId};
		return update(sql,param);
	}

	@Override
	public List<Communicate> selectcom(String xId) {
		String sql="select* from communicate where x_id=? ORDER BY com_time ASC";
		Object[] param={xId};
		List<Communicate> comlist=selectAll(sql, param);
		if(!comlist.isEmpty()){
		String sqls="select(count(*))from communicate where x_id=?;";
		Object[] params={xId};
		int count=oneInt(sqls,param);
		comlist.get(0).setComcount(count);
		}
		return comlist;
	}

	@Override
	public int insertCom(Communicate communicate) {
        String sql="INSERT INTO communicate(com_id,pone_id,ptwo_id,com_content,x_id,com_time)VALUES(?,?,?,?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Object[] params={UUID.randomUUID().toString().replace("-",""),communicate.getPoneId(),communicate.getPtwoId(),communicate.getComContent(),communicate.getxId(),sdf.format(new Date())};
		return update(sql,params);
	}

	@Override
	protected Communicate rowMapper(ResultSet rs) {
		Communicate com=new Communicate();
		try {
			com.setComId(rs.getString("com_id"));
			com.setxId(rs.getString("x_id"));
			com.setPtwoId(rs.getString("ptwo_id"));
			com.setPoneId(rs.getString("pone_id"));
			com.setComTime(rs.getString("com_time"));
			com.setComContent(rs.getString("com_content"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return com;
	}

}
