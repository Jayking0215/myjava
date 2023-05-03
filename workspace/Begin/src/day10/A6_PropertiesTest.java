package day10;

import java.util.*;
import java.io.*;//입출력을 위한 패키지
/*
 * Properties객체
 * - Map계열...==key, value로 이루어진 자료구조
 * - Hashtable의 자식 클래스
 * - ~~~.properties유형의 파일을 읽어서 해당 파일에 저장된 내용을 객체로 옮기고자 할때 사용한다.(주로 server개발에서)
 * */
public class A6_PropertiesTest {

	public static void main(String[] args) throws Exception{//부모예외처리..귀찮아서
		Properties prop=new Properties();
		System.out.println(prop);
		
		//database.properties파일을 읽어서 prop객체로 옮겨보자
		prop.load(new FileReader("src/day10/database.properties"));//FileNotFind Exception
		System.out.println("파일 로드 후------------");
		System.out.println(prop);
		String db=prop.getProperty("DbType");//ket값을 주면 value값을 불러옴
		String user=prop.getProperty("DbUser");
		String pwd=prop.getProperty("DbPwd");
		prop.setProperty("os", "Mac");//key값, value값
		String os=prop.getProperty("os","Windows");//os값이 없을 경우 default Windows로 한다
		System.out.println(db);
		System.out.println(user);
		System.out.println(pwd);
		System.out.println(os);
	}

}
