package com.multi.domain;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="Melon_230601")
public class MelonVO {
	
	@Id
	private String id;
	
	@BsonProperty
	private String ranking;//노래 순위
	
	@BsonProperty
	private String songTitle;//노래 제목
	
	@BsonProperty
	private String singer;//가수
	
	@BsonProperty
	private String albumImage;//앨범이미지
	
	@BsonProperty
	private String crawlingTime;//수집한 시간정보
	

}
