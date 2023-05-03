package day06;

public class A2_Polymorphism {

	public static void main(String[] args) {
		Human h1=new Human();
		h1.name="홍길동";
		h1.height=177;
		System.out.println(h1.showInfo());
		
		Superman s1=new Superman("김슈퍼맨", 180, 100);//A1_Inheritance class에서 Superman생성자를 만들어놨기 때문에 바로 객체 입력 가능
		String str=s1.showInfo("***슈퍼맨 정보***");
		System.out.println(str);
		
		Aquaman a1=new Aquaman("참치", 150, 80.5);
		a1.showInfo(10);
		
		//다형성
		/*부모와 자식의 상속관계를 맺을 경우
		 * 부모타입의 변수를 선언하고 자식의 객체를 생성하는 것이 가능하다.
		 * 그러나 그 참조 변수로 참조할 수 있는 범위는 제한이 있다.(부모의 변수나 메서드만 접근 가능)
		 * */
		Human hs=new Superman("최슈퍼맨",165,700);//현업에서 다형성 방식으로 객체 생성함
		System.out.println("hs.name="+hs.name);
		System.out.println("hs.height="+hs.height);
//		System.out.println("hs.power="+hs.power);//[x]
		System.out.println(hs.showInfo());//자식class의 오버라이딩한 메서드가 있을경우 그 오버라이딩한 메서드를 우선 호출
		System.out.println("s1.power="+s1.power);
		
		System.out.println(((Superman)hs).power);//자식타입으로 형변환 후 객체 불러올 수 있음...
		System.out.println(((Superman)hs).showInfo("###슈퍼맨 정보###"));
		
		
		//문제[1]
		//Human타입으로 변수 선언하고 Aquaman객체 생성하기
		//이름, 키, 스피드
		//showInfo()호출해보기
		Human ha=new Aquaman("갈치",50,15.4);
		System.out.println(((Aquaman)ha).showInfo());
		
		//문제[2]
		//h1,s1,a1,hs, ha 들을 저장할 배열을 선언하고 메모리 할당한 뒤 저장하세요
		//반복문 이용해서 배열에 저장된 객체들을 꺼내서 정보를 출력하세요
		Human[] arr={h1, s1, a1, hs, ha};//부모타입으로 모두 배열에 저장 가능
		for(int i=0; i<arr.length; i++) {
			System.out.println("******************");
			System.out.println(arr[i].showInfo());
		}
		
		//instanceof 연산자 이용해서 적절히 형변환하여 타이틀과 정보를 출력
		for(Human hm:arr) {
			if(hm instanceof Superman) {
				System.out.println(((Superman)hm).showInfo("@@@슈퍼맨 정보@@@"));
			}else if(hm instanceof Aquaman) {
				((Aquaman)hm).showInfo(10);
			}
			System.out.println(hm.showInfo());
		}
		
	}//main()

}//
