package web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.biz.cloth.service.ClothHistoryService;
import spring.biz.cloth.service.ClothService;
import spring.biz.cloth.vo.ClothHistoryVO;
import spring.biz.cloth.vo.ClothVO;
import spring.biz.user.service.UserService;
import spring.biz.user.vo.UserVO;
import util.AES256Util;

@Controller
@PropertySource("classpath:config.properties")
public class LoginController {
	
	@Autowired
	UserService service;
	@Autowired
	ClothService clothservice;
	@Autowired
	ClothHistoryService clothHistoryService;
	
	@Value("${secretkey}") 
	private String key;
	
	
	
	@RequestMapping(value = "/index.do",method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		
		UserVO vo = (UserVO) request.getSession().getAttribute("login");
		String userid=vo.getUserid();

		ModelAndView view = new ModelAndView();
		List<ClothVO> list_top = clothservice.recommendCloth(userid, "1");
		List<ClothVO> list_bottom = clothservice.recommendCloth(userid, "2");
		List<ClothHistoryVO> list_lately = clothHistoryService.getClothDate(userid, "");
		String outermsg = clothservice.outerwear();
		
		view.addObject("list_top", list_top);
		view.addObject("list_bottom", list_bottom);
		view.addObject("list_lately", list_lately);
		view.addObject("userid", userid);
		view.addObject("outermsg",outermsg);
		
		view.setViewName("index");
		System.out.println(list_top); 
		System.out.println(list_lately);
		//System.out.println(history_top);
		//System.out.println(outwear_msg);
		//최근 입었던옷
		return view;

	}
	
	@RequestMapping(value = "/login.do",method = RequestMethod.GET)
	public String login() {
		//return "/login";// view페이지 리턴
		return "redirect:login.jsp";
	}
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public String loginProc(UserVO vo,HttpServletRequest request) throws Exception {
		AES256Util aes256 = new AES256Util(key);			
		String acs_pwd = aes256.aesEncode(vo.getUserpwd());
		
		UserVO user = service.login(vo.getUserid(), acs_pwd);
		if(user != null) {
			request.getSession().setAttribute("User", user);
			request.getSession().setAttribute("login", user);
			
			//return "redirect:index.jsp";
			return "redirect:index.do";
		}else {
			request.setAttribute("msg", "로그인 정보를 다시 입력하세요.");
			//return "login";
			return "redirect:login.do";
		}
	}
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {		
		HttpSession session = request.getSession();
		if(session!=null)
			session.invalidate();
		
		request.setAttribute("msg", "로그아웃 되었습니다.");
	
		//return "redirect:index.jsp";
		System.out.println("로그아웃 되었습니다.");
		return "redirect:login.do";
	}
	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception,Model model) {
		// UserController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}
	
}
