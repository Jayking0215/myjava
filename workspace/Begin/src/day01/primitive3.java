package day01;

public class primitive3 {
	public static void main(String[] args) {
		System.out.println("1. 문자형(char----------");
		//charactor(문자형): char(2byte)= 0~2^16-1(0~65535)-java는 모든 국가의 언어를 표현 가능
		char ch1='가';
		char ch2='漢';
		String str="가나다";
		char ch3='W';
		
		print("ch1="+ch1);
		print("ch2="+ch2);
		print("ch3="+ch3);
		
		char ch4='\uff57';
		print("ch4="+ch4);
		
		char c='A';//아스키코드:A=65, a=97
		print("c+1="+(c+1));//66 => char + int = int(큰 자료유형으로 자동형변환(promotion)이 일어남)
		
		//66을 문자로 출력
		int n=c+1;
		print("n="+n);
		char c2=(char)n;//강제형변환(casting): 큰 유형에서 작은 유형으로 변환하고자 할 때
		print("c2="+c2);
		
		byte b1=10;
		byte b2=20;
		int b3=b1+b2;//int보다 작은 유형의 데이터가 연산에 사용되면 자동으로 int로 형변환된다.
		
		char g1='G';
		char g2='P';
		char g3='X';
		System.out.println(g1+g2+g3);//GPX==239
		//char + char = int		
		
		
		
		
		
		print("4. 논리형(boolean)----------");
		boolean bool1=true;
		boolean bool2=false;
		boolean bool3=7>3;
		print("bool1="+bool1);
		print("bool2="+bool2);
		print("bool3="+bool3);
		//java는 0,1로 호환되지 않는다. 형변환도 불가능(c언어:true=1, false=0)
		
		
		
		
	}
	
	public static void print(String str) {
		System.out.println(str);
	}
}
