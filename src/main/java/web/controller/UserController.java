package web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.biz.user.service.UserService;
import spring.biz.user.vo.UserVO;
import util.AES256Util;

@Controller
@PropertySource("classpath:config.properties")
public class UserController {
	@Autowired
	UserService service;
	
	@Value("${secretkey}") 
	private String key;
	
	@RequestMapping(value = "/user/join.do", method = RequestMethod.GET)
	public String addJoin() {	
		return "user/user_join";
	}
	@RequestMapping("/user/list.do")
	public ModelAndView getUserList() {
		ModelAndView view = new ModelAndView();
		
		view.addObject("users", service.getUserList());
		view.setViewName("user/user_list");
		return view;
	}
//	@RequestMapping(value = "/user/add.do", method = RequestMethod.GET)
//	public String addUser() {	
//		return "user/user_write";
//	}
	//회원가입
	@RequestMapping(value = "/user/add.do", method = RequestMethod.POST)
	public String addUserProc(@ModelAttribute("user") UserVO vo,HttpServletRequest request,BindingResult errors) {	

//		new UserValidator().validate(vo, errors);//vo객체 유효성체크
//		if(errors.hasErrors()) {
//			return "user/user_write";
//		}
		System.out.println(vo); 
		
		try {
			AES256Util aes256 = new AES256Util(key);			
			String acs_pwd = aes256.aesEncode(vo.getUserpwd());
			vo.setUserpwd(acs_pwd);
			
			service.addUser(vo);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "user/user_write";
		}			
		
		//return "redirect:./list.do";
		return "user/user_join_result";
	}
	@RequestMapping("/user/view.do")
	public ModelAndView getView(@RequestParam("uid") String id) {
		ModelAndView view = new ModelAndView();
		//String uid = request.getParameter("uid");
		
		view.addObject("user", service.getUser(id));
		view.setViewName("user/user_view");
		return view;
	}
	@RequestMapping("/user/remove.do")
	public String deleteUserProc(@RequestParam("uid") String id) {
		service.removeUser(id);
		return "redirect:./list.do";
	}
	@RequestMapping("/user/modify.do")
	public ModelAndView getModifyView(@RequestParam("uid") String id) {
		ModelAndView view = new ModelAndView();
		
		view.addObject("user", service.getUser(id));
		view.setViewName("user/user_modify");
		return view;
	}
	@RequestMapping("/user/update.do")
	public ModelAndView update(@ModelAttribute("user") UserVO vo) {
		ModelAndView view = new ModelAndView();
		service.updateUser(vo);
		view.addObject("user", service.getUser(vo.getUserid()));
		view.setViewName("user/user_view");
		return view;
	}
	@RequestMapping("/user/search.do")
	public ModelAndView search(String searchCondition,String searchKeyword) {
		ModelAndView view = new ModelAndView();
		
		view.addObject("users", service.searchUser(searchCondition, searchKeyword));
		view.setViewName("user/user_list");
		return view;
	}
	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception,Model model) {
		// UserController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}
}
