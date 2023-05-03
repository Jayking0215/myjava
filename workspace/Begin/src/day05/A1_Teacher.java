package day05;

public class A1_Teacher {
	private int no;
	private String name;
	private String subject;
	
	//setter
	public void setNo(int no) {
		this.no=no;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setSubject(String subject) {
		this.subject=subject;
	}
	
	//getter
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getSubject() {
		return subject;
	}
	
	//showInfo()
	public void showInfo() {
		System.out.println("-----교사 정보-----");
		System.out.printf("교 번: %d%n", getNo());
		System.out.printf("이 름: %s%n", getName());
		System.out.printf("과목명: %s%n",getSubject());
	}
}
