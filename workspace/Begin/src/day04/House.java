package day04;
//객체=속성(member variable)+행동약식(method)
public class House {
	//1.속성 - has a 관계가 성립해야 한다.
	int room; //House has a room
	String owner;
	String addr;
	
	//2.행동양식(기능)
	public void printInfo() {//반환값이 없을 때 void사용
	System.out.println("-----House정보-----");
	System.out.printf("소유주: %s%n", owner);
	System.out.printf("방 수: %d개%n", room);
	System.out.printf("주  소: %s%n", addr);
	}
	public String existAt(int bunji) {//반환값이 String이기 때문에 void사용 x
		String str="---"+owner+"의 집 상세주소---\n";
			str+=addr+" "+bunji+"번지에 위치해요\n";
		
		return str;
	}
	
	//rent()메서드 구성하기(집의 거래유형-매매, 전세, 월세 가격:만원단위)
	//정보를 매개변수로 받아서 문자열로 만들어 반환하는 메서드를 구성하세요
	public String rent(int type, int price) {
		String str=owner+"의 집----\n";
		switch(type) {
			case 1:
				str+="거래유형: 매매";
				break;
			case 2:
				str+="거래유형: 전세";
				break;
			case 3:
				str+="거래유형: 월세";
				break;
			default:
				break;
		}
		str+="\n가격:"+price+"만원\n";
		return str;
	}
	
	
}//////////////////////////
