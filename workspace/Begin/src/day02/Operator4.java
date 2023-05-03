package day02;

public class Operator4 {

	public static void main(String[] args) {
		System.out.println("8. 논리 연산자(&, &&, |, ||)----------");
		/* 1)2) &, |
		   : 앞의 연산으로 결과를 알 수 있어도 뒤의 문장까지 비교한다.
     	   3)4) &&, ||
		   : &&의 경우 앞의 연산 결과가 false라면 뒤의 연산을 생략한다.
			 ||의 경우는 앞의 연산결과가 true라면 뒤의 연산을 생략한다.
		*/
		
		//[1] 결과예측하기
		int i=1;
		int j=i++;//j=1, i=2
		if(i>++j && (i++ == j)) {// j=2,i=2 && j=2,i=2->i=3
			i=i+j;//2
		}else if(i>++j & (i++ == j)) {
			i=i+j;//3
		}
		System.out.println("i="+i);
		
		//[2]
		int k=0, p=1;
		if((k++ ==0)||(p++ ==2)) {
			k=42;
		}
		System.out.println("k="+k+", p="+p);//||연산이기 때문에 뒷 연산은 수행x 따라서 p=1
		
		
		
	}

}
