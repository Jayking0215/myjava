package day01;

public class Primivite2 {
	public static void main(String[] args) {
		System.out.println("2. 실수형----------");
		//float < double
		//float(4byte): 단정밀도, 소수점 이하 7자리
		//double(8byte): 배정밀도, 소수점 이하 15~16자리(default)
		
		float ft1=10.1234F;
		float ft2=800;//promotion(자동형변환): 작은 유형에서 큰 유형으로 자동을 형변환(casting)이 일어난다
		System.out.printf("ft1=%f%n",ft1);
		System.out.printf("ft2=%f%n",ft2);
		
		float ft3=.789F;
		System.out.println("ft3="+ft3);
		
		double db1=123.456789;
		double db2=1233.42789;
		System.out.println("db1="+db1);
		System.out.println("db2="+db2);
		
		//과학적 지수 표기방법: E
		double db3=3e-2;//3*10^-2
		double db4=3e+2;//3*10^2
		System.out.println("db3="+db3);
		System.out.println("db4="+db4);
	
		//float타입 변수 선언하고 900E7 출력
		float ft4=900E7F;
		System.out.println("ft4="+ft4);
		
		//promotion: byte < short < int < long < float < double
		byte b=50;
		float c=1.2f;
		//변수 선언해서 b*c의 값을 저장
		float multi=(float)(b*c);
		System.out.printf("%d*%f=%f%n",b,c,multi);
	}
}
