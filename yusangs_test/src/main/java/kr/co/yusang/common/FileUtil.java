package kr.co.yusang.common;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component("fileUtil")
public class FileUtil {

	//랜덤 파일명 생성
	public static String getRandomString(){ 
		return UUID.randomUUID().toString().replaceAll("-", ""); 
	}
	
	//파일 저장 위치 지정
	private static final String filePath = "D:\\dev\\file\\";
	
	//파일 저장 프로세스
	public List<Map<String,Object>> parseInsertFileInfo(MultipartHttpServletRequest multi) throws Exception{ 
		
		Iterator<String> iterator = multi.getFileNames(); 
		MultipartFile multipartFile = null; //멀티파트파일
		String originalFileName = null;  //파일명
		String originalFileExtension = null; //파일 확장자
		String storedFileName = null; //파일명 중복 방지명(DB에 집어넣는 값)
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> listMap = null; 
		File file = new File(filePath); //파일 객체 생성
		
		//파일 경로가 없으면 폴더 생성
		if(file.exists() == false){ 
			file.mkdirs(); 
		} 
		
		//파일 저장 위치로 전송
		while(iterator.hasNext()){ 
			multipartFile = multi.getFile(iterator.next()); 
			if(multipartFile.isEmpty() == false){ 
				originalFileName = multipartFile.getOriginalFilename(); //파일명 가져오기 (확장자 포함)
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf(".")); //파일명에서 확장자 값만 가져오기 
				storedFileName = getRandomString() + originalFileExtension; //랜덤 파일명으로 중복 방지
				file = new File(filePath + storedFileName); 
				multipartFile.transferTo(file);
				
				listMap = new HashMap<String,Object>(); 
				listMap.put("ori_file", originalFileName); 
				listMap.put("sto_file", storedFileName); 
//				listMap.put("FILE_SIZE", multipartFile.getSize()); 
				list.add(listMap); 
				} 
			} 
		return list; 
	}
}