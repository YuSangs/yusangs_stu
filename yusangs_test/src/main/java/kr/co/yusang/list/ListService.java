package kr.co.yusang.list;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface ListService {

	public List<?> selectList(Map<String, Object> param) throws Exception;

	public String write(Map<String, Object> param, MultipartHttpServletRequest multi) throws Exception;
	
}
