package com.multi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //���ڻ�����
@NoArgsConstructor //�⺻������
public class UserVO {
	
	private int num;
	private String name;
	private String tel;
	private String addr;

}
