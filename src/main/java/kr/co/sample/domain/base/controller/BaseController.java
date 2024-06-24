package kr.co.sample.domain.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sample.domain.base.dto.BaseDTO;
import kr.co.sample.domain.base.service.BaseService;

@Controller
public class BaseController {
	
	@Autowired
	BaseService baseService;
	
	@RequestMapping("/")
	public ModelAndView getUer(BaseDTO dto) {
		
		dto = baseService.getBaseUser(dto);
		
		return new ModelAndView("home");
	}
}
