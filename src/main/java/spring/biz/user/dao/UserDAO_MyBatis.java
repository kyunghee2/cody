package spring.biz.user.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.biz.user.vo.UserVO;

@Component("mybatis")
public class UserDAO_MyBatis implements UserDAO{
	@Autowired
	SqlSession sqlSession=null;
	
	public UserDAO_MyBatis() {
		//System.out.println("UserDAO_MyBatis 호출");
	}
	public UserVO login(String id, String pw) {
		
		UserVO vo =new UserVO();
		vo.setUserid(id);
		vo.setUserpwd(pw);
		
		return sqlSession.selectOne("userMapper.login", vo);
	}

	public int addUser(UserVO user) {		
		return sqlSession.insert("userMapper.adduser", user);
	}

	public UserVO getUser(String userid) {		
		return sqlSession.selectOne("userMapper.getuser",userid);
	}

	public List<UserVO> getUserList() {		
		return sqlSession.selectList("userMapper.listuser");
	}

	public int updateUser(UserVO user) {		
		return sqlSession.update("userMapper.updateuser", user);
	}

	public int removeUser(String userid) {		
		return sqlSession.update("userMapper.removeuser",userid);
	}

	public List<UserVO> searchUser(String condition, String keyword) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(condition,keyword);
		
		return sqlSession.selectList("userMapper.search", map);
	}
}
