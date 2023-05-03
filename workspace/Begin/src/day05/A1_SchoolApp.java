package day05;
/*학사 관리 프로그램

학생: 학번(no), 이름(name), 학급명(className) ==> Student
강사: 교번(no), 이름(name), 과목(subject) ==> Teacher
직원: 사번(no), 이름(name), 부서(dept) ==> Staff

==> 추상화(캡슐화)하고, 속성(멤버변수)을 모두 캡슐화한 뒤
      setter, getter를 구성하세요
      
      ShowInfo()메서드 구성해서 각 정보 출력하기
*/
public class A1_SchoolApp {
	public static void main(String[] args) {
		//Student, Teacher, Staff객체 생성해서 값 할당하고 출력
		A1_Student s1=new A1_Student();//기본생성자
//		s1.showInfo();//현재는 저장된 값이 없어서 기본값이 출력됨
		s1.setNo(1);
		s1.setName("김학생");
		s1.setClassName("백앤드 개발자반");
		
		s1.showInfo();
		
		A1_Teacher t1=new A1_Teacher();
		t1.setNo(100);
		t1.setName("김교사");
		t1.setSubject("Java");
		t1.showInfo();
		
	// 문제1]학생 객체를 2개 더 생성하고...
	// 각각 이름,학번,학급 값을 넣어준뒤...
		A1_Student s2=new A1_Student();
		s2.setNo(2);
		s2.setName("이학생");
		s2.setClassName("프론트앤드 개발자반");
		
		A1_Student s3=new A1_Student();
		s3.setNo(3);
		s3.setName("박학생");
		s3.setClassName("웹 개발자반");
	// 3명의 학생을 배열에 저장하자.
		A1_Student[] arr=new A1_Student[3];
		arr[0]=s1;
		arr[1]=s2;
		arr[2]=s3;
//		arr[2]=new A1_Student();//변수이름 선언 없이 기본형 저장
//		arr[2].setNo(5);
//		arr[2].setName("최학생");
//		arr[2].setClassName("빅데이터반");
		
	// for루프 돌리면서 저장된 학생 객체들의 정보를 출력해보자.
		for(int i=0; i<arr.length; i++) {
			arr[i].showInfo();
		}
//		//확장 for
//		for(A1_Student s:arr) {
//			s.showInfo();
//		}
		
		//Teacher도 출력해보기
		A1_Teacher t2=new A1_Teacher();
		t2.setNo(101);
		t2.setName("James");
		t2.setSubject("HTML");
		
		A1_Teacher[] arr2= {t1, t2};
		
		for(A1_Teacher t: arr2) {
			t.showInfo();
		}
		//복습-staff 출력해보기
		
	
	}//main()
}//class
