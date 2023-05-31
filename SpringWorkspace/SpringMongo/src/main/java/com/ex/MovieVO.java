package com.ex;

import lombok.Data;

@Data
public class MovieVO {
	private int movie_no;//일련번호
	private String movie_rank;//영화랭킹
	private String movie_name;//영화명
	private String movie_reserve;//예약률
	private String movie_score;//점수
	private String open_day;//개봉일
	private String movie_image;//영화포스터이미지 url
	
	private String rank_checkTime;//크롤링한 시간

}
