package cn.edu.cqupt.camphor_forest.kindergarten.service;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.SiChanping;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Picture;

public interface Pictureservice {
    //增加
	int createpicture(Picture picture);
	//删除
	void delincepicture(String[] xid); 
	//显示
	Paging showPicAllWeb(String pid,int pageNum);
	//显示
	 List<SiChanping<Picture>> showPicAllApp(String pid,int pageNum);
	 
	int createLike(String comId);
	
	 List<Picture> ashowPictureAp(List<String> pid,int pageNum);
}
