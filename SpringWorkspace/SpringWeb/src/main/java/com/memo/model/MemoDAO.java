package com.memo.model;

import java.util.List;

public interface MemoDAO {

	int insertMemo(MemoVO memo);
	
	int getTotalCount();
	List<MemoVO> listMemo(int start, int end);
	
	int updateMemo(MemoVO memo);
	int deleteMemo(int no);
	
	MemoVO getMemo(int no);
}
