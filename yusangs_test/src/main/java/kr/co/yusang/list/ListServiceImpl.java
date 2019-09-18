package kr.co.yusang.list;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.co.yusang.common.CommonDAO;

@Service
public class ListServiceImpl extends CommonDAO implements ListService{

	@Override
	public List<?> selectList(Map<String, Object> param) throws Exception {
		return super.list("list.selectList", param);
	}

}
