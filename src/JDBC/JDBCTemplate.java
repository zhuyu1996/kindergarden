package JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public abstract class JDBCTemplate<T> {

	public T selectOne(String sql, Object[] params) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		try {
			
			con = JDBCUtils.Getconnection();
			ps = con.prepareStatement(sql);
		for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();
			T t = null;
			while (rs.next()) {
				t = rowMapper(rs);
			}
			
			System.out.println(t.toString());
			return t;
		} catch(Exception e) {
		     
		} finally {
			JDBCUtils.free(con, ps, rs);
		}
		return null;
	}
	public List<T> selectAll(String sql, Object[] params) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			con = JDBCUtils.Getconnection();
			ps = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();
			List<T> lists=new ArrayList<T>();
			T t = null;
			while (rs.next()) {
				t = rowMapper(rs);
				lists.add(t);
			}
			return lists;
		} catch(Exception e) {
		
		} finally {
			JDBCUtils.free(con, ps, rs);
		}
		return null;
	}
   public int update(String sql, Object[] params) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		int j=0;
		try {
			con = JDBCUtils.Getconnection();
			System.out.println("con");
			ps = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			j= ps.executeUpdate();
		} catch(Exception e) {
		
		} finally {
			JDBCUtils.free(con, ps, rs);
		}
		return j;
	}
   public int update1(String sql) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		int j=0;
		try {
			con = JDBCUtils.Getconnection();
			
			ps = con.prepareStatement(sql);
	
			j= ps.executeUpdate();
		
		} catch(Exception e) {
		
		} finally {
			JDBCUtils.free(con, ps, rs);
		}
		return j;
	}
	public String oneString(String sql, Object[] params) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			con =JDBCUtils.Getconnection();
			ps = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();
			
			String t = null;
			while (rs.next()) {
				t=rs.getString(1);
			}
			return t;
		} catch(Exception e) {
		     
		} finally {
			JDBCUtils.free(con, ps, rs);
		}
		return null;
	}
	public List<String> onestringlist(String sql, Object[] params) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			con =JDBCUtils.Getconnection();
			ps = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();
			
			List<String> lists=new ArrayList<String>();
			String t = null;
			while (rs.next()) {
				t =rs.getString(1);
				lists.add(t);
			}
			return lists;
		} catch(Exception e) {
		
		} finally {
			JDBCUtils.free(con, ps, rs);
		}
		return null;
	}

public int oneInt(String sql, Object[] params) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			con =JDBCUtils.Getconnection();
			ps = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();
			int t =0;
			while (rs.next()) {
				t=rs.getInt(1);
			}
			return t;
		} catch(Exception e) {
		     
		} finally {
			JDBCUtils.free(con, ps, rs);
		}
		return 0;
	}

public int intone(String sql) {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null; 
	
	try {
		con =JDBCUtils.Getconnection();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		int t =0;
		while (rs.next()) {
			t =	rs.getInt(1);
		}
		return t;
	} catch(Exception e) {
	     
	} finally {
		JDBCUtils.free(con, ps, rs);
	}
	return 0;
}
	protected abstract T rowMapper(ResultSet rs);
}

