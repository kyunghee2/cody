package spring.biz.user.dao;

import java.util.List;

import spring.biz.user.vo.UserVO;

public interface UserDAO {
	UserVO login(String id, String pw) throws Exception;
	
	int addUser(UserVO user); 
	
	UserVO getUser(String uid); 
	
	List<UserVO> getUserList(); 
	
	int updateUser(UserVO user);
	
	int removeUser(String uid);
	
	List<UserVO> searchUser(String condition,String keyword) ;
}
