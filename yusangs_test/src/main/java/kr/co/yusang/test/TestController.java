package kr.co.yusang.test;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@Autowired
	TestService service;
	
	/**
	 * 메인
	 * 
	 * @param Map<String, Object>
	 * @return ModelAndView
	 * */
	@RequestMapping("/test.do")
	public ModelAndView main(@RequestParam Map<String, Object> param) throws Exception {
		ModelAndView mav = new ModelAndView("test");
		
		mav.addObject("list", service.selectMain(param));
		return mav;
	}
	
}
