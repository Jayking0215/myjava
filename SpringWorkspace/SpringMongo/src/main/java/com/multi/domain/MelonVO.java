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
	private String ranking;//�뷡 ����
	
	@BsonProperty
	private String songTitle;//�뷡 ����
	
	@BsonProperty
	private String singer;//����
	
	@BsonProperty
	private String albumImage;//�ٹ��̹���
	
	@BsonProperty
	private String crawlingTime;//������ �ð�����
	

}
