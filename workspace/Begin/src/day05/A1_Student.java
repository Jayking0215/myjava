package day05;

public class A1_Student {
	private int no;//인스턴스 변수(맴버변수)
	private String name;
	private String className;
	
	//setter
	public void setNo(int no) {//지역변수....scope가 달라서 매개변수 이름 같아도 상관없다.(누가봐도 이해할 수 있게하기 위해 매개변수는 의미있게 짓는다)
		//지역변수와 맴버변수의 이름이 같을 경우 지역변수가 우선!
		//no=no;//따라서 지역변수no=매개변수no 즉, 자신에게 자신의 값을 넣었기 때문에 warning발생 => 구분하기 위해 맴버변수 앞에 this를 붙임
		this.no=no;//this.변수 : 자기 객체의 인스턴스 변수를 참조할 때 this를 붙인다.
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setClassName(String className) {
		this.className=className;
	}
	
	//getter
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getClassName() {
		return className;
	}
	
	//showInfo()
	public void showInfo() {
		System.out.println("-----학생 정보-----");
		System.out.printf("학 번: %d%n", getNo());
		System.out.printf("이 름: %s%n", getName());
		System.out.printf("학급명: %s%n",getClassName());
	}
}
