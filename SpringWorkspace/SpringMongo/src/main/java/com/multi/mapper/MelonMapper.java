package com.multi.mapper;

import java.util.List;

import com.multi.domain.MelonVO;

public interface MelonMapper {
	
	
		int crawlingMelon() throws Exception;
		
		//������ ��� ��� ��������
		List<MelonVO> getMelonList(String collectionName) throws Exception;
		//������ ��� ũ�Ѹ��ؼ� ������ ����
		int insertMelon(List<MelonVO> mList, String collectionName);

}
