package kr.co.yusang.list;

import java.util.List;
import java.util.Map;

public interface ListService {

	public List<?> selectList(Map<String, Object> param) throws Exception;
	
}
