package day11;
//Lambda연습 2

@FunctionalInterface
interface MyFunc{
	//매개변수, 반환값 없는 lambda식
	void foo();
}//
@FunctionalInterface
interface YourFunc{
	//매개변수가 있는 lambda식
	void bar(int a);
	
}//
@FunctionalInterface
interface HerFunc{
	//매개변수, 반환값 있는 lambda식
	int baz(int x, int y);
}//

public class A3_LambdaTest2 {

	public static void main(String[] args) {
		//[1] 
		MyFunc mf=()->{System.out.println("@@@");};//foo()람다 구현...함수 호출에 생성자 필요
		mf.foo();//mf호출
		
		//[2]
		YourFunc yf=(b)->{System.out.println(b*5);};
		yf.bar(8);
		
		YourFunc yf2=a->System.out.println(a-3);
		yf2.bar(8);
		
		//[3]
		HerFunc hf=(x, y)->(int)Math.pow(x, y);
		int z=hf.baz(2, 6);
		System.out.println("2의 6제곱은: "+z);
	}//main()

}
