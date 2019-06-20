package spring.biz.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import spring.biz.user.vo.UserVO;

@Component("spring")
public class UserDAO_Spring implements UserDAO{

	@Autowired
	private JdbcTemplate template;
	
	public UserDAO_Spring() {
		//System.out.println("UserDAO_Spring 호출");
	}
	public UserVO login(String id, String pw) {
		System.out.println("JdbcTemplate: "+template);		
		String sql = "select * from userinfo where userid=? and userpwd = ?";
		
		UserVO user = null;
		try {
			
		user = template.queryForObject(sql,
								new Object[] {id,pw},
								new UserRowMapper()
								);
		
		}catch(Exception e) {
			e.getStackTrace();
		}
						
		return user;
	}

	public int addUser(UserVO user) {
		String sql = "insert into userinfo (userid, username, userpwd, email, phone,address) values (?, ?, ?, ?, ?, ?)";
		int row=0;
		try {
			
			row = template.update(sql,new Object[] {user.getUserid(),
											user.getName(),
											user.getUserpwd(),
											user.getEmail(),
											user.getPhone(),
											user.getAddress()});
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		return row;
	}

	public UserVO getUser(String uid) {
		String sql = "select * from userinfo where userid = ?";
		
		UserVO user=null;
		try {
			
		user = template.queryForObject(sql,
				new Object[] {uid},
				new UserRowMapper()
				);	
			
		}catch(Exception e) {	
			e.getStackTrace();
		}
		return user;
	}

	public List<UserVO> getUserList() {
		String sql = "select * from userinfo ";
		return template.query(sql, new UserRowMapper());			
	}

	public int updateUser(UserVO user) {
		String sql ="update userinfo set email=?,phone=?,address=? where userid =?";
		int row=0;
		try {
			
		row=template.update(sql, new Object[] {user.getEmail(),
										       user.getPhone(),
										       user.getAddress(),
										       user.getUserid()});
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		return row;
	}

	public int removeUser(String uid) {
		String sql = "delete from userinfo where  userid  = ? ";
		int row=0;
		try {
			row=template.update(sql, new Object[] {uid});	
			
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		return row;
	}

	public List<UserVO> searchUser(String condition, String keyword) {
		String sql = "select * from userinfo where "+condition +" like '%'||?||'%'";
		return template.query(sql,
							new Object[] {keyword},
							new UserRowMapper());		
	}

}

//결과값 핸들링, VO값 매핑 추상화
class UserRowMapper implements RowMapper<UserVO>{

	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO user=new UserVO();
		user.setUserid(rs.getString("userid"));
		user.setName(rs.getString("name"));
		user.setUserpwd(rs.getString("userpwd"));
		user.setPhone(rs.getString("phone"));
		user.setEmail(rs.getString("email"));
		user.setAddress(rs.getString("address"));
		return user;
	}
	
}