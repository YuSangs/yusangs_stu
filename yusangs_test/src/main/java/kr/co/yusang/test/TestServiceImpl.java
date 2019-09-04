package kr.co.yusang.test;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.co.yusang.common.CommonDAO;

@Service
public class TestServiceImpl extends CommonDAO implements TestService{

	@Override
	public List<?> selectMain(Map<String, Object> param) throws Exception {
		return super.list("test.selectTest", param);
	}

}
