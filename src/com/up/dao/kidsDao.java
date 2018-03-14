package com.up.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.up.entity.Kids;
import com.up.entity.News;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;

public class kidsDao extends JDBCTemplates<Kids>{
	
	public int add(Kids kids) {

		
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		String sql="INSERT INTO kids (kidsName,kidsPhone,kidskind)VALUES(?,?,?)";
	
		Object[] params={kids.getKidsName(),kids.getKidsPhone(),kids.getKidskind()};
		
		
	  return update(sql,params);
}
	public Kids checkkids(Kids kids){
		String kidsPhone=kids.getKidsPhone();
		String sql="SELECT * from kids where kidsPhone ='"+kidsPhone+"'";
		Kids k1=selectOne(sql);
		System.out.println("k1"+k1);
		
		return k1;
		
	}
public List<Kids> showall(){
	String sql="SELECT * from kids";
	List<Kids> kids=selectByAll(sql);
	return kids;
	
}
	@Override
	protected Kids rowMapper(ResultSet rs) {
		// TODO Auto-generated method stub
		Kids kids=new Kids();
	
				try {
					
				kids.setIdkids(rs.getInt("Idkids"));
				kids.setKidsName(rs.getString("KidsName"));
				kids.setKidsPhone(rs.getString("KidsPhone"));
				kids.setKidskind(rs.getString("Kidskind"));
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		return kids;
	}
}
