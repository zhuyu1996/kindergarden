package cn.edu.cqupt.camphor_forest.kindergarten.dao;


import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.Lesson;

public interface LessonDao {

	//查
	Lesson selectLesson(Lesson lesson);
	
    List<Lesson> selectAppLesson(String cid);
	//改
	int updateLesson(Lesson lesson);
	//增
	int insertLesson(Lesson lesson);
	
	   Lesson selectTeacherLesson(Lesson lesson);
	   
		int insertLessonTeacher(Lesson lesson);
		
		int deleteLessonByClass(String className);
}
