package day05;
//메소드 오버로딩(다중정의)
/* [1] 메서드 이름은 같게 구성한다
 * [2] 매개변수는 자료형이 다르거나, 갯수가 다르거나, 순서가 달라야 한다
 * [3] 반환타입은 같아도 되고 달라도 된다. (반환타입은 신경쓰지 않음)
 * */
public class A2_VendingMachine {

	//캡슐화
	private int coffee, sugar, cream;
	
	public void makeTea(int coffee, int sugar, int cream) {
		this.coffee=coffee;
		this.sugar=sugar;
		this.cream=cream;
		System.out.println("밀크커피 준비완료! 농도: "+(this.coffee+this.sugar+this.cream));
	}
	//같은 반환타입으로 오버로딩
	public void makeTea(int c, int s) {
		coffee=c; sugar=s;
		System.out.println("설탕커피 준비완료! 농도: "+(coffee+sugar));
	}
	
	public String makeTea(int coffee) {
		this.coffee=coffee;
		return "블랙커피 준비완료! 농도: "+(this.coffee);
	}
	//자료형 구조 다르게 하기
	public void makeTea(int coffee, short cream) {//cream의 자료형을 int가 수용가능한 자료형으로 변환
		this.coffee=coffee;
		this.cream=cream;
		System.out.println("크림커피 준비완료! 농도: "+(this.coffee+this.cream));
	}
	//매개변수 순서 바꾸기
	public void makeTea(short cream, int coffee) {
		this.cream=cream;
		this.coffee=coffee;
		System.out.println("크림커피 준비완료! 농도: "+(this.cream+this.coffee));
	}
	//유자차 메서드 오버로드하기
	public void makeTea(A2_Yuja yuja) {
		System.out.println("유자차 준비완료! 농도: "+yuja.getYuja());
		System.out.println("설탕= 농도: "+yuja.getSugar());
		System.out.println("유자차 준비완료! 농도: "+(yuja.getYuja()+yuja.getSugar()));
	}
}
