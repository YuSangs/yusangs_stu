package kr.co.yusang.list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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
		
		mav.addObject("list", service.selectList(param));
		
		if(param.get("msg") != null) {
			mav.addObject("msg", param.get("msg").toString());
		}
		return mav;
	}
	
	/**
	 * 글쓰기 폼 이동
	 * 
	 * @param Map<String, Object>
	 * @return ModelAndView
	 * */
	@RequestMapping("/writeForm.do")
	public String writeForm(@RequestParam Map<String, Object> param) throws Exception {
		return "list/writeForm";
	}
	
	/**
	 * 글쓰기 프로세스
	 * 
	 * @param Map<String, Object>
	 * @return ModelAndView
	 * */
	@RequestMapping("/write.do")
	public ModelAndView write(@RequestParam Map<String, Object> param, MultipartHttpServletRequest multi) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/list.do");
		
		mav.addObject("msg", service.write(param, multi));
		
		return mav;
	}
	
	/**
	 * 게시글 상세보기
	 * 
	 * @param Map<String, Object>
	 * @return ModelAndView
	 * */
	@RequestMapping("/sangse.do")
	public ModelAndView sangse(@RequestParam Map<String, Object> param) throws Exception {
		ModelAndView mav = new ModelAndView("list/sangse");
		
		mav.addObject("sangse", service.sangse(param));
		return mav;
	}
	
	/**
	 * 댓글 가져오기 프로세스
	 * 
	 * @param Map<String, Object>
	 * @return ModelAndView
	 * */
	@RequestMapping("/getRepleList.do")
	@ResponseBody
	public ResponseEntity getRepleList(@RequestParam Map<String, Object> param) throws Exception {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		
		return new ResponseEntity(service.getRepleList(param).toString(), responseHeaders, HttpStatus.CREATED);
				
				
	}
	
	/**
	 * 댓글달기 프로세스
	 * 
	 * @param Map<String, Object>
	 * @return ModelAndView
	 * */
	@RequestMapping("/repleOn.do")
	@ResponseBody
	public String repleOn(@RequestParam Map<String, Object> param) throws Exception {
		return service.repleOn(param);
	}
	
}
