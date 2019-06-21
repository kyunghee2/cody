package web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.biz.cloth.service.ClothService;
import spring.biz.cloth.vo.ClothVO;
import spring.biz.user.vo.UserVO;


@Controller
public class ClothesController {
	
	@Autowired
	   ClothService clothservice;

	/*cloth_add.do 페이지*/
	@RequestMapping(value = "/clothes/cloth_add.do", method = RequestMethod.GET)
	public String cloth_add() {
		return "/clothes/cloth_add";
	}
	
	/*옷 이미지 등록*/
	@RequestMapping(value = "/clothes/cloth_add.do", method = RequestMethod.POST)
	public String cloth_add(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String fileName = file.getOriginalFilename(); /*클라이언트가 선택한 파일이름 불러옴*/
		String path = request.getRealPath("/upload/"); /*upload폴더 만든거 , 실제 서비스가 되면 저장되는 폴더*/
		
		System.out.println(path);
		if(!file.isEmpty()) {
			File f = new File(path+fileName); /*java.io.File -import*/ /*경로에 이이름으로*/
			/*파일 복사*/
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		request.setAttribute("imgname",fileName);
		return "/clothes/myCloth_list";
	}
	
	

	
	/*myCloth_list.do 페이지*/
	
	/*데이터 주입*/
	@RequestMapping(value="/clothes/myCloth_list.do" , method = RequestMethod.GET)
	public ModelAndView myCloth_list_(HttpServletRequest request, String kind, String season) {
		System.out.println("/clothes/myCloth_list.do");
		
		//HttpSession session = request.getSession();
		UserVO vo = (UserVO) request.getSession().getAttribute("login");
		System.out.println("edd");
		ModelAndView mav = new ModelAndView();
		System.out.println(clothservice.getClothes(vo.getUserid(), kind, season));
		mav.addObject("clothes", clothservice.getClothes(vo.getUserid(), kind, season));
		mav.setViewName("/clothes/myCloth_list");
			
		return mav;
	}
	
	/* cloth update */
	@RequestMapping("/clothes/updatecloth.do")
	public ModelAndView update(@ModelAttribute("cloth") ClothVO cloth) {
		ModelAndView mav = new ModelAndView();
		clothservice.updateCloth(cloth);
		mav.addObject("clothes", clothservice.updateCloth(cloth));
		mav.setViewName("/clothes/cloth_view");
		
		return mav;
	}
	
	/*multi remove */
	@RequestMapping("/clothes/clothesremove.do")
	public String deleteUserProc(@RequestParam("clothidList") List<Integer> clothidlist) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ClothVO> list = new ArrayList<ClothVO>();
		
		for(int clothid : clothidlist) {
			ClothVO item = new ClothVO();
			item.setClothid(clothid);
			list.add(item);
		}
		map.put("list", list);

		clothservice.multiRemoveCloth(map);
		return "redirect:/clothes/myCloth_list";
	}

}
