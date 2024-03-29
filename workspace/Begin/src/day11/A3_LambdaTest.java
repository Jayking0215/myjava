package day11;
//Lambda연슴

//추상메서드가 1개인 인터페이스는 함수형 인터페이스로 선언할 수 있다.
//함수형인터페이스에 있는 메서드들은 람다식으로 구현할 수 있다.
@FunctionalInterface
interface MyNum{
	int getMax(int a, int b);//추상메서드 생성
}

public class A3_LambdaTest {
	public static void main(String[] args) {
		MyNum my=(x,y)->{//Lambda식:익명함수 override라고 생각
			if(x>=y)
				return x;
			else
				return y;
		};
		int num=my.getMax(11,50);
		System.out.println(num);
		
		MyNum my2=(a,b)->a+b;
		System.out.println(my2.getMax(11,50));
	}//main()
}
