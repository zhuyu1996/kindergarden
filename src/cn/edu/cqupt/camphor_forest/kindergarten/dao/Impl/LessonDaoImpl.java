package cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.LessonDao;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Lesson;

public class LessonDaoImpl extends JDBCTemplates<Lesson> implements LessonDao{

//	@Override
//	public Lesson selectLesson(Lesson lesson) {
//		String sql="select*from lesson where c_Name=? and l_Week=?";
//		Object[] params={lesson.getcName(),lesson.getlWeek()};
//		return selectOne(sql,params);
//	}
	@Override
	public List<Lesson> selectAppLesson(String cid) {
		String sql="select * from lesson where c_id=? ORDER BY l_week DESC";
		Object[] params={cid};
		return selectAll(sql,params);
	}
	@Override
	public int updateLesson(Lesson lesson) {
		String sql="update lesson set l_mon=?,l_tue=?,l_wed=?,l_thur=?,l_fri=?,work_important=?,shuxing=?,l_sat=?,l_sun=? where l_id=?";
		Object[] params={lesson.getlMon(),lesson.getlTue(),lesson.getlWed(),lesson.getlThu(),lesson.getLfri(),lesson.getWorkimportant(),lesson.getShuxin(),lesson.getLsat(),lesson.getLsun(),lesson.getlId()};
		return update(sql,params);
	}
	@Override
	public int insertLesson(Lesson lesson) {
		String sql="INSERT INTO lesson (l_id,l_week,l_mon,l_tue,l_wed,l_thur,l_fri,work_important,shuxing,l_sat,l_sun,c_id)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={UUID.randomUUID().toString().replace("-",""),lesson.getlWeek(),lesson.getlMon(),lesson.getlTue(),lesson.getlWed(),lesson.getlThu(),lesson.getLfri(),lesson.getWorkimportant(),lesson.getShuxin(),lesson.getLsat(),lesson.getLsun(),lesson.getcName()};
		return update(sql,params);
	}
	@Override
	protected Lesson rowMapper(ResultSet rs) {
		Lesson lesson=new Lesson();
		try {
			lesson.setcName(rs.getString("c_id"));
			lesson.setlWeek(rs.getString("l_week"));
			lesson.setlMon(rs.getString("l_mon"));
			lesson.setlTue(rs.getString("l_tue"));
			lesson.setlWed(rs.getString("l_wed"));
			lesson.setlThu(rs.getString("l_thur"));
			lesson.setLfri(rs.getString("l_fri"));
			lesson.setlId(rs.getString("l_id"));	
			lesson.setWorkimportant(rs.getString("work_important"));
			lesson.setShuxin(rs.getString("shuxing"));
			lesson.setLsat(rs.getString("l_sat"));
			lesson.setLsun(rs.getString("l_sun"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lesson;
	}
	@Override
	public Lesson selectLesson(Lesson lesson) {
		String sql="select*from lesson where c_id=? and l_Week=?";
		Object[] param={lesson.getcName(),lesson.getlWeek()};
		return selectOne(sql,param);
	}

	@Override
	public Lesson selectTeacherLesson(Lesson lesson) {
		//班级Id转班级名
		String sql1="SELECT c_flag FROM class where c_id=?";
		Object[] param1={lesson.getcName()};
		int t=oneInt(sql1,param1);
		String sql3="SELECT c_name FROM class where c_id=?";
		Object[] param3={lesson.getcName()};
		String cname=oneString(sql3,param3);
		String sql2="SELECT co_name FROM classone where co_flag=? ";
		Object[] param2={t};
		String coname=oneString(sql2,param2);
		String cconame=coname+cname;
		System.out.println(cconame);
		String sql="select*from lesson where c_id=? and l_Week=?";
		Object[] param={cconame,lesson.getlWeek()};
		return selectOne(sql,param);
	}
	@Override
	public int insertLessonTeacher(Lesson lesson) {
		String sql1="SELECT c_flag FROM class where c_id=?";
		Object[] param={lesson.getcName()};
		int t=oneInt(sql1,param);
		String sql3="SELECT c_name FROM class where c_id=?";
		Object[] param3={lesson.getcName()};
		String cname=oneString(sql3,param3);
		String sql2="SELECT co_name FROM classone where co_flag=? ";
		Object[] param2={t};
		String coname=oneString(sql2,param2);
		String cconame=coname+cname;
		String sql="INSERT INTO lesson (l_id,l_week,l_mon,l_tue,l_wed,l_thur,l_fri,work_important,shuxing,l_sat,l_sun,c_id)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params={UUID.randomUUID().toString().replace("-",""),lesson.getlWeek(),lesson.getlMon(),lesson.getlTue(),lesson.getlWed(),lesson.getlThu(),lesson.getLfri(),lesson.getWorkimportant(),lesson.getShuxin(),lesson.getLsat(),lesson.getLsun(),cconame};
		return update(sql,params);
	}
	@Override
	public int deleteLessonByClass(String className) {
		String sql="DELETE FROM lesson WHERE c_id=?";
		Object[] param={className};
		return update(sql,param);
	}


}
