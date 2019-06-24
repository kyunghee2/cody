package web.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.biz.cloth.service.ClothService;
import spring.biz.cloth.vo.ClothVO;
import spring.biz.user.vo.UserVO;

@Controller
public class ClothesController {

	@Autowired
	ClothService clothservice;

	/* cloth_add.do 페이지 */
	@RequestMapping(value = "/clothes/cloth_add.do", method = RequestMethod.GET)
	public String cloth_add() {
		return "/clothes/cloth_add";
	}
	
	/* 옷 이미지 등록 */
	@RequestMapping(value = "/clothes/cloth_add.do", method = RequestMethod.POST)
	public String cloth_add(@RequestParam("file") MultipartFile file, @ModelAttribute("cloth") ClothVO cloth,
			HttpServletRequest request) {
		String fileName = file.getOriginalFilename(); /* 클라이언트가 선택한 파일이름 불러옴 */

		String kind = request.getParameter("kind");
		UserVO user = (UserVO) request.getSession().getAttribute("login");
		String userid = user.getUserid();
		String detailpath = "/upload/" + userid + "/" + kind + "/";
		/* 절대경로 */
		String path = request.getRealPath(detailpath); /* upload폴더 만든거 , 실제 서비스가 되면 저장되는 폴더 */
		/* 상대경로 */
//		String path1 = request.getSession();

		File destdir = new File(path); // 디렉토리 가져오기
		System.out.println(path);

		if (!destdir.exists()) {
			destdir.mkdirs(); // 디렉토리 존재하지 않는다면 생성
		}

		File f = new File(path + fileName); /* java.io.File -import */ /* 경로에 이이름으로 */

		if (!file.isEmpty()) {
			boolean fileexists = f.exists(); // 파일 존재 유무 검사

			if (fileexists) { // 중복된 파일이 있다면
				UUID uuid = UUID.randomUUID();
				fileName = uuid.toString() + fileName;
				f = new File(path + fileName);
			}
		}
		/* 파일 복사 */
		try {
			file.transferTo(f);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("완");
		request.setAttribute("imgname", fileName);
		cloth.setUserid(userid);
		cloth.setImgpath(detailpath);
		cloth.setImgname(fileName);

		clothservice.addCloth(cloth);

		return "/clothes/cloth_add";

	}

	/* myCloth_list.do 페이지 */

	/* 데이터 주입 */
	@RequestMapping(value = "/clothes/myCloth_list.do", method = RequestMethod.GET)
	public ModelAndView myCloth_list_(HttpServletRequest request, String kind, String season) {
		System.out.println("/clothes/myCloth_list.do");

		// HttpSession session = request.getSession();
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

	@RequestMapping(value = "/clothes/clothesremove.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Integer> deleteClothes(HttpServletRequest request, HttpServletResponse response ) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		String de = request.getParameter("clothidlist");
		int result = 0;
		try {
			
			for(String clothid: de.split(",")) {				
				result = clothservice.removeCloth(Integer.parseInt(clothid));
			}
			map.put("result", result);	

		} catch (Exception e) {
			map.put("result", 0);		
		}
		return map;
	}

}
