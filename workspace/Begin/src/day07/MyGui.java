package day07;
//이클립스 템플릿 만들기
//템플릿 불러오기: ctrl+space+"myswing"
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//awt의 서브패키지...서브패키지는 별도로 명시해야함//[1]import하기

/*이벤트 처리 절차
 * [1] import java.awt.event.*;
 * [2] XXXListener 인터페이스를 상속받는다 (ActionListener)
 * [3] 추상메서드를 오버라이딩한다. (빈블럭으로) => 이벤트 처리 메서드
 * [4] 이벤트소스에 리스너를 붙인다. addXXXListener()메서드 이용
 * 		=> b1.addActionListener(매개변수=핸들러객체)
 * [5] 오버라이딩한 메서드에 이벤트 처리코드를 구현
 * 
 * JButton=>ActionEvent==>ActionListener
 * 
 * 추상메서드
 * void actionPerformed(ActionEvent e)
 * */

public class MyGui extends JFrame implements ActionListener{//[2]ActionListener를 implements(인터페이스 상속) 

	Container cp;
	JPanel p = new JPanel();

	JButton btR,btG,btB;
	
	public MyGui() {
		super("::MyGui::");
		cp = this.getContentPane();//기본이 BorderLayout
		cp.add(p);//기본이 Center
		p.setBackground(Color.white);
		
		//리스너 부착[4]
		p.add(btR=new JButton("Red"));
		p.add(btG=new JButton("Green"));
		p.add(btB=new JButton("Blue"));
		btR.addActionListener(this);//this...자기자신을 구현
		btG.addActionListener(this);
		btB.addActionListener(this);
		
		//창닫기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자
	
	@Override
	public void actionPerformed(ActionEvent e) {//인터페이스는 public필수 [3]추상메서드 오버라이드, body일단 빈칸
		//이벤트 처리 코드 입력[5]
		Object obj=e.getSource();//이벤트가 발생한 이벤트소스의 주소값 반환
		if(obj==btR) {//==등가비교(주소값)
			p.setBackground(Color.red);			
		}else if(obj==btG) {
			p.setBackground(Color.green);			
		}else if(obj==btB) {
			p.setBackground(Color.blue);			
		}
	}

	public static void main(String[] args) {
		MyGui my = new MyGui();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}

