package cn.edu.cqupt.camphor_forest.kindergarten.service.impl;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl.PictureDaoImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.Pictureservice;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.SiChanping;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Picture;

public class PictureserviceImpl implements Pictureservice{
	PictureDaoImpl picturedaoimpl=new PictureDaoImpl();
	
	@Override
	public int createpicture(Picture picture) {
		return picturedaoimpl.insertpicture(picture);
	}

	@Override
	public void delincepicture(String[] xid) {
		picturedaoimpl.delepicture(xid);
	}

	@Override
	public Paging showPicAllWeb(String pid,int pageNum) {
		return picturedaoimpl.showPictureW(pid, pageNum);
	}

	@Override
	public  List<SiChanping<Picture>> showPicAllApp(String pid,int pageNum) {
		return picturedaoimpl.showPictureAp(pid, pageNum);
	}

	@Override
	public int createLike(String comId) {
		return picturedaoimpl.incrLike(comId);
	}

	@Override
	public List<Picture> ashowPictureAp(List<String> pid, int pageNum) {
		// TODO Auto-generated method stub
		return picturedaoimpl.ashowPictureAp(pid, pageNum);
	}

}
