package com.multi.service;

import java.util.List;

import com.multi.domain.MelonVO;

public interface MelonService {
	
	//������ ��� ũ�Ѹ��ؼ� ������ ����
	int crawlingMelon() throws Exception;
	
	//������ ��� ��� ��������
	List<MelonVO> getMelonList() throws Exception;
	
	

}
