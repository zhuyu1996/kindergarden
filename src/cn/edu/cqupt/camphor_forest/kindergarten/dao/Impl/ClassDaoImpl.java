package cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.ClassDao;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Classs;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Student;

public class ClassDaoImpl extends JDBCTemplates<Classs> implements ClassDao {
    @Override
	public List<Classs> showClass() {
   
    	String sql="select class.c_id,classone.co_name,class.c_name,class.c_taecher from classone,class where co_flag=c_flag and c_flag>0";
		List<Classs> classs=selectByAll(sql);
	
		for(int i=0;i<classs.size();i++)
		{ 
			String sqls="select count(*) from student where c_id=?;";
		   Object[] param={classs.get(i).getcId()};
		   int count=oneInt(sqls,param);
		   classs.get(i).setsNumber(count);
		}
        Classs cla=new Classs();
        cla.setcId("1248448764578");
        cla.setcName("已转出学生");
        cla.settTeacher("无，无，无");
        String sql2="select count(*) from studentonetime where c_id=?;";
        Object[] param2={"已转出"};
        int count1=oneInt(sql2,param2);
        cla.setsNumber(count1);
        deleteclass("已转出");
        
        Classs clas=new Classs();
        clas.setcId("9817457298488");
        clas.setcName("已毕业学生");
        clas.settTeacher("无，无，无");
        String sql4="select c_id from class where c_name=?";
        String sql3="select count(*) from studentonetime where c_id=?;";
        Object[] param3={"已毕业"};
        int count2=oneInt(sql3,param3);
        clas.setsNumber(count2);
        deleteclass("已毕业");
        
        classs.add(cla);
        classs.add(clas);
		return classs;
	}

	@Override
	public int upclass() {
		
//		update(sql2,parame);
//		//把毕业学生存另外一表,pass taimafan
//		String sql3="select c_id where c_name=?";
//		Object[] param3={"已毕业"};
//		List<String> list=onestringlist(sql3,param3);
//		for(int j=0;j<list.size();j++){
//			String sql5="select*from student where c_id=?";
//			Object[] param5={list.get(j).toString()};
//			
//			String sql4="INSERT INTO student (s_id,s_name,s_acount,s_password,s_sex,s_identify_id,c_id)VALUES(?,?,?,?,?,?,?)";
//		//	Object[] param4={UUID.randomUUID().toString().replace("-",""),student.getsName(),student.getsAcount(),"123456",student.getsSex(),student.getsIdentifyId(),t};
//			update(sql4,param4);
//			
//		}
//		String sql3="select c_id from class where c_flag=3";
//		List<String> list=onestringlistt(sql3);
//		for(int i=0;i<list.size();i++){
//			String sql4="select*from student where c_id=?";
//			Object[] param4={list.get(i)};
//		    List<Student> studentlist=selectAll(sql4,param4);
//			
//		}
		String sql="update class set c_flag=c_flag+1 where c_flag<4 and c_flag>0";
		update1(sql);
		//flag+1
		String sql2="update class set c_name=?,c_taecher=? where c_flag>3";
		Object[] parame={"已毕业","无，无，无"};
		update(sql2,parame);
		//flag>=4已毕业
//		String sql3="select c_id from class where c_name=?";
//		Object[] param3={"已毕业"};
//		List<String> cidlist=onestringlist(sql3,param3);
//		for(int i=0;i<cidlist.size();i++){
//		String sql4="update teacher set c_id=? where c_id=?";
//		Object[] param4={"无",cidlist.get(i)};
//		update(sql4,param4);}
		return 1;//成功
	}

	@Override
	public Classs searchclassid(String search) {
		
		String a[]=search.split("");//大小班加名用，号隔开
		String sql2="select co_flag from classone where co_name=?";
		String b=a[1];
		Object[] param2={b};
		int c=oneInt(sql2,param2);
		String sql1="select c_id from class where c_name=? and c_flag=?";
		int siz=a.length;
		String cname="";
		if(siz==4){
			cname=a[2]+a[3];
		}
		if(siz==3){
			cname=a[2];
		}
		Object[] param1={cname,c};
		String cid=oneString(sql1,param1);

		String sql="select class.c_id,classone.co_name,class.c_name,class.c_taecher from classone,class where co_flag=c_flag and c_id=?";
		Object[] params={cid};
		Classs classs=selectOne(sql, params);
		String sqls="select(count(*)) from student where c_id=？";
		Object[] param={search};
		int count=oneInt(sqls,param);
		classs.setsNumber(count);
		return classs;
	}
	@Override
	public Classs searchclassidtea(String search) {
		String sql="select class.c_id,classone.co_name,class.c_name,class.c_taecher from classone,class where co_flag=c_flag and c_taecher like ?";
		Object[] params={"%"+search+"%"};
		Classs classs=selectOne(sql, params);
		if(classs==null){ return null;}
		String sqls="select(count(*))from student where c_id=?;";
		Object[] param={classs.getcName().toString()};
		int count=oneInt(sqls,param);
		classs.setsNumber(count);
		
//		String sqls="select(count(*))from student where c_id=？";
//		Object[] param={ccid};
//		int count=oneInt(sqls,param);
//		classs.setsNumber(count);
		return classs;
	}
	@Override
	public int createclass(Classs classs) {

		String s[]=classs.getcName().split(",");
		String sql1="select co_flag from classone where co_name=?";
		String b=s[0];
		Object[] param={b};
		int a=oneInt(sql1,param);
		String sql="INSERT INTO class(c_id,c_name,c_taecher,c_flag)VALUES(?,?,?,?)";
		Object[] params={UUID.randomUUID().toString().replace("-",""),s[1],classs.gettTeacher(),a};
		 update(sql,params);
		String teacher[]=classs.gettTeacher().split(",");
		for(int i=0;i<teacher.length;i++)
		{
			String sql6="select t_id from teacher where t_name=?";
			Object[] param6={teacher[i]};
			String tidlist=oneString(sql6,param6);
			System.out.println("班级修改老师这里"+tidlist);
			String z[]=classs.getcName().split(",");
			String sql7="SELECT co_flag FROM classone where co_name=?";
			System.out.println(classs.getcName());
			String[] param7={z[0]};
	        int ccflag=oneInt(sql7,param7);
			String sql8="SELECT c_id FROM class where c_name=? and c_flag=?";
			Object[] param8={z[1],ccflag};
	        String ccid=oneString(sql8,param8);
	        
			String sql9="UPDATE teacher SET c_id=? WHERE t_id=?";
			System.out.println(ccid);
			Object[] param9={ccid,tidlist};
			update(sql9,param9);
		}
            return 1;
	}

