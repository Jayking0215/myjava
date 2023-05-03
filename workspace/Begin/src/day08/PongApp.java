package day08;
//사용자 정의 예외 사용하기
import javax.swing.*;

public class PongApp {
	
	public static void login(String name) throws NotSupportedNameException{
		//Pong씨 성이면 "환영합니다 XXX님" 콘솔에 출력
		//Cong씨 성이면 "콩씨는 절대로 로그인 불가!!"콘솔에 출력 => 예외상황
		//기타 성이면 "기타 성씨 분들은 이용에 제한이 있어요"출력=>예외상황
		//boolean startsWith(String str)//어떤 문자열로 시작하는지 묻는 것<->boolean endsWith(String str)
		if(name.startsWith("퐁")) {
			System.out.println(name+"님 환잉꽌링~");
		}else if(name.startsWith("콩")) {
			throw new NotSupportedNameException("콩씨는 절대로 로그인 불가!!!");//throw와 throws가 항상 같이 쓰인다.
		}else {
			throw new NotSupportedNameException("퐁씨 이외의 기타 성씨는 이용에 제한이 있어요");//예외를 발생시킴
		}
		
	}
	public static void main(String[] args) {
		String name=JOptionPane.showInputDialog("로그인 이름을 입력하세요");
		if(name==null) {
			return;
		}
		try {
			PongApp.login(name);
		}catch(NotSupportedNameException e){
			//public String getMessage();
			String msg=e.getMessage();
			System.out.println(msg);
			e.printStackTrace();//스택기록을 알고자할때 사용
		}
	}
}
