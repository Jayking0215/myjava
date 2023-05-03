package day05;

public class A1_Staff {
	private int no;
	private String name;
	private String dept;
	
	//setter/getter Eclipse자동생성tip.....상단Source-generate setter/getter
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	
//	//setter
//	public void setNo(int no) {
//		this.no=no;
//	}
//	public void setName(String name) {
//		this.name=name;
//	}
//	public void setDept(String dept) {
//		this.dept=dept;
//	}
//	
//	//getter
//	public int getNo() {
//		return no;
//	}
//	public String getName() {
//		return name;
//	}
//	public String getDept() {
//		return dept;
//	}
	
	//showInfo()
	public void showInfo() {
		System.out.println("-----스탭 정보-----");
		System.out.printf("사 번: %d%n", getNo());
		System.out.printf("이 름: %s%n", getName());
		System.out.printf("부서명: %s%n",getDept());
	}


}
