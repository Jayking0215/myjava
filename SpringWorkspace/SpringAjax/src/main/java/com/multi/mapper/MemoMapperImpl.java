package com.multi.mapper;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.multi.domain.MemoVO;

import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class MemoMapperImpl implements MemoMapper {
	
	@Inject
	private MongoTemplate mongoTemplate;

	@Override
	public int insertMemo(MemoVO memo) {
		//insert(T obj, String collectionName)
		MemoVO vo=mongoTemplate.insert(memo, "memo");
		log.info("vo==="+vo);
		return 0;
	}

	@Override
	public List<MemoVO> listMemo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteMemo(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMemo(MemoVO memo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
