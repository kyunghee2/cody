package web.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ClothesController {

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
	@RequestMapping(value = "/clothes/myCloth_list.do", method = RequestMethod.GET)
	public String myCloth_list() {
		return "/clothes/myCloth_list";
	}
	
	@RequestMapping(value = "/clothes/myCloth_list.do", method = RequestMethod.POST)
	public String myCloth_list_() {
		return "/clothes/myCloth_list";
	}

}
