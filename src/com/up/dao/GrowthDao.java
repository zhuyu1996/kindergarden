package com.up.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.up.entity.News;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;

public class GrowthDao extends JDBCTemplates<News> {

	public int insertRcord(News news) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
			String sql="INSERT INTO news (time,issuer,title,kind,url1,url2)VALUES(?,?,?,?,?,?)";
		
			Object[] params={sdf.format(new Date()),news.getIssuer(),news.getTitle(),news.getKind(),news.getUrl1(),news.getUrl2()};
			
			return update(sql,params);
			
	}

	public int deleteNews(int idnews) {
		String sql="DELETE FROM News WHERE idnews=?";
		Object[] param={idnews};
		return update(sql,param);
	}

	public List<News> NewsSreach(String title, String time, String issuer, int pageNum) {
		List<News> news=null;
		List<News> news2=null;
		String hql=null;
		String hql2=null;
		String kind="成长知识";
		
			if(title!="" && time!="" &&issuer!=""){
				hql2="SELECT * FROM News  where title ='"+title+"'  and issuer ='"+issuer+"'  and time ='"+time+"'  and kind ='"+kind+"'";
				hql="SELECT * FROM News  where title ='"+title+"'  and issuer ='"+issuer+"'  and time ='"+time+"' and kind ='"+kind+"' order by  time desc limit ?,? ";
			}
			else if(title!="" && time!="" &&issuer==""){
				hql2="SELECT * FROM News  where title ='"+title+"'and time ='"+time+"' and kind ='"+kind+"'";
				hql="SELECT * FROM News  where title ='"+title+"'and time ='"+time+"' and kind ='"+kind+"' order by  time desc limit ?,?";
				}
			else if(title!="" && time=="" &&issuer!=""){
				hql2="SELECT * FROM News  where title ='"+title+"'and issuer ='"+issuer+"' and kind ='"+kind+"'";
				hql="SELECT * FROM News  where title ='"+title+"'and issuer ='"+issuer+"' and kind ='"+kind+"'  order by  time desc limit ?,?";
			
			}
			else if(title!="" && time=="" &&issuer==""){
				hql2="SELECT * FROM News  where title ='"+title+"' and kind ='"+kind+"'";
				hql="SELECT * FROM News  where title ='"+title+"' and kind ='"+kind+"'  order by  time desc limit ?,? ";
				
			}
			else if(title=="" && time!="" &&issuer!=""){
				hql2="SELECT * FROM News  where  issuer ='"+issuer+"'  and time ='"+time+"' and kind ='"+kind+"'";
				hql="SELECT * FROM News  where  issuer ='"+issuer+"'  and time ='"+time+"' and kind ='"+kind+"'  order by  time desc limit ?,?";
			}
			else if(title=="" && time!="" &&issuer!=""){
				hql2="SELECT * FROM News  where  issuer ='"+issuer+"'  and time ='"+time+"' and kind ='"+kind+"'";
				hql="SELECT * FROMNews  where  issuer ='"+issuer+"' and time ='"+time+"' and kind ='"+kind+"'  order by  time desc limit ?,?";
			}
			else if(title=="" && time=="" &&issuer==""){
				return null;
			}
			
			
			news=selectByAll(hql2);
			Paging page=new Paging (pageNum, 10,news);   	
	      int a[]=page.getMaindate(pageNum, 10);
			int begin=a[0];
			int last=a[1];
			
			Object [] params={begin,last};
			news2=selectAll(hql,params);
			if(!news2.isEmpty()){
				news2.get(0).setTotalPage(page.getTotalPage());
				}
				
		
	
			return news2;
	}
	

	@Override
	protected News rowMapper(ResultSet rs) {
		News news=new News();
		try {
			news.setIdnews(rs.getInt("idnews"));
			news.setIssuer(rs.getString("issuer"));
			news.setTime(rs.getString("time"));
			
			news.setTitle(rs.getString("title"));
			
			news.setKind(rs.getString("kind"));
			news.setUrl1(rs.getString("url1"));
			news.setUrl2(rs.getString("url2"));
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return news;
	}

	public List<News> ShowAllGrowth(int pagenum) {
		// TODO Auto-generated method stub
		List<News>news=null;
		List<News>news2=null;
		String kind="成长知识";
		String sql="SELECT * FROM News  where  kind =?";
		Object[] p={kind};
		news=selectAll(sql, p);
		String sql2="SELECT * FROM News  where  kind =? order by  time desc limit ?,?";
		Paging page=new Paging (pagenum, 10,news);   	
	      int a[]=page.getMaindate(pagenum, 10);
			int begin=a[0];
			int last=a[1];
			Object[] p2={kind,begin,last};	
			news2=selectAll(sql2, p2);
			if(!news2.isEmpty()){
				news2.get(0).setTotalPage(page.getTotalPage());}
			
		return news2;
	}
	
}
