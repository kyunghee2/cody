package web.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.biz.cloth.service.ClothService;
import spring.biz.cloth.vo.ClothVO;

@Controller
public class ClothesController {

	@Autowired
	ClothService clothservice;
		
	/*cloth_add.do 페이지*/
	/*
	@RequestMapping(value = "/clothes/cloth_add.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView cloth_add() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("clothes", clothservice.addCloth();
		mav.setViewName("");
		
	@RequestMapping(value = "/report.do", method = RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file , 
			                 HttpServletRequest request) {
		String fileName = file.getOriginalFilename();
		String path = request.getRealPath("/upload/");
		System.out.println(path);
		if(!file.isEmpty()) {
			File f = new File(path+fileName);
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("imgname", fileName);
		return "reportResult";
		return "/clothes/cloth_add";
	}
	*/
	
	/*myCloth_list.do 페이지*/
	
	@RequestMapping(value="/clothes/myCloth_list.do" , method = RequestMethod.GET)
	public ModelAndView myCloth_list(String userid, String kind, String season) {
		System.out.println("/clothes/myCloth_list.do");
		ModelAndView mav = new ModelAndView();
		System.out.println(clothservice.getClothes(userid, kind, season));
		mav.addObject("clothes", clothservice.getClothes(userid, kind, season));
		mav.setViewName("/clothes/myCloth_list");
			
		return mav;
	}

	
}
