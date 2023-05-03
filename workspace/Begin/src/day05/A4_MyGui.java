package day05;
//GUI(Graphic User Interface): 윈도우 애플리케이션
//CLI(Command Line Interface): 콘솔 애플리케이션

//윈도우 프로그램 ==> java.swing.JFrame을 상속받아 구현
//사이즈를 주고, setVisible(true)를 해야 육안으로 확인 가능
import javax.swing.*;
import java.awt.*;

//JPanel을 생성해서 JFrame이 가지고있는 Container에 붙이고
//JButton을 생성해서 JPanel에 붙이기
public class A4_MyGui extends JFrame {
	
	JButton b1,b2,b3,b4;//Component(부품)
	JPanel p;//Container
	//기본생성자 구성
	Container cp;
	ImageIcon icon1, icon2, icon3, icon4;
	
	//javax.swing패키지 api보면서 p에 객체 생성해서 붙여보기->생성자에서
	JTextField tf1, tf2;
	JCheckBox c1, c2, c3;// Java, HTML, CSS
	JRadioButton r1, r2;//Male, Female
	JTextArea ta1;
	
	public A4_MyGui() {
		cp=getContentPane();//Container를 반환하는 getter메서드
		p=new JPanel();//Panel:일종의 Container
		p.setBackground(Color.white);
		cp.add(p);
		
		//이미지 선언
		icon1=new ImageIcon("./images/icon1.png");
		icon2=new ImageIcon("./images/icon2.png");
		icon3=new ImageIcon("./images/icon3.png");
		icon4=new ImageIcon("./images/icon4.png");
		
		//버튼 생성
		b1=new JButton("Home");
		b2=new JButton("Login");
		b3=new JButton(icon1);
		b4=new JButton("Join", icon2);
		
		//버튼 색 입히기
		b1.setBackground(Color.white);
		b2.setBackground(Color.white);
		b3.setBackground(Color.white);
		b4.setBackground(Color.white);
		
		//버튼 텍스트 위치 바꾸기
		b4.setHorizontalTextPosition(JButton.CENTER);
		b4.setVerticalTextPosition(JButton.BOTTOM);
		
		//버튼 클릭시 아이콘 변경
		b4.setPressedIcon(icon3);
		//버튼 hover시 아이콘 변경
		b4.setRolloverIcon(icon1);
		
		//panel에 버튼 붙이기
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		
		tf1=new JTextField(20);
		tf2=new JTextField("네이버를 검색해봐", 20);
		p.add(tf1);
		p.add(tf2);
		
		c1=new JCheckBox("Java");
		c2=new JCheckBox("HTML", true);
		c3=new JCheckBox("CSS", false);
		p.add(c1);
		p.add(c2);
		p.add(c3);
		
		r1=new JRadioButton("Male");
		r2=new JRadioButton("Female");
		p.add(r1);
		p.add(r2);
		//단일체크로 변경=ButtonGroup객체에 add
		ButtonGroup group=new ButtonGroup();
		group.add(r1);
		group.add(r2);
		
		ta1=new JTextArea(7, 20);
//		p.add(ta1);[x]
		JScrollPane sp=new JScrollPane(ta1);//스크롤바 추가
		p.add(sp);
		//배경색
		ta1.setBackground(Color.lightGray);
		
		//창 닫기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로세스 종료
		
	}//생성자
	
	public static void main(String[] args) {
		A4_MyGui my=new A4_MyGui();
		my.setSize(500,500);//width, height
		my.setVisible(true);
		
	}

}//class