	public int updateclass(Classs classs) {
		System.out.println("lailed1");
		String s[]=classs.getcName().split(",");
		String sql1="select co_flag from classone where co_name=?";
		String b=s[0];
		Object[] param={b};
		int a=oneInt(sql1,param);
		String sql="UPDATE class set c_name=?,c_taecher=?,c_flag=? where c_id=?";
		Object[] params={s[1],classs.gettTeacher(),a,classs.getcId()};
		return update(sql,params);
	}

	
	@Override
	public int deleteclass(String uuid) {
		String sql="DELETE FROM class WHERE c_id=?";
		Object[] param={uuid};
		return update(sql,param);
	}

	@Override
	protected Classs rowMapper(ResultSet rs) {
		Classs classs=new Classs();
		try {
			classs.setcId(rs.getString("c_id"));
			String spell=rs.getString("co_name")+rs.getString("c_name");
			//SELECT * FROM class,student where class.c_name=student.c_id;
//			select class.c_id,classone.co_name,class.c_name,class.c_taecher from classone,class where co_flag=c_flag;
			classs.setcName(spell);
			classs.settTeacher(rs.getString("c_taecher"));
//			String sql="select(count(*)) from student where c_id=？;";
			classs.setsNumber(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return classs;
	}

	@Override
	public String searchClassName() {
		String sql="select class.c_id,classone.co_name,class.c_name,class.c_taecher from classone,class where co_flag=c_flag and c_flag>0 and c_flag<4";
		List<Classs> classs=selectByAll(sql);
		String a="";
		for(int i=0;i<classs.size();i++)
		{ 
		   a=a+classs.get(i).getcName().toString();
		}
		return a;
	}
    
	@Override
	public List<String> showClassname() {
		String sql="select c_id from class ";
		List<String> cidlist=onestringlistt(sql);
		System.out.println(cidlist);
		List<String> namelist=new ArrayList();
		for(int i=0; i<cidlist.size();i++)
		{   
			String sql1="SELECT c_flag FROM class where c_id=?";
			Object[] param={cidlist.get(i).toString()};
			int t=oneInt(sql1,param);
			String sql3="SELECT c_name FROM class where c_id=?";
			Object[] param3={cidlist.get(i).toString()};
			String cname=oneString(sql3,param3);		
			String sql2="SELECT co_name FROM classone where co_flag=?";
			Object[] param2={t};
			String coname=oneString(sql2,param2);
			String cconame=coname+cname;
			namelist.add(cconame);
	
		}
		System.out.println("所有班级"+namelist);
		return namelist;
	}

	public String showNameById(String classid)
	{
		String sql1="SELECT c_flag FROM class where c_id=?";
		Object[] param={classid};
		int t=oneInt(sql1,param);
		String sql3="SELECT c_name FROM class where c_id=?";
		Object[] param3={classid};
		String cname=oneString(sql3,param3);		
		String sql2="SELECT co_name FROM classone where co_flag=?";
		Object[] param2={t};
		String coname=oneString(sql2,param2);
		String cconame=coname+cname;
		return cconame;
	}
	
	
	
	@Override
	public boolean ifexit(String cname) {
		boolean result=false;
		String s[]=cname.split(",");
		String sql1="select c_flag from class where c_name=?";
		Object[] param1={s[1]};
		List<String> flagc=onestringlist(sql1,param1);
		if(flagc.isEmpty()){
			return result;
		}
		for(int i=0;i<flagc.size();i++){
			
			String sql2="select co_flag from classone where co_name=?";
			String b=s[0];
			System.out.println("s[0]"+s[0]);
			Object[] param2={b};
			int a=oneInt(sql2,param2);
			int c=Integer.parseInt(flagc.get(i));
		
			if(c==a){
				result=true;
		
			}
			
		}
		
		
		return result;
	}


	
}
