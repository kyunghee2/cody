package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	
	public static Connection getConnection() {
		
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@70.12.115.75:1521:xe";
		String user ="cody";
		String pw="cody";
		
		Connection con=null;
		try {
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
