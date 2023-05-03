package day08;
//복수의 예외처리
/*
 * try블럭 하나에 catch블럭을 여러 개 사용할 수 있다.
 * 이 때 주의사항. 자식 예외를 먼저 catch하고
 * 부모 예외를 나중에 catch해야 한다.
 * 
 * try{
 * }catch(){
 * }finally{
 * }//반드시 한번은 수행하는 블럭..위에 return문이 있어도 finally블럭 실행 뒤 return됨
 * */
public class ExceptionTest4 {
	public static void main(String[] args) {
		//명령줄 인수 2개를 받아 나눗셈 수행...run Configures-arguments
		try {
		//[1]ArrayIndexOutOfBoundsException
			String str1=args[0];
			String str2=args[1];
			System.out.println("arg[0]: "+str1);
			System.out.println("arg[1]: "+str2);
			
			//정수로 변환
			int num1=Integer.parseInt(str1);//[2]NumberFormatException
			int num2=Integer.parseInt(str2);
			System.out.printf("%d/%d=%d%n",num1,num2,(num1/num2));
			//[3]ArithmeticException
			
			String str3=null;
//			String str3="null";
			System.out.println(str3.toUpperCase());
			//[4]NullPointerException
			
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("명령줄 인수 2개를 입력하세요");
			System.out.println("java day08.ExceptionTest4 10 5");
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력해야 해요!");
//			System.exit(-1);//시스템 종료 코드...finally{}수행 안됨
//			return;
		}catch(ArithmeticException e) {
			System.out.println("분모가 0이 되어선 안돼요!!");
		}catch(Exception e){//모든 예외를 catch함..예상치 못한 예외 발생...가장 마지막에 입력해야함(다른 예외 수행불가)
			System.out.println("기타 예상하지 못한 예외 발생: "+e);//에러 메세지 출력
		}finally {
			System.out.println("##반드시 실행되어야 할 코드 ###");
		}
		System.out.println("---The End---");
	}//main()
}
//args없을때: ArrayIndexOutOfBoundsException
//args에 문자열 입력: NumberFormatException
//args..0으로 나눌때: ArithmeticException