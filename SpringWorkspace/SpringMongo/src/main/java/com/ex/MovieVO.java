package com.ex;

import lombok.Data;

@Data
public class MovieVO {
	private int movie_no;//�Ϸù�ȣ
	private String movie_rank;//��ȭ��ŷ
	private String movie_name;//��ȭ��
	private String movie_reserve;//�����
	private String movie_score;//����
	private String open_day;//������
	private String movie_image;//��ȭ�������̹��� url
	
	private String rank_checkTime;//ũ�Ѹ��� �ð�

}
