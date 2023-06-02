package com.multi.service;

import java.util.List;

import com.multi.domain.MelonVO;
import com.multi.domain.SumVO;

public interface MelonService {
	
	//������ ��� ũ�Ѹ��ؼ� ������ ����
	int crawlingMelon() throws Exception;
	
	//������ ��� ��� ��������
	List<MelonVO> getMelonList() throws Exception;

	List<SumVO> getCntBySinger();
	
	

}
