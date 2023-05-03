package day07;
//연습문제 7번
class A{
	
	@Override
	public String toString() {
		return "4";
	}
}//class A

class B extends A{
	
	@Override
	public String toString() {
		return super.toString()+"3";
	}
}//class B

public class A1_ObjectTest {

	public static void main(String[] args) {
		A a=new A();
		System.out.println(a);//주소값 반환->(Object으로부터 상속받은것을 override안해주면)
		System.out.println(a.toString());
		System.out.println("-------------------------");

		Object obj=new Object();
		System.out.println(obj);//obj의 주소값 반환
		System.out.println("-------------------------");
		System.out.println(new B());
		
		Object obj2=new Object();
		Object obj3=obj2;
		System.out.println("obj==obj2: "+(obj==obj2));//주소값 비교
		System.out.println("obj2==obj3: "+(obj2==obj3));
		System.out.println("obj.equals(obj2): "+(obj.equals(obj2)));//주소값 비교
		System.out.println("obj2.equals(obj3): "+(obj2.equals(obj3)));

		String s1=new String("Hi");
		String s2=new String("Hi");
		//String의 equals()는 문자열 내용 비교로 @오버라이딩 되어있다

		System.out.println("s1==s2: "+(s1==s2));//주소값 비교
		System.out.println("s1.equals(s2): "+(s1.equals(s2)));//문자열 내용 비교
		
		//literal방식 할당은 String type만 가능하다(String은 new, literal방식 모두 가능)
		String s3="Hi";//literal pool에 "Hi"를 할당
		String s4="Hi";//literal pool에 "Hi"가 있는지 찾고 해당 객체를 같이 참조...없으면 새로운 객체 생성
		System.out.println("s3==s4: "+(s3==s4));//literal방식은 상수로 인식하기 때문에 true 반환됨(literal메모리 pool에 저장하고(s3) 같은 literal이 있는지 확인하고 주소값을 따라간다(s4))
		System.out.println("s3.equals(s4): "+(s3.equals(s4)));
		
		
		
	}

}
