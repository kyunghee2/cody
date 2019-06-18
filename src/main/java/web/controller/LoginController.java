package web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.biz.user.service.UserService;
import spring.biz.user.vo.UserVO;

@Controller
public class LoginController {
	@Autowired
	UserService service;
	
	
	@RequestMapping(value = "/login.do",method = RequestMethod.GET)
	public String login() {
		return "login";// view페이지 리턴
	}
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public String loginProc(UserVO vo,HttpServletRequest request) throws Exception {
		UserVO user = service.login(vo.getUserid(), vo.getUserpwd());
		if(user != null) {
			request.getSession().setAttribute("User", user);
			request.getSession().setAttribute("login", user);
			
			return "redirect:index.jsp";
		}else {
			request.setAttribute("msg", "로그인 정보를 다시 입력하세요.");
			return "login";
		}
	}
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {		
		HttpSession session = request.getSession();
		if(session!=null)
			session.invalidate();
		
		request.setAttribute("msg", "로그아웃 되었습니다.");
		return "login";
		//return "redirect:index.jsp";
	}
	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception,Model model) {
		// UserController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}
}
