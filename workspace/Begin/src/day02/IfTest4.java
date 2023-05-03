package day02;

import javax.swing.JOptionPane;

public class IfTest4 {

	public static void main(String[] args) {
		String str=JOptionPane.showInputDialog("0~9, 또는 Alphabet 또는 기타문자 1개를 입력하세요");
		//let str=prompt와 같은것
		
		System.out.println("str: "+str);
		//public char charAt(int index):특정 index위치의 문자를 1개 추출하여 반환하는 String클래스 메서드
		
		System.out.println("Hello의 [1]: "+"Hello".charAt(1));
//		[1]
		//입력한 값의 첫번째 문자 1개 0~9사이의 값이면 "숫자입니다"출력
		//"A~Z" or "a~z"이면 "Alphabet입니다"출력
		//그 외 문자이면 "기타 문자입니다."출력
		if(str==null){
			System.out.println("nope");
			return;
		}//유효성체크
		
		char c=str.charAt(0);
		
//		int code = (int)JOptionPane.showInputDialog("ddd").charAt(0); //아스키코드 활용(char를 int로 형변환하면 아스키코드로 반환됨)
		if(c>='0' && c<='9') {
			System.out.println("숫자입니다");
		}else if((c>='a' && c<='z') || (c>='A' && c<='Z')) {
			System.out.println("Alphabet입니다.");
		}else {
			System.out.println("기타 문자입니다.");
		}
		
		//java.lang.Character클래스의 메서드를 이용해서 이 문제를 풀어봅시다.
		//static boolean	isAlphabetic(int codePoint): 알파벳 여부 판별
		//static boolean	isDigit(char ch): 숫자여부 판별
		//static boolean	isLowerCase(char ch):알파벳 소문자 true
		//static boolean	isUpperCase(char ch): 알파벳 대문자 true
		
		/*   기본자료형		Wrapper 클래스
		 * ----------------------------------
		 * 	byte			Byte
		 *  short			Short
		 *  char			Character
		 *  int				Integer
		 *  long			Long
		 *  float			Float
		 *  double			Double
		 *  boolean			Boolean
		 *  ----------------------------------
		 * 
		 * */
		//API활용
		if(Character.isDigit(c)) {
			System.out.println("숫자입니다.");
		}else if(Character.isLowerCase(c) || Character.isUpperCase(c)) {
			System.out.println("알파벳입니다.");
		}else {
			System.out.println("기타 문자입니다.");
		}
	}

}
