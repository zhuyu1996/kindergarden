package cn.edu.cqupt.camphor_forest.kindergarten.service;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.PictureContent;

public interface PictureContentService {
	 int delPicContent(String pid);
     
     int crePicContent(PictureContent picturecontent);

     //显示
     List<PictureContent> showppiccontentWe(int pageNum);
     
     List<PictureContent> showppiccontentAp(int pageNum,String cid);
     
     List<PictureContent> showppiccontentteacher(int pageNum,String cid);
     
     List<PictureContent> allshowppiccontentAp(int pageNum);

     
}
