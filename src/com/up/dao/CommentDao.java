package com.up.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.up.entity.Comment;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;

public class CommentDao extends JDBCTemplates<Comment>{
public int  Commentadd(String name ,String message,int idnews){
	String sql="INSERT INTO comment (name,message,idnews,time)VALUES(?,?,?,?)";
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	Object[] params={name,message,idnews,sdf.format(new Date())};
	
  return update(sql,params);
	
}
@Test
public void test(){
	CommentDao comment=new CommentDao();
//	comment.Commentadd("zhuyu", "wozaiceshi", 144);
	
//	comment.deletecomment(2);
	List<Comment>a=comment.showAllComment(1,158);
	System.out.println(a.toString());
	
}
public int deletecomment(int idcomment){
	String sql="delete from comment where idcomment=? ";
	Object[] p={idcomment};
	update(sql,p);
	String sql2="delete from reply where idcomment=?";
	return	update(sql2,p);
}

public List<Comment> showAllComment(int pageNum ,int idnews){
	String sql="select * from comment where idnews='"+idnews+"'";
	List<Comment> comments=selectByAll(sql);
	Paging page=new Paging (pageNum, 10,comments);   	
    int a[]=page.getMaindate(pageNum, 10);
		int begin=a[0];
		int last=a[1];
		String sql2="select * from comment where idnews='"+idnews+"' limit ?,? ";
		Object[] b={begin,last};
		List<Comment>comment2=selectAll(sql2, b);
		for(int i=0;i<comment2.size();i++){
		comment2.get(i).setTotalpage(page.getTotalPage());}
	return comment2;
	
}
public Comment select(String name,int idnews){
	String sql="select * from comment where name=? and idnews='"+idnews+"'";
	Object[] p={name};
Comment a=selectOne(sql, p);
	return a;
	
}
@Override
protected Comment rowMapper(ResultSet rs) {
	// TODO Auto-generated method stub
	Comment comment=new Comment();
	try {
		comment.setIdcomment(rs.getInt("idcomment"));
		comment.setIdnews(rs.getInt("idnews"));
		comment.setMessage(rs.getString("message"));
		comment.setName(rs.getString("name"));
		comment.setTime(rs.getString("time"));
	} catch (Exception e) {
		// TODO: handle exception
	}
	return comment;
	
		
}
}
