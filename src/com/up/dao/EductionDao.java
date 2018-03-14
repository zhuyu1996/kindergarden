package com.up.dao;





import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.up.entity.News;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;

public class EductionDao extends JDBCTemplates<News>{
	//添加教育记录
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
		
			Object[] params={sdf.format(new Date()),news.getIssuer(),news.getState(),news.getTitle(),news.getMessage(),news.getKind(),news.getUrl1(),news.getUrl2(),ccid};
			
		  return update(sql,params);
	}
	
	@Test
	public void test2(){
		EductionDao eductionDao=new EductionDao();
		List<News> news=eductionDao.sreachbycid("大二班", 1);
		
		System.out.println(news);
	}
	//家长登录后根据班级id查询教育记录
	public List<News> sreachbycid(String cid ,int pageNum){ 
		String ccid=null;
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
		List<News> news=null;
 		List<News> news2=null;
 		String kind="教育随笔";
 		 String state="草稿";
		String sql="SELECT * FROM News where kind=? and cid=? and state!='"+state+"'";
		Object [] params={kind,ccid};
		news=selectAll(sql, params);
		Paging page=new Paging (pageNum, 10,news);
		String sql2="SELECT * FROM News  where kind=? and cid=? and state!='"+state+"' order by time desc limit ?,?";
		int a[]=page.getMaindate(pageNum, 10);
		
		int begin=a[0];
		int last=a[1];
		 Object[] params2={kind,ccid,begin,last};
		news2=selectAll(sql2, params2);
		news2.get(0).setTotalPage(page.getTotalPage());
		System.out.println("A");
		System.out.println("news2"+news2);
	return news2;
	}
	//管理员查看所有教育记录
	public List<News>sreachall(int pageNum){
		List<News> news=null;
 		List<News> news2=null;
 		String kind="教育随笔";
 		 String state="草稿";
 		String sql="SELECT * FROM News where kind=? and state!='"+state+"'";
		Object [] params={kind};
		news=selectAll(sql, params);
		Paging page=new Paging (pageNum, 10,news);
		String sql2="SELECT * FROM News  where kind=? and state!='"+state+"' order by time desc limit ?,?";
		int a[]=page.getMaindate(pageNum, 10);
		
		int begin=a[0];
		int last=a[1];
		 Object[] params2={kind,begin,last};
		news2=selectAll(sql2, params2);
		
		
		news2.get(0).setTotalPage(page.getTotalPage());
		System.out.println("A");
	return news2;
	}
