package com.multi.mapper;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.common.CommonUtil;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.multi.domain.MemoVO;
import com.multi.domain.SeqVO;

import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class MemoMapperImpl implements MemoMapper {
	
	@Inject
	private MongoTemplate mongoTemplate;

	@Override
	public int insertMemo(MemoVO memo) {
		//���� �۹�ȣno�� �־��� ���� sequence�÷��ǿ��� ��������, count���� 1�� ������Ų�� �����´�
		Update update=new Update().inc("count", 1);//count���� 1�� ������Ų��. {$inc:{count:1}}
		//Query qry=query(where("collectionName").is("memo"))
		SeqVO svo=mongoTemplate.findAndModify(query(where("collectionName").is("memo")), update, SeqVO.class);
		log.info("svo==="+svo);
		memo.setNo(svo.getCount());//�������� �ش��ϴ� count���� �۹�ȣ�� ��������		
		memo.setWdate(CommonUtil.getDateTime());
		
		//insert(T obj, String collectionName)
		MemoVO vo=mongoTemplate.insert(memo, "memo");
		log.info("vo==="+vo);
		return 0;
	}

	@Override
	public List<MemoVO> listMemo() {
		
		List<MemoVO> memoArr=mongoTemplate.findAll(MemoVO.class,"memo");
		
		return memoArr;
	}

	@Override
	public int deleteMemo(String id) {
		DeleteResult res=mongoTemplate.remove(query(where("_id").is(id)), MemoVO.class);
		long cnt=res.getDeletedCount();
		log.info("delete cnt: "+cnt);
		return (int)cnt;
	}

	@Override
	public int updateMemo(MemoVO memo) {
		/*
		Update update=new Update();
		update.set("name", memo.getName()).set("msg", memo.getMsg());
		
		UpdateResult res=mongoTemplate.updateFirst(query(where("_id").is(memo.getId())), update, MemoVO.class);
		*/
		memo.setWdate(CommonUtil.getDateTime());
		MemoVO vo=mongoTemplate.findAndReplace(query(where("_id").is(memo.getId())), memo);
		log.info("vo="+vo);
		//return (int)res.getModifiedCount();
		return vo.getNo();
	}

	@Override
	public MemoVO getMemo(String id) {
		
		return this.mongoTemplate.findOne(query(where("id").is(id)), MemoVO.class);
	}

}
