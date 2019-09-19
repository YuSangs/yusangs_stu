package kr.co.yusang.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.yusang.common.CommonDAO;
import kr.co.yusang.common.FileUtil;

@Service
public class ListServiceImpl extends CommonDAO implements ListService{

	@Autowired
	private FileUtil fileUtil;
	
	@Override
	public List<?> selectList(Map<String, Object> param) throws Exception {
		return super.list("list.selectList", param);
	}

	@Override
	public String write(Map<String, Object> param, MultipartHttpServletRequest multi) throws Exception {
		String msg = "";
		
		if(super.insert("list.write", param) == 1) {
			List<Map<String, Object>> fileList = new ArrayList<Map<String, Object>> ();
			
			fileList = fileUtil.parseInsertFileInfo(multi);
			
			if(fileList.size() > 0) {
				param.put("ori_file", fileList.get(0).get("ori_file").toString());
				param.put("sto_file", fileList.get(0).get("sto_file").toString());
				
				if(super.insert("list.insertFile", param) == 1) {
					msg = "등록 완료";
				}else {
					msg = "파일 등록 오류";
				}
			}
		}else {
			msg = "글 등록 오류";
		}
		
		return msg;
	}
}