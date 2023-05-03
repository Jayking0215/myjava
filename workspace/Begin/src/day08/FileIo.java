package day08;
//예외처리 Handler방식-->throws
//파일을 읽어서 콘솔에 출력하는 프로그램
//[1] try ~ catch
//[2] throws
/*  Exception
* 		|
* 	IOException
* 		+-------FileNotFoundException
* */
import java.io.*;//입출력과 관련된 pakage
import javax.swing.JOptionPane;
//[1]try~catch로 처리
//  C:\myjava\workspace\Begin\src\day05\A0_Cafe.java...절대경로
//  ./src/day05/A3_Superman.java
public class FileIo {
	
	public static String reading(String fileName) {//fileName매개변수를 받는 static메서드
		System.out.println("-----"+fileName+"-----");
		String content="";
		FileReader fr=null;//파일의 내용을 읽어들이는 FileReader생성
		char[] data=new char[1000];//파일데이터를 담을 배열_1000자
		
		try{//try~catch 선언 위치는 오류가 발생하는 부분!
			
			fr=new FileReader(fileName);//FileReader생성자...file과 node연결
			//FileNotFoundException
			
			int n=fr.read(data,0,1000);//data 0자~100자까지...파일을 읽어서 data배열에 담는다
			//IOException..입출력예외
			
			fr.close();//파일 리소스를 반환...반드시 실행되어야 하는 코드
			//IOException
			
		}catch(FileNotFoundException e) {
			System.out.println(fileName+"파일을 찾을 수 없습니다");
		}catch(IOException e) {
			System.out.println("파일 입출력 오류발생: "+e);
		}
		
		content=new String(data, 0, data.length);//0~data.length까지
		return content;
	}//reading()
	
	public static void main(String[] args) {
		String fname=JOptionPane.showInputDialog("읽을 파일명을 입력하세요");
		if(fname==null) {
			return;
		}
		String str=reading(fname);
		System.out.println(str);
	}//main()

}
