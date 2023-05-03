package day05;
/*
 * access modifier(접근 제어자)
 * [1]private : 자기 class 내에서만 접근 가능
 * [2]생략형 : 같은 pakage 내에 있는 class끼리만 접근 가능
 * [3]protected : 다른 pakage일지라도 상속관계면 접근 가능
 * [4]public : 어디서든 접근 가능
 * 
 * 접근범위 : private < 생략형 < protected < public
 * */
public class A0_CoffeeMachine {

	private int coffee;
	private int sugar;
	private short cream;
	
	//setXXX(): setter => void(반환타입x), 매개변수를 받는다.
	public void setCoffee(int c) {
		coffee=c;
	}
	public void setSugar(int s) {
		sugar=s;
	}
	public void setCream(short c) {//지역변수라서 메서드() 벗어나면 같은 변수 사용 가능
		cream=c;
	}
	
	//getXXX(): getter => 반환타입o, 매개변수x
	public int getCoffee() {
		return coffee;
	}
	public int getSugar() {
		return sugar;
	}
	public short getCream() {
		return cream;
	}
}//CoffeeMachine()