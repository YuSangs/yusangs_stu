package kr.co.yusang.list;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {

	@Autowired
	ListService service;
	
	/**
	 * 게시판 가져오기
	 * 
	 * @param Map<String, Object>
	 * @return ModelAndView
	 * */
	@RequestMapping("/list.do")
	public ModelAndView selectList(@RequestParam Map<String, Object> param) throws Exception {
		ModelAndView mav = new ModelAndView("list/list");
		
		System.out.println("게시판 가져오기 테스트중");
		
		mav.addObject("list", service.selectList(param));
		return mav;
	}
	
}
