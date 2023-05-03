package day04;
/*
 * [1] 구직자 클래스 구성
 *	-속성: 3개 이상
 *	-메서드: 2개 이상
 *[2] 회사 클래스 구성
 *	-속성: 3개이상
 *	-메서드: 2개 이상
 * */
public class JobKoreaTest {
	public static void main(String[] args) {
		//구직자 객체 2개 생성해서 속성값 주고 메서드 호출하기
		JobSeeker js1=new JobSeeker();
		js1.name="홍길동";
		js1.age=20;
		js1.field="WebDeveloper";
		js1.salary=4000;
		String intro=js1.introduce();
		System.out.println(intro);
		String[] profiles= {"학사관리 프로젝트 2년", "금융 프로젝트 3년"};
		String str=js1.projects(profiles);
		System.out.println(str);
		
		JobSeeker js2=new JobSeeker();
		js2.name="홍길서";
		js2.age=30;
		js2.field="AppDeveloper";
		js2.salary=6000;
		System.out.println(js2.introduce());
		String[] profiles2= {new String("유니콘 프로젝트 1년")};
		System.out.println(js2.projects(profiles2));
		
		System.out.println("------------------------------------------");
		//회사 객체 2개 생성해서 속성값 주고 메서드 호출하기
		Company c1=new Company();//생성자 호출
		c1.info();//초기화된 값 출력
		c1.name="네이버";
		c1.year=1980;
		c1.employees=1000;
		c1.info();//변경된 값 출력
		
		
	}

}
