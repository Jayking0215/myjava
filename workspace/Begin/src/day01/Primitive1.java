package day01;

public class Primitive1 {
	//라인 삭제: ctrl+d
	//라인 복사: ctrl+alt+방향키 아래
	//sysout + ctrl+spaceBar
	public static void main(String[] args) {
		System.out.println("1. 기본 자료형(정수형)----------");
//		System.out.println(false);
		//정수형: byte < short < int < long
		byte bt1=-128; //byte(8bit):-128~127 사이값 저장 가능
		byte bt2=127;
		System.out.println("bt1="+bt1);
		System.out.println("bt2="+bt2);
		
		short bt3=128; //short(2byte): -2^15~2^15-1=32768
		System.out.println(bt3);
		short st1=25000;
		System.out.println(st1);
		
		int it1=100000;//int(4byte):-2^31~2^31-1=21억47483648
		System.out.println(it1);
		
		long ln1=40;//long(8byte):-2^63~2^63-1
		long ln2=40L;//뒤에 접미사 L,l을 붙인다
		System.out.printf("ln1=%d%n", ln1);
		System.out.printf("ln2=%d%n", ln2);
		
		int i=1000000000;//0이 9개
		long j=10000000000L;//0이 10개
		System.out.println("i="+i);
		System.out.println("j="+j);
		
		int a1=010;//8진수의 정수, 접두어:0을 붙인다
		//0*8^2+1*8^1+0*8^0=8
		int a2=0x1ac;//16진수의 정수, 접두어:0x를 붙인다
		//1*16^2+10*16^1+12*16^0=428
		System.out.println(a1);
		System.out.println(a2);
		
	}
}
