package day05;

import java.util.Scanner;

public class User {
	private int no;//회원번호==> key값으로 활용
	private String name;//회원이름
	private String tel;//연락처
	Scanner sc=new Scanner(System.in);
	
	public User() {
	}

	public User(int no, String name, String tel) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
	}

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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public void input() {
		System.out.println("회원번호: ");
		this.no=sc.nextInt();
		System.out.println("회원이름: ");
		this.name=sc.next();
		System.out.println("연 락 처: ");
		this.tel=sc.next();
	}

	@Override
	public String toString() {
		return name+"\t"+tel+"\n";
	}
}
