package cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.CollectMovieDao;
import cn.edu.cqupt.camphor_forest.kindergarten.dao.CollectPhotoDao;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectMovie;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectPhoto;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.MovieContent;

public class CollectPhotoDaoImpl extends JDBCTemplates<CollectPhoto> implements CollectPhotoDao{

	@Override
	public int insertcollecphoto(CollectPhoto collectPhoto){
		 String sql="INSERT INTO collectphoto (cp_id,cp_userid,cp_face,cp_name)VALUES(?,?,?,?)";
		String face="http://119.29.225.57:8080/photo/9/9/b1cca2b3e791469eb4fab53f1a025200.png";
	     Object[] param={UUID.randomUUID().toString().replace("-", ""),collectPhoto.getCpuserid(),face,"您的个人收藏相册"};
		 return update(sql,param);
	  
	}

	@Override
	protected CollectPhoto rowMapper(ResultSet rs) {
		CollectPhoto collectPhoto=new CollectPhoto();
		try {
			collectPhoto.setCpid(rs.getString("cp_id"));
			collectPhoto.setCpuserid(rs.getString("cp_userid"));
			collectPhoto.setCpface(rs.getString("cp_face"));
			collectPhoto.setCpname(rs.getString("cp_name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return collectPhoto;
	}

	@Override
	public CollectPhoto showcollectpicontentAp( String userid) {
		String sql="SELECT*FROM collectphoto WHERE cp_userid=?";
		Object[] param={userid};
		return selectOne(sql,param);
	}


}
