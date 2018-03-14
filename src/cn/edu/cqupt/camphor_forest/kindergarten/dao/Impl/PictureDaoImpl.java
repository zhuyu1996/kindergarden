package cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.PictureDao;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.SiChanping;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Movie;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Picture;

public class PictureDaoImpl extends JDBCTemplates<Picture> implements PictureDao{

	@Override
	public int insertpicture(Picture picture) {
	     String sql="INSERT INTO picture (x_id,x_time,x_link,p_id,p_like )VALUES(?,?,?,?,?)";
	   	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	        Object[] param={UUID.randomUUID().toString().replace("-", ""),sdf.format(new Date()),picture.getXcAdress(),picture.getpId(),0};
			return update(sql,param);
	}

	@Override
	public void delepicture(String[] xid) {
		String sql="DELETE FROM picture WHERE x_id=?";	
		String[] param=xid;
		batchupdate(sql,param);
	}
	@Override
	public Paging showPictureW(String pid,int pageNum) {
		int pagesize=20;
		String sql1="SELECT * FROM picture where p_id=? ORDER BY x_time DESC";
		Object[] param={pid};
		List<Picture> picturelist=selectAll(sql1,param);
		Paging page=new Paging(pageNum,pagesize,picturelist);
		int totalpage=page.getTotalPage();
		String sql2="SELECT * FROM picture where p_id=? ORDER BY x_time DESC limit ?,?";
		int a[]=page.getMaindate(pageNum, pagesize);
		int pa2=a[0];
		int pa3=a[1];
		Object[] param2={pid,pa2,pa3};
		List<Picture> picturenewlist=selectAll(sql2,param2);
		page.getResult(picturenewlist, page);
		return page;
	}
	
	public List<SiChanping<Picture>> showPictureAp(String pid,int pageNum) {
		int pagesize=20;
		String sql1="SELECT * FROM picture where p_id=? ORDER BY x_time DESC";
		Object[] param={pid};
		List<Picture> picturelist=selectAll(sql1,param);
		Paging page=new Paging(pageNum,20,picturelist);
		String sql2="SELECT * FROM picture where p_id=? ORDER BY x_time DESC limit ?,?";
		int a[]=page.getMaindate(pageNum, pagesize);
		int pa2=a[0];
		int pa3=a[1];
		Object[] param2={pid,pa2,pa3};
		List<Picture> picturenewlist=selectAll(sql2,param2);
		System.out.println(picturenewlist.size());
		String sql3="SELECT distinct(x_time) FROM picture where p_id=? ORDER BY x_time DESC limit ?,?";
		Object[] param3={pid,pa2,pa3};
		
		List<String> liststring=onestringlist(sql3, param3);System.out.println(liststring);
		int size=liststring.size();
		System.out.println("baokuo"+liststring.toString());
		List<SiChanping<Picture>> sxd=new ArrayList<SiChanping<Picture>>();
		List<Picture> datelist=new ArrayList<Picture>();
		SiChanping<Picture> scppp=new SiChanping<Picture>();

		for(int j=0;j<liststring.size();j++){
			for(int i=0;i<picturenewlist.size();i++){
				
				 if(liststring.get(j).toString().equals(picturenewlist.get(i).getXcDate().toString())){
				      scppp.setTime(liststring.get(j).toString());
			          datelist.add(picturenewlist.get(i));
				 }
				 }
					 scppp.setT(datelist);
					 sxd.add(scppp);
				 
			
		}
		return sxd;
	}
	
	

	@Override
	public int incrLike(String comId) {
		String sql2="UPDATE picture SET p_like=p_like+1 WHERE x_id=?";
		Object[] param2={comId};
		 update(sql2, param2);
		 String sql="select p_like from picture where x_id=?";
		 Object[] param={comId};
		return oneInt(sql, param);
		}
	
	@Override
	protected Picture rowMapper(ResultSet rs) {
		Picture picture=new Picture();
		try {
			picture.setpId(rs.getString("p_id"));
			picture.setXcId(rs.getString("x_id"));
			picture.setXcDate(rs.getString("x_time"));
			picture.setXcAdress(rs.getString("x_link"));
			picture.setpLike(rs.getString("p_like"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return picture;
	}

	public List<Picture> ashowPictureAp(List<String> pid,int pageNum){
		int pagesize=20;
		List<Picture> picturelist=new ArrayList<Picture>();
		for(int i=0;i<pid.size();i++){
		String sql1="SELECT * FROM picture where x_id=?";
		Object[] param={pid.get(i)};
		Picture picture=selectOne(sql1,param);
		picturelist.add(picture);
		System.out.println(picturelist);
       }
	
		return picturelist;
		
	}


}
