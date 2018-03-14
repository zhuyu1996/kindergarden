package com.up.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.up.entity.News;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;







public class AllDao extends JDBCTemplates<News> {
	
	public int add(News news) {
		String ccid=null;
		
		String cid=news.getCid();
		if(cid!=null){
		String b[]=cid.split("");
		String cname=b[2]+b[3];
		System.out.println("z[0]="+b[2]+b[1]+b[3]);
		String sql2="SELECT co_flag FROM classone where co_name=?";
		String[] param={b[1]};
        int ccflag=oneInt(sql2,param);
		String sql1="SELECT c_id FROM class where c_name=? and c_flag=?";
		Object[] param1={cname,ccflag};
         ccid=oneString(sql1,param1);}else{ccid=null;}
		
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			
			String sql="INSERT INTO news (time,issuer,state,title,message,kind,url1,url2,cid)VALUES(?,?,?,?,?,?,?,?,?)";
		
			Object[] params={sdf.format(new Date()),news.getIssuer(),news.getState(),news.getTitle(),news.getMessage(),news.getKind(),news.getUrl1(),news.getUrl2(),news.getCid()};
			
		  return update(sql,params);
	}

	public int add2(News news) {

		
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			
			String sql="INSERT INTO news (time,issuer,state,title,message,kind,url1,url2,cid)VALUES(?,?,?,?,?,?,?,?,?)";
		
			Object[] params={sdf.format(new Date()),news.getIssuer(),news.getState(),news.getTitle(),news.getMessage(),news.getKind(),news.getUrl1(),news.getUrl2(),news.getCid()};
			
		  return update(sql,params);
	}
	
