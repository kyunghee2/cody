package web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.tracing.dtrace.ModuleAttributes;

import spring.biz.user.dao.UserDAO;
import spring.biz.user.dao.UserDAO_JDBC;
import spring.biz.user.service.UserService;
import spring.biz.user.service.UserServiceImpl;
import spring.biz.user.vo.UserVO;
import web.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	UserService service;
	
	@RequestMapping("/user/list.do")
	public ModelAndView getUserList() {
		ModelAndView view = new ModelAndView();
		
		view.addObject("users", service.getUserList());
		view.setViewName("user/user_list");
		return view;
	}
	@RequestMapping(value = "/user/add.do", method = RequestMethod.GET)
	public String addUser() {	
		return "user/user_write";
	}
	@RequestMapping(value = "/user/add.do", method = RequestMethod.POST)
	public String addUserProc(@ModelAttribute("user") UserVO vo,HttpServletRequest request,BindingResult errors) {	

		new UserValidator().validate(vo, errors);//vo객체 유효성체크
		if(errors.hasErrors()) {
			return "user/user_write";
		}
		System.out.println(vo); //vo command 객체, 동적바인딩을 위해 form name과 동일하게 설정
		int result = service.addUser(vo);
		
		return "redirect:./list.do";
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
		int result = service.removeUser(id);
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
