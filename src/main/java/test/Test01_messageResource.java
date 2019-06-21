package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.biz.cloth.service.ClothService;
import spring.biz.cloth.vo.ClothVO;
import spring.biz.user.service.UserService;
import spring.biz.user.vo.UserVO;

public class Test01_messageResource {

	public static void main(String[] args) throws Exception {
		String[] config = { "applicationContext.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(config);

//		System.out.println(context.getMessage("hello", null, Locale.ENGLISH));
//		System.out.println(context.getMessage("hello", null, Locale.KOREA));
//
//		String msg = context.getMessage("login.success", new Object[] { "java01" }, Locale.KOREA);
//		System.out.println(msg);

		UserService userService = (UserService) context.getBean("userservice");
		ClothService clothService = (ClothService) context.getBean("clothservice");
		
		System.out.println(userService.login("a", "a1234"));
		UserVO u = new UserVO();
		u.setUserid("sam");
		u.setUserpwd("1234");
		u.setName("jung");
		u.setGender("1");
		u.setEmail("j@n.com");
		u.setPhone("0000");
		userService.addUser(u);
		userService.removeUser("sam");
		
		for(UserVO user:userService.getUserList())
			System.out.println(user);
		
		System.out.println(userService.getUser("a"));
		
		UserVO u2 = new UserVO();
		u2.setUserid("sam");
		u2.setEmail("k@k.com");
		u2.setPhone("1111");
		userService.updateUser(u2);
		
		System.out.println("1,2,3".contains("1"));
		
		ClothVO cloth = new ClothVO();
		cloth.setClothid(123);
		cloth.setColor("blue");
		clothService.addCloth(cloth);
}

}