	//根据状态全部，通过，等状态进行查询
	 public List<News> sreachAllState(String A,String B,String C,String D, int pageNum) {
		 		List<News> news=null;
		 		List<News> news2=null;
		 		String kind="成长知识";
		 		String kind2="教育随笔";
		 		String state="草稿";
				if(A!=""){
					String sql="SELECT * FROM News where kind!=? and kind!=? and state!=?";
					Object [] params={kind,kind2,state};
					news=selectAll(sql, params);
					
					Paging page=new Paging (pageNum, 10,news);
					
					String sql2="SELECT * FROM News  where kind!=? and kind!=? and state!=? order by time desc limit ?,?";
					int a[]=page.getMaindate(pageNum, 10);
					
					int begin=a[0];
					int last=a[1];
					 Object[] params2={kind,kind2,state,begin,last};
					news2=selectAll(sql2, params2);
					
					
					news2.get(0).setTotalPage(page.getTotalPage());
					System.out.println("A");
				return news2;
				}
				else if(A==""){
					System.out.println(B);
					String hql1="SELECT * FROM News as a where (a.state =? or a.state =? or a.state =?)and kind!='"+kind+"'and kind!='"+kind2+"'";
					Object[] params={B,C,D};
					news=selectAll(hql1, params);
					Paging page=new Paging (pageNum,10,news);
					int a[]=page.getMaindate(pageNum,10);
					int begin=a[0];
					int last=a[1];
					String hql2="SELECT * FROM News as a where (a.state =? or a.state =? or a.state =?)and kind!='"+kind+"'and kind!='"+kind2+"'order by time desc limit ?,?";
					Object [] params2={B,C,D,begin,last};
					 news2=selectAll(hql2, params2);
					 if(!news2.isEmpty())
					 {					news2.get(0).setTotalPage(page.getTotalPage());}
					
					System.out.println(news2);
					return news2;
				
				}
				return null;
				
	}
	 @Test
		public void test2(){
		 String ccid=null;
			
			String cid="大二班";
			if(cid!=null){
			String b[]=cid.split("");
			String cname=b[2]+b[3];
			System.out.println("z[0]="+b[2]+b[1]+b[3]);
			String sql2="SELECT co_flag FROM classone where co_name=?";
			String[] param={b[1]};
	        int ccflag=oneInt(sql2,param);
			String sql1="SELECT c_id FROM class where c_name=? and c_flag=?";
			Object[] param1={cname,ccflag};
	         ccid=oneString(sql1,param1);}else{ccid=null;}
			System.out.println(ccid);
		}
	 public List<News> sreachAllState(String issuer, String a, String b, String c, String d, int pageNum) {
			String sql=null;
			String kind="成长知识";
			String kind2="教育随笔";
				if(a!=""){
					sql="SELECT * FROM News as a where a.issuer =? and a.kind !=? and kind!='"+kind2+"'";
					Object [] p={issuer,kind};	
					List<News> news=selectAll(sql, p);
					System.out.println(1);
					Paging page=new Paging (pageNum, 10,news);
					sql="SELECT * FROM News as a where a.issuer =? and a.kind !=? and kind !='"+kind2+"' order by  time desc limit ?,? ";
					
					int a1[]=page.getMaindate(pageNum, 10);
					int begin=a1[0];
					int last=a1[1];
					Object [] p1={issuer,kind,begin,last};	
					List<News> news2=selectAll(sql, p1);
					if(!news2.isEmpty()){
					news2.get(0).setTotalPage(page.getTotalPage());}
					System.out.println("我的新闻公告1");
					
				return news2;
				}
				else if(a==""){
					
					String hql="SELECT * FROM News as a where (a.state =? or a.state =? or a.state =? )and a.issuer =? and a.kind !='"+kind+"' and kind !='"+kind2+"'";
					Object [] pa={b,c,d,issuer};
					
					
					List<News> news=selectAll(hql, pa);
					System.out.println(2);
					Paging page=new Paging (pageNum, 10,news);
					String hql2="SELECT * FROM News as a where (a.state =? or a.state =? or a.state =? )and a.issuer =? and a.kind !='"+kind+"' and kind !='"+kind2+"'  order by  time desc limit ?,?";
					int a1[]=page.getMaindate(pageNum, 10);
					int begin=a1[0];
					int last=a1[1];
					Object [] pam={b,c,d,issuer,begin,last};
					List<News>news2=selectAll(hql2, pam);
					try {
						if(news2.isEmpty()){
							news2.get(0).setTotalPage(page.getTotalPage());}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println("我的新闻公告2");
					return news2;
				}
				return null;	
		}
	
	
	//根据关键字，发布时间，发布人进行搜索 
	public List<News> NewsSreach(String title,String time,String issuer, int pageNum) {
		
			List<News> news=null;
			List<News> news2=null;
			String hql=null;
			String hql2=null;
			String kind="成长知识";
			String kind2="教育随笔";
			
				if(title!="" && time!="" &&issuer!=""){
					System.out.println(1);
					hql2="SELECT * FROM News  where title like '%"+title+"%'  and issuer ='"+issuer+"'  and time ='%"+time+"%' and kind !='"+kind+"' and kind !='"+kind2+"'";
					hql="SELECT * FROM News  where title like '%"+title+"%'  and issuer ='"+issuer+"'  and time ='%"+time+"%'and kind !='"+kind+"' and kind !='"+kind2+"'order by  time desc limit ?,? ";
				
				}
				else if(title!="" && time!=""&&issuer==""){
					System.out.println(2);
					hql2="SELECT * FROM News  where title like '%"+title+"%' and time like'%"+time+"%' and kind !='"+kind+"' and kind !='"+kind2+"'";
					hql="SELECT * FROM News  where title like '%"+title+"%' and time like '%"+time+"%' and kind !='"+kind+"' and kind !='"+kind2+"' order by  time desc limit ?,?";
					
			
				}
				else if(title!="" && time=="" &&issuer!=""){
					System.out.println(3);
					hql2="SELECT * FROM News  where title like '%"+title+"%' and issuer ='"+issuer+"' and kind !='"+kind+"' and kind !='"+kind2+"'";
					hql="SELECT * FROM News  where title like '%"+title+"%' and issuer ='"+issuer+"' and kind !='"+kind+"'and kind !='"+kind2+"'  order by  time desc limit ?,?";
				
				}
				else if(title!="" && time=="" &&issuer==""){
					System.out.println(4);
					hql2="SELECT * FROM News  where title like '%"+title+"%' and kind !='"+kind+"'and kind !='"+kind2+"' ";
					hql="SELECT * FROM News  where title like '%"+title+"%' and kind !='"+kind+"'and kind !='"+kind2+"' order by  time desc limit ?,? ";
					
				}
				else if(title=="" && time!="" &&issuer!=""){
					System.out.println(5);
					hql2="SELECT * FROM News  where  issuer ='"+issuer+"'  and time like '%"+time+"%' and kind !='"+kind+"'and kind !='"+kind2+"'";
					hql="SELECT * FROM News  where  issuer ='"+issuer+"'  and time like '%"+time+"%'and kind !='"+kind+"'and kind !='"+kind2+"'  order by  time desc limit ?,?";
				
				
				}
				else if(title=="" && time!="" &&issuer==""){
					System.out.println(6);
					hql2="SELECT * FROM News  where  time like '%"+time+"%' and kind !='"+kind+"'and kind !='"+kind2+"'";
					hql="SELECT * FROM News  where  time like '%"+time+"%' and kind !='"+kind+"'and kind !='"+kind2+"' order by  time desc limit ?,?";
				}
				else if(title=="" && time=="" &&issuer!=""){
					System.out.println(8);
					hql2="SELECT * FROM News  where  issuer ='"+issuer+"'and kind !='"+kind+"'and kind !='"+kind2+"'";
					hql="SELECT * FROM News  where  issuer ='"+issuer+"' and kind !='"+kind+"'and kind !='"+kind2+"' order by  time desc limit ?,?";
	
				}
				else if(title=="" && time=="" &&issuer==""){
					System.out.println(7);
					return null;
				}
				System.out.println(9);
		
			news=selectByAll(hql2);
			Paging page=new Paging (pageNum, 10,news);   	
	      int a[]=page.getMaindate(pageNum, 10);
			int begin=a[0];
			int last=a[1];
			
			Object [] params={begin,last};
			news2=selectAll(hql,params);
			if(!news2.isEmpty()){
			news2.get(0).setTotalPage(page.getTotalPage());}
			return news2;
	}

	
	//根据id删除文章
	public int deleteNews(int idnews) {
		String sql="DELETE FROM News WHERE idnews=?";
		Object[] param={idnews};
		return update(sql,param);
	
	}

	//教育记录草稿
	public List<News> showAllSaveNews(int pageNum ,String issuer) {
		
		String state="草稿";
		String kind="教育随笔";
		String sql="SELECT * FROM News where state=? and issuer=? and kind !='"+kind+"'";
		Object [] p={state,issuer};
		List <News>news=selectAll(sql, p);
		Paging page=new Paging (pageNum, 10,news);   	
      int a[]=page.getMaindate(pageNum, 10);
		int begin=a[0];
		int last=a[1];
		String sql2="SELECT * FROM News where state=? and issuer=? and kind !='"+kind+"' order by  time desc  limit ?,? ";
		Object [] p1={state,issuer,begin,last};
		List <News>news2=selectAll(sql2, p1);
		System.out.println(news2);
		return news2;
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
				news.setCid(rs.getString("cid"));
//				news.setUrl3(rs.getString("url3"));
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return news;
		}


	public int changeState(int idnews, String state) {
		// TODO Auto-generated method stub
		String sql="update News set state=? where idnews=?";
		Object [] p={state,idnews};
		News news=selectOne(sql, p);
		
		
		return update(sql, p);
	}


	public News sreachById(int idnews) {
		String sql="SELECT * FROM News where idnews=?";
		Object [] a={idnews};
		News news=selectOne(sql, a);
		
		return news;
	}


	public int update(int idnews, String title,String message,String Url1,String Url2) {
		// TODO Auto-generated method stub
	
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		 Date time=new Date();
		 String state="待审核";
			String sql="update news set time=?,title=?,message=?,url1=?,url2=?,state=? where idnews=?";
			Object[] params={time,title,message,Url1,Url2,state,idnews};
			return update(sql,params);
	}
	public int update2(int idnews, String title,String message,String Url1,String Url2) {
		// TODO Auto-generated method stub
	
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		 Date time=new Date();
		 String state="草稿";
			String sql="update news set time=?,title=?,message=?,url1=?,url2=?,state=? where idnews=?";
			Object[] params={time,title,message,Url1,Url2,state,idnews};
			return update(sql,params);
	}
	//app端班级公告
	public List<News> showclassGg(String classid,int pagenum){
		String kind="公告";
		String state="通过";
		String b[]=classid.split("");
		String cname=b[2]+b[3];
		System.out.println("z[0]="+b[2]+b[1]+b[3]);
		String sql="SELECT co_flag FROM classone where co_name=?";
		String[] param={b[1]};
        int ccflag=oneInt(sql,param);
		String sql1="SELECT c_id FROM class where c_name=? and c_flag=?";
		Object[] param1={cname,ccflag};
        String ccid=oneString(sql1,param1);
        String sql2="SELECT * FROM News where cid=? and kind=? and state=?";
        Object [] pa={ccid,kind,state};
        List<News> news=selectAll(sql2,pa);
        String sql3="SELECT * FROM News where cid=?  and kind=? and state=? order by  time desc limit ?,?";
        Paging page = null;
		try {
			page=new Paging (pagenum, 10,news);
		} catch (Exception e) {
			// TODO: handle exception
		}   	
      int a[]=page.getMaindate(pagenum, 10);
		int begin=a[0];
		int last=a[1];
		
		Object [] params={ccid,kind,state,begin,last};
		List<News>news2=selectAll(sql3,params);
		if(!news2.isEmpty()){
		news2.get(0).setTotalPage(page.getTotalPage());}
		return news2;
		
	}
	public List<News>showPumGg(int pagenum){
		String issuer="园长";
		String kind="公告";
		String state="通过";
		
		String sql="SELECT * FROM News where issuer=? and state=? and kind=?";
		Object []pa={issuer,state,kind};
		List<News> news=selectAll(sql, pa);
		Paging page=new Paging (pagenum, 10,news);   	
	      int a[]=page.getMaindate(pagenum, 10);
			int begin=a[0];
			int last=a[1];
			String sql2="SELECT * FROM News where issuer=? and state=? and kind=? order by  time desc limit ?,?";
			Object[] b={issuer,state,kind,begin,last};
			List<News>news2=selectAll(sql2, b);
		return news2;
		
	}
	//
	
	}
	
	

