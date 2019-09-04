package kr.co.yusang.test;

import java.util.List;
import java.util.Map;

public interface TestService {

	public List<?> selectMain(Map<String, Object> param) throws Exception;
	
}
