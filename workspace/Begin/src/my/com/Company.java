package my.com;

import java.util.Scanner;

public class Company {
	
	String name;//회사명
	int year;//설립연도
	int employees;//사원수
	
	Scanner sc=new Scanner(System.in);
	
	//생성자 구성(Constructor)
	public void input() {
		System.out.print("회 사 명: ");
		name=sc.nextLine();
		System.out.println("설립연도: ");
		year=sc.nextInt();
		System.out.println("총사원수: ");
		employees=sc.nextInt();
	}
	
	public String introduce() {
		String intro="---회사소개---\n";
		intro+="회 사 명: "+name+"\n";
		intro+="설립년도: "+year+"\n";
		intro+="총사원수:"+employees+"\n";
		return intro;//intro반환
	}
	
	
}////////////////////////////////////
