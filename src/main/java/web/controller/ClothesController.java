package web.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.biz.cloth.vo.ClothVO;

@Controller
public class ClothesController {

	/*cloth_add.do 페이지*/
	@RequestMapping(value = "/clothes/cloth_add.do", method = RequestMethod.GET)
	public String cloth_add() {
		return "/clothes/cloth_add";
	}
	
	@RequestMapping(value = "/clothes/cloth_add.do", method = RequestMethod.POST)
	public String cloth_add_() {
					
		return "/clothes/cloth_add";
	}

	
	/*myCloth_list.do 페이지*/
	@RequestMapping(value = "/clothes/myCloth_list.do", method = RequestMethod.GET)
	public String myCloth_list() {
		return "/clothes/myCloth_list";
	}
	
	@RequestMapping(value = "/clothes/myCloth_list.do", method = RequestMethod.POST)
	public String myCloth_list_() {
		return "/clothes/myCloth_list";
	}

}
