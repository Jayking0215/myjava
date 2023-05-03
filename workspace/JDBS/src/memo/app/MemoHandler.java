package memo.app;
//DAO(Model)와 VIEW를 연결하는 역할
import java.awt.event.*;
import java.sql.*;
import java.util.*;

/**
 * @author user
 * Controller
 *  View쪼게서 이벤트가 발생하면 이벤트를 처리한다.==>DB관련작업이 있으면 DAO객체 통해 작업을 수행
 *  ==>그 처리 결과를 View에 전달
 *  Model과 View사이에 제어하는 역할을 수행한다...DAO와 VIEW의 중간다리역할
 * */
public class MemoHandler implements ActionListener{
	MemoAppView app;//View..main()이기때문에 새로 생성x..액션핸들러를 통해서 제공받았음
	MemoDAO dao=new MemoDAO();//Model
	
	public MemoHandler(MemoAppView mav) {//인자 생성자 구성 후(view에서 this로 전달받는 것)
		this.app=mav;//this.app을 통해서 연결되어 핸들링 가능
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		app.showMessage("잘 나오나요?");//연동확인용
		Object obj=e.getSource();
		if(obj==app.btAdd) {//글 추가
			addMemo();
			app.clearInput();//전체 글목록 비우기
			listMemo();//전체목록 출력 메서드
		}else if(obj==app.btList) {//글 목록보기
			listMemo();
		}else if(obj==app.btDel) {//글 삭제
			deleteMemo();
			listMemo();
		}else if(obj==app.btEdit) {//글 수정
			editMemo();
		}else if(obj==app.btEditEnd) {//글 수정처리
			editMemoEnd();
			app.clearInput();
			listMemo();
		}else if(obj==app.btFind) {//글 내용 검색(키워드 검색)
			findMemo();
		}
	}//-----
	
	public void findMemo() {
		String keyword=app.showInputDialog("검색할 키워드를 입력하세요");
		if(keyword==null) return;
		if(keyword.trim().isEmpty()) {
			findMemo();//재귀호출(자기 메서드 안에서 자신을 호출)
			return;
		}
		try {
			List<MemoVO> arr=dao.findMemo(keyword);
			if(arr==null||arr.size()==0) {
				app.showMessage(keyword+"로 검색한 결과 해당 글은 없어요");
				return;
			}
			app.showTextArea(arr);
		}catch(SQLException e) {
			e.printStackTrace();
			app.showMessage(e.getMessage());
		}
	}//------
	
	public void editMemo() {
		//글번호로 해당 글 내용 가져오기 => select문 where(PK)절 => 결과는 단일행 레코드
		String noStr=app.showInputDialog("수정할 글 번호를 입력하세요");
		if(noStr==null) return;
		try {
			MemoVO vo=dao.selectMemo(Integer.parseInt(noStr.trim()));
			if(vo==null) {
				app.showMessage(noStr+"번 글은 존재하지 않아요!");
				return;
			}
			app.setText(vo);
		}catch(SQLException e) {
			app.showMessage(e.getMessage());
		}
	}//-----
	
	public void editMemoEnd() {
		//[1] 사용자가 입력한 값 받아오기(no,name,msg)
		String noStr=app.tfNo.getText();
		String name=app.tfName.getText();
		String msg=app.tfMsg.getText();
		//[2] 유효성 체크
		if(noStr==null||name==null||noStr.trim().isEmpty()||name.trim().isEmpty()) {
			app.showMessage("작성자와 글번호는 반드시 입력해야 해요");
			return;
		}
		//[3] 1번에서 얻은 값들을 MemoVO객체에 담아주기
		int no=Integer.parseInt(noStr.trim());
		MemoVO memo=new MemoVO(no,name,msg,null);
		try {
			//[4] dao의 updateMemo()호출하기
			int res=dao.updateMemo(memo);
			//[5] 그 결과 메시지 처리
			String str=(res>0)?"글 수정 성공!":"글 수정 실패!";
			app.showMessage(str);
		}catch(SQLException e) {
			e.printStackTrace();//디버깅을 위해서 스택에 남기기
			app.showMessage(e.getMessage());//사용자에게 오류 보여주기 위한 메세지
		}
	}//-----
	
	public void deleteMemo() {
		String noStr=app.showInputDialog("삭제할 글 번호를 입력하세요");
		if(noStr==null) return;
		try {
			int n=dao.deleteMemo(Integer.parseInt(noStr.trim()));
			String res=(n>0)?"글 삭제 성공":"글 삭제 실패";
			app.showMessage(res);
		}catch(SQLException e) {
			app.showMessage(e.getMessage());
		}
	}//-----
	
	public void addMemo() {
		//[1]app의 tfName,tfMsg에 입력한 값 얻어오기
		String name=app.tfName.getText();
		String msg=app.tfMsg.getText();
		//[2]유효성 체크(null,빈문자열 체크)
		if(name==null||msg==null||name.trim().isEmpty()) {
			app.showMessage("작성자와 메모내용을 입력해야해요.");
			app.tfName.requestFocus();
			return;
		}
		//[3] [1]번에서 받은 값을 MemoVO객체에 담아준다.
		MemoVO memo=new MemoVO(0,name,msg,null);
		//[4] dao의 insertMemo()호
		try {
			int result=dao.insertMemo(memo);
		//[5] 결과값에 따라 메시지 처리
			if(result>0) {
				app.setTitle("글 등록 성공!!");
			}else {
				app.showMessage("글 등록 실패!!");
			}
		}catch(SQLException e) {
			app.showMessage(e.getMessage());
		}
	}//-----
	
	public void listMemo() {
		try {
			List<MemoVO> arr=dao.listMemo();
//			app.setTitle("전체 글 개수: "+arr.size()+"개");//작동확인용
			//모델(DAO)통해서 받아온 데이터를 화면단(VIEW의 app)에 넘겨준다
			app.showTextArea(arr);
		}catch(SQLException e) {
			app.showMessage(e.getMessage());
		}
;	}//-----
}
