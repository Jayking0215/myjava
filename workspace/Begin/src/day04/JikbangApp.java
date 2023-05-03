package day04;
//Application
/*
 * 직방 프로그램에 필요한 객체
 * -집
 * -매도자, 매수자, 중개인, 임대인, 임차인
 * 객체를 프로그램 세계로 끌어들이는 것==추상화(주된 특징만 부각시켜서 class로 옮긴다)
 * */
public class JikbangApp {
	public static void main(String[] args) {
		//단위 테스트(Unit Test)
		//class: 객체를 만들어내는 틀
		//객  체: class를 통해 만들어지는 구현물
		//현실세계에 존재하는 객체(Object, Instance) ==> 프로그램에서 객체를 생성해서 메모리에 올림(object, instance)
		House h1=new House();//object, instance
		House h2=new House();//=>stack에 올라가고, Heap에 House의 객체들이 올라감(stack->Heap 가리킴)//h1과 h2는 서로 다른 Heap을 가리킴
		//non-static메서드 호출: 객체명.매서드명()
		h1.owner="홍길남";
		h1.room=3;
		h1.addr="강남구 삼성동";
		
		h2.owner="홍길서";
		h2.room=2;
		h2.addr="마포구 서교동";
		
		h1.printInfo();
		h2.printInfo();
		
		House h3=h1;//stack의 h3가 h1이 가리키는 Heap을 가리키게 됨
		
		h3.printInfo();
		
		//House 객체를 새로 생성하고 속성값 할당하기
		//printInfo()호출, existAt()메서드 호출하기
		House h4=new House();
		h4.owner="현대";
		h4.room=5;
		h4.addr="여기저기요기";
		h4.printInfo();
		String info=h4.existAt(336);//existAt이 String타입이기 때문에 String으로 받아온다.
		System.out.println(info);
		
		System.out.println(h2.existAt(1000));
		
		String sss=h1.rent(1, 5000);
		System.out.println(h2.rent(2, 2000));
		System.out.println(h4.rent(3, 200));
	}

}
