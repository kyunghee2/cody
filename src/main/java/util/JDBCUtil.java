package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	
	public static Connection getConnection() {
		
//		String driver="oracle.jdbc.OracleDriver";
//		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
//		String user ="scott";
//		String pw="TIGER";
		
		Connection con=null;
		try {
			Properties p=new Properties();
			p.load(new FileInputStream("c://lib/dbinfo.txt"));
			String driver=p.getProperty("driver");
			String url=p.getProperty("url");
			String user =p.getProperty("user");
			String pw=p.getProperty("pw");
			
			Class.forName(driver);
			con =DriverManager.getConnection(url, user, pw);
			
		}catch(ClassNotFoundException e) {
			System.out.println("jdbc driver 확인 요망");
			e.getStackTrace();
		}catch(SQLException e) {			
			e.getStackTrace();
		}catch(Exception e) {
			e.getStackTrace();
		}
		return con;
	}
	public static void close(Connection con, Statement st,ResultSet rs) {
		try {
			if(rs!=null ) rs.close();
			if(st!=null) st.close();			
			if(con!=null ) con.close(); 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
