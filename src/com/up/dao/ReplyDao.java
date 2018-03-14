package com.up.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.up.entity.Comment;
import com.up.entity.Reply;
import com.up.entity.Reply;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;

public class ReplyDao extends JDBCTemplates<Reply> {
	public int  Replyadd(String a ,String b,String message,int idcomment){
		String sql="INSERT INTO reply (a,b,message,idcomment,time)VALUES(?,?,?,?,?)";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Object[] params={a,b,message,idcomment,sdf.format(new Date())};
		
	  return update(sql,params);
		
	}
	@Test
	public void test(){
		ReplyDao r=new ReplyDao();
//r.Replyadd("z", "C", "zzzhzu", 1);
//r.Replyadd("z", "C", "zzzhzu", 1);
		List<Reply> re=r.showAllReply(1,1);
		System.out.println(re.toString());
//r.deleteReply(2);
	}
	public int deleteReply(int idreply){
		String sql="delete from reply where idreply=? ";
		Object[] p={idreply};
		return	update(sql,p);
	}
	public List<Reply> showAllReply(int pageNum,int idcomment){
		String sql="select * from reply where idcomment='"+idcomment+"'";
		List<Reply> replys=selectByAll(sql);
		Paging page=new Paging (pageNum, 10,replys);   	
	    int a[]=page.getMaindate(pageNum, 10);
			int begin=a[0];
			int last=a[1];
			String sql2="select * from reply where idcomment='"+idcomment+"' limit ?,? ";
			Object[] b={begin,last};
			List<Reply>reply2=selectAll(sql2, b);
			for(int i=0;i<reply2.size();i++){
			reply2.get(i).setTotalpage(page.getTotalPage());}
//			System.out.println(reply2);
		return reply2;
		
	}
	@Override
	protected Reply rowMapper(ResultSet rs) {
		// TODO Auto-generated method stub
		Reply reply=new Reply();
		try {
			reply.setIdcomment(rs.getInt("idcomment"));
			reply.setIdreply(rs.getInt("idreply"));
			reply.setA(rs.getString("a"));
			reply.setB(rs.getString("b"));
			reply.setMessage(rs.getString("message"));
			reply.setTime(rs.getString("time"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return reply;
	}

}
