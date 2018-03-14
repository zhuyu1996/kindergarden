package cn.edu.cqupt.camphor_forest.kindergarten.dao;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.SiChanping;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Picture;

public interface PictureDao {
     //增加
	int insertpicture(Picture picture);
	//删除
	public void delepicture(String[] xid);
	//web显示
	Paging showPictureW(String pid,int pageNum);
	//App
	 List<SiChanping<Picture>> showPictureAp(String pid,int pageNum);
	 
	 int incrLike(String comId);
	 
	 List<Picture> ashowPictureAp(List<String> pid,int pageNum);
	 
	
}
