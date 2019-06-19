package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClothesController {

	@RequestMapping(value = "/cloth_add.do", method = RequestMethod.GET)
	public String cloth_add() {
		return "cloth_add";
	}
	
	@RequestMapping(value = "/cloth_add.do", method = RequestMethod.POST)
	public String cloth_add_() {
		return "cloth_add";
	}
}
