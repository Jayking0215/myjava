package day07;

import javax.swing.*;

public class A3_AnimalTest {

	public static void main(String[] args) {
		
		String type=JOptionPane.showInputDialog("동물종류 입력");
		String cnt=JOptionPane.showInputDialog("새끼 수 입력");
		//예외처리
		if(type==null||cnt==null) return;
		
		int cnt_int=Integer.parseInt(cnt);//문자열을 정수형으로 반환
		A3_Animal an=null;//반복되는 선언을 줄이기 위해 더 큰 범위인 A3_Animal타입으로 생성
//		A3_Animal a=new Animal()://추상클래스는 타입선언은 가능하나 new해서 객체생성은 할 수 없다.
		if(type.equals("강아지")) {
			an=new Dog();
		}else if(type.equals("고양이")) {
			an=new Cat();
		}else if(type.equals("오리")){
			an=new Duck();
		}else {
			System.out.println("그런 동물 안키워!!!");
			return;
		}
		an.crySound();
		an.getBaby(cnt_int);
		
	}//main()

}//
