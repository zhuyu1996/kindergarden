package cn.edu.cqupt.camphor_forest.kindergarten.service;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.Lesson;

public interface Lessonservice {
      int updLesson(Lesson lesson);
      
      Lesson selLesson(Lesson lesson);
      
      List<Lesson> selAppLesson(String cid);
      
      Lesson selTeacherLesson(Lesson lesson);
      
      int insLesson(Lesson lesson);
      
      int insLessonteacher(Lesson lesson);
      
      int delLessonByclass(String classid);
}
