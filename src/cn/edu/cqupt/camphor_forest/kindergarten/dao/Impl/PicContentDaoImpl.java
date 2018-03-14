package cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.PictureContentDao;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.PictureContent;


public class PicContentDaoImpl extends JDBCTemplates<PictureContent> implements PictureContentDao{

	@Override
	public int deletePicContent(String pid) {
		String sql1="DELETE FROM picture WHERE p_id=?";	
		String[] param1={pid};
		update(sql1,param1);
		String sql="DELETE FROM picturecontent WHERE p_id=?";	
		Object[] param={pid};
		return update(sql,param);
	}

	@Override
	public int createPicContent(PictureContent picturecontent) {
		 String sql="INSERT INTO picturecontent(p_id,p_name,p_direction,p_date,p_face,c_id)VALUES(?,?,?,?,?,?)";
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		  String face="http://119.29.225.57:8080/photo/9/9/b1cca2b3e791469eb4fab53f1a025200.png";
	    Object[] param={UUID.randomUUID().toString().replace("-", ""),picturecontent.getPicname(),picturecontent.getPicmdescribe(),sdf.format(new Date()),face,picturecontent.getCid()};
			
	        return update(sql,param);
	}
	@Override
	protected PictureContent rowMapper(ResultSet rs) {
		PictureContent pic=new PictureContent();
		try {
			pic.setPicid(rs.getString("p_id"));
			pic.setPicname(rs.getString("p_name"));
			pic.setPicmdescribe(rs.getString("p_direction"));
			pic.setPicdate(rs.getString("p_date"));
			pic.setPicface(rs.getString("p_face"));
			pic.setCid(rs.getString("c_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pic;
	}
//未用（全校图鉴）
	@Override
	public List<PictureContent> showContentWe(int pageNum) {
		int pagesize=20;
		String sql1="SELECT * FROM picturecontent WHERE c_id=1 ORDER BY p_date DESC";
		List<PictureContent> pictureconlist=selectByAll(sql1);
		Paging page=new Paging(pageNum,pagesize,pictureconlist);
		String sql2="SELECT * FROM picturecontent WHERE c_id=1 ORDER BY p_date DESC limit ?,?";
		int a[]=page.getMaindate(pageNum, pagesize);
		int pa2=a[0];
		int pa3=a[1];
		Object[] param2={pa2,pa3};
		List<PictureContent> pictureconnewlist=selectAll(sql2,param2);
		for(int i=0;i<pictureconnewlist.size();i++){
		String sql3="SELECT x_link FROM picture where p_id=? ORDER BY x_time DESC";
		
		Object[] param={pictureconnewlist.get(i).getPicid().toString()};
		String list=oneString(sql3,param);
		String sql4="update picturecontent set c_iddd=? where p_id=?";
		Object[] param4={list,pictureconnewlist.get(i).getPicid().toString()};
		update(sql4,param4);
		pictureconnewlist.get(i).setPicface(list);
		}
		return pictureconnewlist;
	}
//app的家长老师
	@Override
	public List<PictureContent> showContentAp(int pageNum,String cid) {
		int pagesize=20;
		String b[]=cid.trim().split("");
		int siz=b.length;
		String cname="";
		if(siz==4){
			cname=b[2]+b[3];
		}
		if(siz==3){
			cname=b[2];
		}
		System.out.println("z[0]="+b[1]);
		String sql7="SELECT co_flag FROM classone where co_name=?";
		String[] param7={b[1]};
        int ccflag=oneInt(sql7,param7);
		String sql1="SELECT c_id FROM class where c_name=? and c_flag=?";
		Object[] param={cname,ccflag};
        String ccid=oneString(sql1,param);
		String sql5="SELECT * FROM picturecontent where c_id=? ORDER BY p_date DESC";
		Object[] param5={ccid};
		List<PictureContent> pictureconlist=selectAll(sql5,param5);
		Paging page=new Paging(pageNum,pagesize,pictureconlist);
		String sql2="SELECT * FROM picturecontent where c_id=? ORDER BY p_date DESC limit ?,?";
		int a[]=page.getMaindate(pageNum, pagesize);
		int pa2=a[0];
		int pa3=a[1];
		Object[] param2={ccid,pa2,pa3};
		List<PictureContent> pictureconnewlist=selectAll(sql2,param2);
		for(int i=0;i<pictureconnewlist.size();i++){
		String sql3="SELECT x_link FROM picture where p_id=? ORDER BY x_time DESC";
		Object[] param6={pictureconnewlist.get(i).getPicid().toString()};
		String list=oneString(sql3,param6);
		String sql4="update picturecontent set c_iddd=? where p_id=?";
		Object[] param4={list,pictureconnewlist.get(i).getPicid().toString()};
		update(sql4,param4);
		pictureconnewlist.get(i).setPicface(list);
		}
		return pictureconnewlist;
	}
//web的老师
	@Override
	public List<PictureContent> showContentteacher(int pageNum,String cid) {
		int pagesize=20;
		String sql1="SELECT * FROM picturecontent where c_id=? ORDER BY p_date DESC";
		Object[] param1={cid};
		List<PictureContent> pictureconlist=selectAll(sql1,param1);
		Paging page=new Paging(pageNum,pagesize,pictureconlist);
		String sql2="SELECT * FROM picturecontent where c_id=? ORDER BY p_date DESC limit ?,?";
		int a[]=page.getMaindate(pageNum, pagesize);
		int pa2=a[0];
		int pa3=a[1];
		Object[] param2={cid,pa2,pa3};
		List<PictureContent> pictureconnewlist=selectAll(sql2,param2);
		for(int i=0;i<pictureconnewlist.size();i++){
		String sql3="SELECT x_link FROM picture where p_id=? ORDER BY x_time DESC";
		
		Object[] param={pictureconnewlist.get(i).getPicid().toString()};
		String list=oneString(sql3,param);
		String sql4="update picturecontent set c_iddd=? where p_id=?";
		Object[] param4={list,pictureconnewlist.get(i).getPicid().toString()};
		update(sql4,param4);
		pictureconnewlist.get(i).setPicface(list);
		}
		return pictureconnewlist;
	}
//未用
	@Override
	public List<PictureContent> allshowContentAp(int pageNum) {
		int pagesize=20;
		String sql1="SELECT * FROM picturecontent ORDER BY p_date DESC";
		List<PictureContent> pictureconlist=selectByAll(sql1);
		Paging page=new Paging(pageNum,pagesize,pictureconlist);
		String sql2="SELECT * FROM picturecontent ORDER BY p_date DESC limit ?,?";
		int a[]=page.getMaindate(pageNum, pagesize);
		int pa2=a[0];
		int pa3=a[1];
		Object[] param2={pa2,pa3};
		List<PictureContent> pictureconnewlist=selectAll(sql2,param2);
		for(int i=0;i<pictureconnewlist.size();i++){
		String sql3="SELECT x_link FROM picture where p_id=? ORDER BY x_time DESC";
		
		Object[] param={pictureconnewlist.get(i).getPicid().toString()};
		String list=oneString(sql3,param);
		String sql4="update picturecontent set c_iddd=? where p_id=?";
		Object[] param4={list,pictureconnewlist.get(i).getPicid().toString()};
		update(sql4,param4);
		pictureconnewlist.get(i).setPicface(list);
		}
		return pictureconnewlist;
	}

	}
	


