package cn.edu.cqupt.camphor_forest.kindergarten.dao;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.PictureContent;

public interface PictureContentDao {
     
	 int deletePicContent(String pid);
     
     int createPicContent(PictureContent picturecontent);
     //显示
     List<PictureContent> showContentWe(int pageNum);
     
     List<PictureContent> showContentAp(int pageNum,String cid);
     
     List<PictureContent> showContentteacher(int pageNum,String cid);
     
     List<PictureContent> allshowContentAp(int pageNum);
}
