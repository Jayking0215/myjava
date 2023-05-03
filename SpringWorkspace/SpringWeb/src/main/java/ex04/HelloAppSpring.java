package ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloAppSpring {

	public static void main(String[] args) {
		String config="src/main/java/ex04/appContext.xml";//�������� ���
		ApplicationContext ctx=new FileSystemXmlApplicationContext(config);//������ �����̳�:�θ�Ÿ�� & �ڽİ�ü
		
		Message msg=ctx.getBean("mb2", Message.class);//Message.class�� ����ȯ
		msg.sayHello();
		msg.sayHi("����","ö��","����","BTS");
		
	}
}
