package day09;
//이름있는 local 클래스
///////수업 파일과 비교수정
public class A2_Local {
	static String str="@";//string 타입의 맴버변수..인스턴스변수
	
	void sub(final String args) {//인스턴스 매서드 구성...매서드 안에 class가 들어갈 수 있다.
		
		String lstr="###";//지역변수
		//지역변수=> 로컬이너클래스에서 사용하려면 final이어야 한다.(값 수정 불가)==읽기전용
		//sub()의 매개변수도 마찬가지
		
		System.out.println("str: "+str);//인스턴스변수는 후발대..자기 맴버 출력 가능
		System.out.println("lstr: "+lstr);
		class A2_LocalInner extends javax.swing.JFrame{//Local Inner class-[1]이름있는 local inner클래스..지역변수와 비슷
			int no=90;
			void bar() {
				System.out.println("---LocalInner's bar()-----");
				System.out.println("no: "+no);//자기 맴버변수
				System.out.println("str: "+str);//A2_Local
				System.out.println("lstr: "+lstr);//A2_Local의 매서드
//				lstr="값을 변경할게요";//값변경 불가능..final 생략됨
			}
		}
		
		A2_LocalInner li=new A2_LocalInner();
		li.setSize(200,200);
		li.setVisible(true);
		li.bar();
		//LocalInner클래스는 소속된 메서드 내에서만 객체 생성이 가능하다
		//class를 구성한 후에 객체 생성가능
	}//sub()
	
	void demo() {
		class A2_LocalInner{
			
		}
	}//
	
	public static void main(String[] args) {
		//sub()호출하기
		A2_Local lc=new A2_Local();
		lc.sub(str);
		
//		A2_Local.A2_LocalInner ll=new A2_Local().new A2_LocalInner();//[x]..해당 로컬메서드 내에서만 생성 가능
		
	}
	
}//Local()
