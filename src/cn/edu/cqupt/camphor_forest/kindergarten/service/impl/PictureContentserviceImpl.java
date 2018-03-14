package cn.edu.cqupt.camphor_forest.kindergarten.service.impl;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl.PicContentDaoImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.PictureContentService;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.PictureContent;

public class PictureContentserviceImpl implements PictureContentService{
    private PicContentDaoImpl picturecontentdaoimpl=new PicContentDaoImpl();
	@Override
	public int delPicContent(String pid) {
		return picturecontentdaoimpl.deletePicContent(pid);
	}

	@Override
	public int crePicContent(PictureContent picturecontent) {
		return picturecontentdaoimpl.createPicContent(picturecontent);
	}

	@Override
	public List<PictureContent> showppiccontentWe(int pageNum) {
		return picturecontentdaoimpl.showContentWe(pageNum);
	}


	@Override
	public List<PictureContent> showppiccontentAp(int pageNum,String cid) {
		// TODO Auto-generated method stub
		return picturecontentdaoimpl.showContentAp(pageNum,cid);
	}
	
	@Override
	public List<PictureContent> allshowppiccontentAp(int pageNum) {
		return picturecontentdaoimpl.allshowContentAp(pageNum);
	}
	
	@Override
	public List<PictureContent> showppiccontentteacher(int pageNum,String cid) {
		return picturecontentdaoimpl.showContentteacher(pageNum,cid);
	}
}
