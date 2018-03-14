package JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
	public class JDBCUtils {
		private static String url="jdbc:mysql://localhost:3306/kindergarten";
		private static String usename="root";
		private static String password="mysql";
		private JDBCUtils()
		{}
			
			static{
				try {
				Class.forName("com.mysql.jdbc.Driver");
				}catch(Exception e){
					throw new ExceptionInInitializerError(e);
				}
				}
			public static Connection Getconnection() throws SQLException, ClassNotFoundException, IOException
			{	
				return DriverManager.getConnection(url,usename,password);
		
			}
		
		       public static void free(Connection ct,PreparedStatement st,ResultSet rs)
		       {
		    	   
		    	try {
				  if(st!=null)st.close();
		    	}catch(Exception e){
		    	e.printStackTrace();	
		    	}finally{
		    		try {
		    	  if(rs!=null)st.close();
		    	}catch(Exception e){
		    	e.printStackTrace();	
		    	}finally{
		    		try {
		    	  if(rs!=null)st.close();
		    	}catch(Exception e){
		    	e.printStackTrace();	}
		    	        }
		            }
	         }
	}