package memo.app;
//초기값 설정-생성자 생성-getter/setter만들기
import java.sql.Date;

/**
 * @author a
 * Domain 객체--Model에 속한다.
 * VO(Value Object):DB에서 가져온 값이나, UI통해 입력받은 값을 담고 있는 객체
 * memo테이블에 있는 칼럼들=> class의 member변수로 옮겨 구성
 * */

public class MemoVO {
	//캡슐화
	private int no;
	private String name;
	private String msg;
	private java.sql.Date wdate;
	
	//오버로드
	public MemoVO() {
		this(0, null, null, null);
	}
	//Source-generate constructor using field
	public MemoVO(int no, String name, String msg, Date wdate) {
		super();
		this.no = no;
		this.name = name;
		this.msg = msg;
		this.wdate = wdate;
	}
	//setter, getter...Source-generate getter and setter

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public java.sql.Date getWdate() {
		return wdate;
	}

	public void setWdate(java.sql.Date wdate) {
		this.wdate = wdate;
	}
	
}///////////////
