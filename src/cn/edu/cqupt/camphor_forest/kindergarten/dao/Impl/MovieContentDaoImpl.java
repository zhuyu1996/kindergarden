package cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.LessonDao;
import cn.edu.cqupt.camphor_forest.kindergarten.dao.MovieContentDao;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Lesson;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.MovieContent;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.PictureContent;

public class MovieContentDaoImpl extends JDBCTemplates<MovieContent> implements MovieContentDao{

	@Override
	public int insertMovieContent(MovieContent moviecontent) {
	    String sql="INSERT INTO moviecontent (mc_id,mc_people,mc_time,mc_decri,mc_class)VALUES(?,?,?,?,?)";
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Object[] params={UUID.randomUUID().toString().replace("-", ""),moviecontent.getMcpeople(),sdf.format(new Date()),moviecontent.getMccontent(),moviecontent.getMcclassid()};
		return update(sql,params);
	}

	@Override
	public void deletMovieContent(String[] mcid) {
		String sql1="DELETE FROM moviecontent WHERE mc_id=?";
		System.out.println(mcid);
		batchupdate(sql1,mcid);
	}

	@Override
	public int updateMovieContent(MovieContent moviecontent) {
		String sql="UPDATE moviecontent SET mc_people=?,mc_time=?,mc_decri=?,mc_class=? where mc_id=?";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    Object[] params={moviecontent.getMcpeople(),sdf.format(new Date()),moviecontent.getMccontent(),moviecontent.getMcclassid(),moviecontent.getMcid()};
		return update(sql,params);
	}

	@Override
	public Paging selectMCByclass(String classid,int pageNum) {
		int pagesize=10;
		String sql="SELECT*FROM moviecontent where mc_class=?";
		Object[] param={classid};
		List<MovieContent> movieconlis=selectAll(sql,param);;
		Paging page=new Paging(pageNum,pagesize,movieconlis);
		String sql2="SELECT*FROM moviecontent where mc_class=? ORDER BY mc_time DESC limit ?,?";
		int a[]=page.getMaindate(pageNum, pagesize);
		int pa2=a[0];
		int pa3=a[1];
		Object[] param2={classid,pa2,pa3};
		List<MovieContent> movieconlist=selectAll(sql2,param2);
		page.getResult(movieconlist, page);
		return page;
	}

	@Override
	public Paging selectMCByclassApp(String classid,int pageNum) {
		int pagesize=10;
		String b[]=classid.split("");
		int siz=b.length;
		String cname="";
		if(siz==4){
			cname=b[2]+b[3];
		}
		if(siz==3){
			cname=b[2];
		}
		String sql7="SELECT co_flag FROM classone where co_name=?";
		String[] param7={b[1]};
        int ccflag=oneInt(sql7,param7);
		String sql1="SELECT c_id FROM class where c_name=? and c_flag=?";
		Object[] param={cname,ccflag};
        String ccid=oneString(sql1,param);
		String sql2="SELECT*FROM moviecontent where mc_class=?";
		Object[] param2={ccid};
		List<MovieContent> movieconlis=selectAll(sql2,param2);;
		Paging page=new Paging(pageNum,pagesize,movieconlis);
		String sql3="SELECT*FROM moviecontent where mc_class=? ORDER BY mc_time DESC limit ?,?";
		int a[]=page.getMaindate(pageNum, pagesize);
		int pa2=a[0];
		int pa3=a[1];
		Object[] param3={ccid,pa2,pa3};
		List<MovieContent> movieconlist=selectAll(sql3,param3);
		page.getResult(movieconlist, page);
		return page;
	} 
	
	@Override
	public Paging selectMCByAdmi(int pageNum) {
		int pagesize=10;
		String sql="SELECT*FROM moviecontent where mc_class=1";
		List<MovieContent> movieconlis=selectByAll(sql);
		Paging page=new Paging(pageNum,pagesize,movieconlis);
		String sql2="SELECT * FROM moviecontent where mc_class=1 ORDER BY mc_time DESC limit ?,?";
		int a[]=page.getMaindate(pageNum, pagesize);
		int pa2=a[0];
		int pa3=a[1];
		Object[] param2={pa2,pa3};
		List<MovieContent> movieconlist=selectAll(sql2,param2);
		page.getResult(movieconlist, page);
		return page;
	}

	@Override
	protected MovieContent rowMapper(ResultSet rs) {
		MovieContent moviecontent=new MovieContent();
		try {
			moviecontent.setMcid(rs.getString("mc_id"));
			moviecontent.setMcpeople(rs.getString("mc_people"));
			moviecontent.setMctime(rs.getString("mc_time"));
			moviecontent.setMccontent(rs.getString("mc_decri"));
			moviecontent.setMcclassid(rs.getString("mc_class"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return moviecontent;
	}

	
	public List<MovieContent> selectALLMC(String classid,int pageNum) {
		int pagesize=10;
		String b[]=classid.split("");
		String cname=b[1]+b[2];
		System.out.println("z[0]="+b[0]+cname);
		String sql7="SELECT co_flag FROM classone where co_name=?";
		String[] param7={b[0]};
        int ccflag=oneInt(sql7,param7);
		String sql1="SELECT c_id FROM class where c_name=? and c_flag=?";
		Object[] param={cname,ccflag};
        String ccid=oneString(sql1,param);
		String sql2="SELECT*FROM moviecontent where mc_class=?";
		Object[] param2={ccid};
		return selectAll(sql2,param2);
		
	}
}
