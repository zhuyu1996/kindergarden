package com.up.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.up.entity.News;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;

public class GgDao extends JDBCTemplates<News> {
	//根据状态查询公告
	 public   List<News> sreachGgState(String A,String B,String C,String D, int pageNum) {
		    List<News> news=null;
	 		List<News> news2=null;
			String kind="公告";
			String state="草稿";
			
				if(A!=""){
					String sql="SELECT * FROM News where kind=? and state!=?";
					Object [] p={kind,state};	
					 news=selectAll(sql, p);
					Paging page=new Paging (pageNum, 10,news);
					String sql2="SELECT * FROM News where kind=? and state!=? order by  time desc limit ?,?";
					
					int a[]=page.getMaindate(pageNum, 10);
					int begin=a[0];
					int last=a[1];
					Object [] p1={kind,state,begin,last};
					news2=selectAll(sql2, p1);
					if(!news2.isEmpty()){
					news2.get(0).setTotalPage(page.getTotalPage());}
					System.out.println(1);
				return news2;
				}
				else if(A==""){
					
					String sql="SELECT * FROM News as a where (a.state =? or a.state =? or a.state =?) and a.kind=?";
					Object [] p={B,C,D,kind};
					news=selectAll(sql, p);
					Paging page=new Paging (pageNum, 10,news);
				 String sql2="SELECT * FROM News as a where (a.state =? or a.state =? or a.state =?) and a.kind=?  order by  time desc limit ?,? ";
					
					int a[]=page.getMaindate(pageNum, 10);
					int begin=a[0];
					int last=a[1];
					Object [] p1={B,C,D,kind,begin,last};
					news2 =selectAll(sql2, p1);
					System.out.println(2);
					if(!news2.isEmpty()){
					news2.get(0).setTotalPage(page.getTotalPage());}
					return news2;
				}
			return null;	
		}
	 public List<News> sreachGgState(String issuer, String a, String b, String c, String d, int pageNum) {
			String sql=null;
			String kind="公告";
			String state="草稿";
			System.out.println(a);
				if(a!=""){
					sql="SELECT * FROM News as a where a.issuer =? and a.kind=? and a.state!=?";
					Object [] p={issuer,kind,state};	
					List<News> news=selectAll(sql, p);
					
					Paging page=new Paging (pageNum, 10,news);
					sql="SELECT * FROM News as a where a.issuer =? and a.Kind=? and state!=? order by  time desc limit ?,?";
					
					int a1[]=page.getMaindate(pageNum, 10);
					int begin=a1[0];
					int last=a1[1];
					Object [] p1={issuer,kind,state,begin,last};	
					List<News> news2=selectAll(sql, p1);
					if(!news2.isEmpty()){
					news2.get(0).setTotalPage(page.getTotalPage());}
					System.out.println("A");
				return news2;
				}
				else if(a==""){
					System.out.println("B");
					String hql="SELECT * FROM News as a where (a.state =? or a.state =? or a.state =?) and a.issuer =? and a.kind=?";
					Object [] pa={b,c,d,issuer,kind};
					
					
					List<News> news=selectAll(hql, pa);
					System.out.println(2);
					Paging page=new Paging (pageNum, 10,news);
					String hql2="SELECT * FROM News as a where (a.state =? or a.state =? or a.state =?) and a.issuer =? and a.kind=?  order by  time desc limit ?,?";
					int a1[]=page.getMaindate(pageNum, 10);
					int begin=a1[0];
					int last=a1[1];
					Object [] pam={b,c,d,issuer,kind,begin,last};
					List<News>news2=selectAll(hql2, pam);
					if(!news2.isEmpty()){
					news2.get(0).setTotalPage(page.getTotalPage());}
					
					return news2;
				}
				return null;	
		}
	 
	 @Override
		protected News rowMapper(ResultSet rs) {
			
			News news=new News();
				try {
					news.setIdnews(rs.getInt("idnews"));
					news.setIssuer(rs.getString("issuer"));
					news.setTime(rs.getString("time"));
					news.setState(rs.getString("state"));
					news.setTitle(rs.getString("title"));
					news.setMessage(rs.getString("message"));
					news.setKind(rs.getString("kind"));
					news.setUrl1(rs.getString("url1"));
					news.setUrl2(rs.getString("url2"));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return news;
			}
	 //app端只显示通过的公告
	public List<News> sreachGgState3(String a, String b, String c, String b2, int pageNum) {
		String sql=null;
		String kind="公告";
		String state="通过";
		List<News>news2=null;
		System.out.println(a);
			if(a!=""){
				sql="SELECT * FROM News as a where a.state =? and a.kind=?";
				Object [] p={state,kind};	
				List<News> news=selectAll(sql, p);
				
				Paging page=new Paging (pageNum, 10,news);
				sql="SELECT * FROM News as a where a.state =? and a.Kind=?  order by  time desc limit ?,?";
				
				int a1[]=page.getMaindate(pageNum, 10);
				int begin=a1[0];
				int last=a1[1];
				Object [] p1={state,kind,begin,last};	
				news2=selectAll(sql, p1);
				if(!news2.isEmpty()){
				news2.get(0).setTotalPage(page.getTotalPage());}
				System.out.println("A");
			
			
	}
			return news2;	
	}}
	
	

