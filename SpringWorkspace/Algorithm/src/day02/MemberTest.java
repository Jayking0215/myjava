package day02;

import java.util.Arrays;

public class MemberTest {

	public static void main(String[] args) {
		Member m1=new Member("홍길동",22, 177);
		Member m2=new Member("홍길동",22, 177);
		Member m3=new Member("홍길동",22, 178);
		
		Member m4=new Member("김길동",27,156);
		Member m5=new Member("이길동",20,165);
		Member m6=new Member("김철수",37,186);
		
		// == : 주소값 비교
		// equals(): 주소값 비교 ==> 오버라이드 하면 달라질 수 있다.
		System.out.println(m1==m2);
		System.out.println(m1==m3);
		
		System.out.println(m1.equals(m2));
		System.out.println(m1.equals(m3));
		
		Member arr[]= {m1,m2,m3,m4,m5,m6};
		System.out.println(Arrays.toString(arr));
		System.out.println("--sort이후--------------------------------------------");
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
	}

}