/*	@Test
	public void test(){
	EductionDao eductionDao=new EductionDao();
	List<News> news=eductionDao.showAllSaveNews(1,"廖星建");
	System.out.println(news);
	}*/
	//老师查看自己的所有教育记录
		public List<News>sreachall(int pageNum,String issuer){
			List<News> news=null;
	 		List<News> news2=null;
	 		String kind="教育随笔";
	 		 String state="草稿";
	 		String sql="SELECT * FROM News where kind=? and issuer='"+issuer+"' and state!='"+state+"' ";
			Object [] params={kind};
			news=selectAll(sql, params);
			Paging page=new Paging (pageNum, 10,news);
			String sql2="SELECT * FROM News  where kind=? and issuer='"+issuer+"'and state!='"+state+"' order by time desc limit ?,?";
			int a[]=page.getMaindate(pageNum, 10);
			
			int begin=a[0];
			int last=a[1];
			 Object[] params2={kind,begin,last};
			news2=selectAll(sql2, params2);
			
			
			news2.get(0).setTotalPage(page.getTotalPage());
			
		return news2;
		}
		//app classeduction
		public List<News> ClassEduction(String cid ,int pageNum){
			List<News> news=null;
			List<News> news2=null;
			String kind="教育随笔";
		
	 		 String state="草稿";
	 		String ccid=null;
			
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
			
	 		String sql="SELECT * FROM News where kind=? and state!='"+state+"'and cid='"+ccid+"'";
			Object [] params={kind};
			news=selectAll(sql, params);
			Paging page=new Paging (pageNum, 10,news);
			String sql2="SELECT * FROM News  where kind=? and state!='"+state+"'and cid='"+ccid+"' order by time desc limit ?,?";
			int a[]=page.getMaindate(pageNum, 10);
			
			int begin=a[0];
			int last=a[1];
			 Object[] params2={kind,begin,last};
			news2=selectAll(sql2, params2);
			
			
			news2.get(0).setTotalPage(page.getTotalPage());
		
		return news2;
		}
	//家长根据时间关键字查询教育记录app不需要
	public List<News> NewsSreach(String title,String time,String issuer, String cid,int pageNum) {
		
		List<News> news=null;
		List<News> news2=null;
		String hql=null;
		String hql2=null;
		String kind="教育随笔";
		String ccid=null;
		
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
		
			if(title!="" && time!="" &&issuer!=""){
				System.out.println(1);
				hql2="SELECT * FROM News  where title like '%"+title+"%'  and issuer ='"+issuer+"'  and time ='%"+time+"%' and kind ='"+kind+"' and cid='%"+cid+"%'";
				hql="SELECT * FROM News  where title like '%"+title+"%'  and issuer ='"+issuer+"'  and time ='%"+time+"%'and kind ='"+kind+"' and cid='%"+cid+"%' order by  time desc limit ?,? ";
			
			}
			else if(title!="" && time!=""&&issuer==""){
				System.out.println(2);
				hql2="SELECT * FROM News  where title like '%"+title+"%' and time like'%"+time+"%' and kind ='"+kind+"'and cid='%"+cid+"%'";
				hql="SELECT * FROM News  where title like '%"+title+"%' and time like '%"+time+"%' and kind ='"+kind+"'and cid='%"+cid+"%' order by  time desc limit ?,?";
				
		
			}
			else if(title!="" && time=="" &&issuer!=""){
				System.out.println(3);
				hql2="SELECT * FROM News  where title like '%"+title+"%' and issuer ='"+issuer+"' and kind ='"+kind+"'and cid='%"+cid+"%'";
				hql="SELECT * FROM News  where title like '%"+title+"%' and issuer ='"+issuer+"' and kind ='"+kind+"'and cid='%"+cid+"%'  order by  time desc limit ?,?";
			
			}
			else if(title!="" && time=="" &&issuer==""){
				System.out.println(4);
				hql2="SELECT * FROM News  where title like '%"+title+"%' and kind ='"+kind+"'and cid='%"+cid+"%' ";
				hql="SELECT * FROM News  where title like '%"+title+"%' and kind ='"+kind+"'and cid='%"+cid+"%' order by  time desc limit ?,? ";
				
			}
			else if(title=="" && time!="" &&issuer!=""){
				System.out.println(5);
				hql2="SELECT * FROM News  where  issuer ='"+issuer+"'  and time like '%"+time+"%' and kind ='"+kind+"'and cid='%"+cid+"%'";
				hql="SELECT * FROM News  where  issuer ='"+issuer+"'  and time like '%"+time+"%'and kind ='"+kind+"' and cid='%"+cid+"%' order by  time desc limit ?,?";
			
			
			}
			else if(title=="" && time!="" &&issuer==""){
				System.out.println(6);
				hql2="SELECT * FROM News  where  time like '%"+time+"%' and kind ='"+kind+"'and cid='%"+cid+"%'";
				hql="SELECT * FROM News  where  time like '%"+time+"%' and kind ='"+kind+"'and cid='%"+cid+"%' order by  time desc limit ?,?";
			}
			else if(title=="" && time=="" &&issuer!=""){
				System.out.println(8);
				hql2="SELECT * FROM News  where  issuer ='"+issuer+"'and kind ='"+kind+"'and cid='%"+cid+"%'";
				hql="SELECT * FROM News  where  issuer ='"+issuer+"' and kind ='"+kind+"'and cid='%"+cid+"%' order by  time desc limit ?,?";

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
	//根据关键字，发布时间，发布人进行搜索 
		public List<News> NewsSreach(String title,String time,String issuer, int pageNum) {
			
				List<News> news=null;
				List<News> news2=null;
				String hql=null;
				String hql2=null;
				String kind="教育随笔";
				
					if(title!="" && time!="" &&issuer!=""){
						System.out.println(1);
						hql2="SELECT * FROM News  where title like '%"+title+"%'  and issuer ='"+issuer+"'  and time ='%"+time+"%' and kind ='"+kind+"'";
						hql="SELECT * FROM News  where title like '%"+title+"%'  and issuer ='"+issuer+"'  and time ='%"+time+"%'and kind ='"+kind+"' order by  time desc limit ?,? ";
					
					}
					else if(title!="" && time!=""&&issuer==""){
						System.out.println(2);
						hql2="SELECT * FROM News  where title like '%"+title+"%' and time like'%"+time+"%' and kind ='"+kind+"'";
						hql="SELECT * FROM News  where title like '%"+title+"%' and time like '%"+time+"%' and kind ='"+kind+"' order by  time desc limit ?,?";
						
				
					}
					else if(title!="" && time=="" &&issuer!=""){
						System.out.println(3);
						hql2="SELECT * FROM News  where title like '%"+title+"%' and issuer ='"+issuer+"' and kind ='"+kind+"'";
						hql="SELECT * FROM News  where title like '%"+title+"%' and issuer ='"+issuer+"' and kind ='"+kind+"'  order by  time desc limit ?,?";
					
					}
					else if(title!="" && time=="" &&issuer==""){
						System.out.println(4);
						hql2="SELECT * FROM News  where title like '%"+title+"%' and kind ='"+kind+"' ";
						hql="SELECT * FROM News  where title like '%"+title+"%' and kind ='"+kind+"' order by  time desc limit ?,? ";
						
					}
					else if(title=="" && time!="" &&issuer!=""){
						System.out.println(5);
						hql2="SELECT * FROM News  where  issuer ='"+issuer+"'  and time like '%"+time+"%' and kind ='"+kind+"'";
						hql="SELECT * FROM News  where  issuer ='"+issuer+"'  and time like '%"+time+"%'and kind ='"+kind+"'  order by  time desc limit ?,?";
					
					
					}
					else if(title=="" && time!="" &&issuer==""){
						System.out.println(6);
						hql2="SELECT * FROM News  where  time like '%"+time+"%' and kind ='"+kind+"'";
						hql="SELECT * FROM News  where  time like '%"+time+"%' and kind ='"+kind+"' order by  time desc limit ?,?";
					}
					else if(title=="" && time=="" &&issuer!=""){
						System.out.println(8);
						hql2="SELECT * FROM News  where  issuer ='"+issuer+"'and kind ='"+kind+"'";
						hql="SELECT * FROM News  where  issuer ='"+issuer+"' and kind ='"+kind+"' order by  time desc limit ?,?";
		
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

	
/*	@Test
	public void test3(){
		EductionDao eductionDao =new EductionDao();
		System.out.println(eductionDao.showAllSaveNews(1, "廖星建"));
	}*/
		//显示老师的草稿
		public List<News> showAllSaveNews(int pageNum ,String issuer) {
			String kind="教育随笔";
			String state="草稿";
			String sql="SELECT * FROM News where state=? and issuer=? and kind='"+kind+"'";
			Object [] p={state,issuer};
			List <News>news=selectAll(sql, p);
			Paging page=new Paging (pageNum, 10,news);   	
	      int a[]=page.getMaindate(pageNum, 10);
			int begin=a[0];
			int last=a[1];
			String sql2="SELECT * FROM News where state=? and issuer=? and kind='"+kind+"'order by  time desc  limit ?,? ";
			Object [] p1={state,issuer,begin,last};
			List <News>news2=selectAll(sql2, p1);
			System.out.println(news2);
			return news2;
		}
		
		

/*public int update(int idnews, String title,String message,String Url1,String Url2) {
	// TODO Auto-generated method stub

	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	 Date time=new Date();
	 String state="正常的教育记录";
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
}*/
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
//			news.setUrl3(rs.getString("url3"));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return news;
	}

}
