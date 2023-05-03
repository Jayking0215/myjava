package day04;

public class HisDemo {
	public void foo() {
		System.out.println("---------foo()--------------");
	}
	
	public static void bar() {
		System.out.println("***********bar()*************");
	}
	
	//매개변수를 받는 메서드 2개 구성(static, non-static)
	public String showChar(char ch, int num) {
		String str="";
		for(int i=0; i<num; i++) {
			str+=ch;
		}
		return str;
	}
	
	public static long giveMe(int money) {
		System.out.println("giveMe() input money: "+money);
		return 3*money;
	}
	

	public static void main(String[] args) {
		//bar()호출
		HisDemo.bar();
		//foo()호출
		HisDemo hd=new HisDemo();
		hd.foo();
		
		new HisDemo().foo();//1회용일때 선언과동시에 출력

		//showChar()
		String s=hd.showChar('❤', 12);
		System.out.println(s);
		System.out.println(hd.showChar('@', 21));
		
		//giveMe()
		long l=giveMe(10000);
		System.out.println(l);
		
		l=HisDemo.giveMe(50000);
		System.out.println(l);
	}
	

}
