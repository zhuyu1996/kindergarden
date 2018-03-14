package cn.edu.cqupt.camphor_forest.kindergarten.service.impl;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl.LessonDaoImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.Lessonservice;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Lesson;

public class Lessonserviceimpl implements Lessonservice{
    private LessonDaoImpl lessondaoimpl=new LessonDaoImpl();
    
	@Override
	public int updLesson(Lesson lesson) {
		return lessondaoimpl.updateLesson(lesson);
	}

	@Override
	public Lesson selLesson(Lesson lesson) {
		return lessondaoimpl.selectLesson(lesson);
	}
	@Override
	public List<Lesson> selAppLesson(String cid) {
		return lessondaoimpl.selectAppLesson(cid);
	}
	
	@Override
	public int insLesson(Lesson lesson) {
       return lessondaoimpl.insertLesson(lesson);
	}
	

	@Override
	public Lesson selTeacherLesson(Lesson lesson) {
		return lessondaoimpl.selectTeacherLesson(lesson);
	}
	
	@Override
	public int insLessonteacher(Lesson lesson) {
		return lessondaoimpl.insertLessonTeacher(lesson);
	}

	@Override
	public int delLessonByclass(String classid) {
		// TODO Auto-generated method stub
		return lessondaoimpl.deleteLessonByClass(classid);
	}
	
}
