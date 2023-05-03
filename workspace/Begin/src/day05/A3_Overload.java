package day05;

public class A3_Overload {
	public static void main(String[] args) {
		//슈퍼맨 객체 3개 생성후 showInfo()로 출력하기
		A3_Superman s1=new A3_Superman();
		String str=s1.showInfo();//기본생성자를 지정해줬기 때문에 default값이 지정값으로 출력됨
		System.out.println(str);
		
		A3_Superman s2=new A3_Superman("최슈퍼");
		System.out.println(s2.showInfo());
		
		A3_Superman s3=new A3_Superman("장슈퍼",177, 500);
		System.out.println(s3.showInfo());
	
		//아쿠아맨 객체 2개 생성 후 showInfo() 출력
		//	A3_Aquaman a1=new A3_Aquaman();//기본생성자 없어서 빈 매개변수는 오류 발생
		A3_Aquaman a1=new A3_Aquaman("이생선");
		System.out.println(a1.showInfo());
		
		A3_Aquaman a2=new A3_Aquaman("하생선", 170, 78.234);
		System.out.println(a2.showInfo());
		
		//슈퍼맨을 저장할 배열을 생성하고 저장한 뒤 반복문돌려 정보 출력하기
		A3_Superman arrSup[]= {s1,s2,s3};
		System.out.println("********************");
		for(int i=0; i<arrSup.length; i++) {
			String info=arrSup[i].showInfo();//arrSup[i]의 showInfo가 문자열로 반환되고 String타입으로 받아서 출력
			System.out.println(info);
		}
		
		//슈퍼맨과 아쿠아맨을 모두 저장할 배열
		//모든 class의 부모는 Object으로 배열을 만들면 모든 class 저장 가능
		//부모타입[] 변수={자식객체들...}
		Object[] arrObj={a1, a2, s1, s2, s3};
		A3_Aquaman am=(A3_Aquaman)arrObj[0];//자식타입으로 강제 형변환
//		자식:작은자료형=(자식유형)Object유형(부모:큰유형
		System.out.println(am.showInfo());//=>부모class가 자식class 매서드 사용 가능해짐
		
		//instanceof 연산자(객체의 타입을 확인할 수 있다)
		//사용법: 참조변수 instanceof 클래스명 : 변수가 class의 객체면 true반환, 아니면 false반환
		for(int i=0; i<arrObj.length; i++) {
//			String info=arrObj[i].showInfo();[x] -> arrObj가 가진 메서드가 아니라서 실행 불가
			if(arrObj[i] instanceof A3_Aquaman) {
				A3_Aquaman aman=(A3_Aquaman)arrObj[i];
				System.out.println(aman.showInfo());
			}else {//슈퍼맨 객체
				A3_Superman supman=(A3_Superman)arrObj[i];
				System.out.println(supman.showInfo());
			}//if
		}//for
	}//main()
}//class
