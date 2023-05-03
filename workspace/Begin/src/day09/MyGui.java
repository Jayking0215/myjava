package day09;
//이름없는 local inner클래스 사용 예제-Anonymous class; 
//GUI 이벤트 처리에서 자주 사용됨-->나중에 람다식 이해하는데 필수
//비슷한 기능을 하는 이벤트를 모아서 관리할 수 있음
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//[1]
/*
 * JButton ==> ActionEvent 발생 ==> ACtionListener상속 ==> void actionPerformed(ActionEvent) 추상매서드
 * 
 * JRadioButton ==> ItemEvent 발생 ==> ItemListener상속 ==> void itemStateChanged(ItemEvent) 추상매서드
 * */
/*이벤트핸들러 구성하는 방법
 * [1] 컴포넌트를 가진 클래스가 이벤트핸들러가 되는 방법
 * [2] 이너 클래스로 구성하는 방법
 * 		- 이너 멤버 클래스[v]
 *      - 이름없는 로컬 클래스
 * [3] 외부 클래스로 구성하는 방법
 * */

public class MyGui extends JFrame {

	Container cp;
	JPanel p = new JPanel();
	JPanel pN=new JPanel();

	JRadioButton r,g,b;
	ButtonGroup gr=new ButtonGroup();
	Canvas can;
	
	public MyGui() {
		super("::MyGui::");
		cp = this.getContentPane();
		cp.add(p, "Center");
		cp.add(pN, "North");
		p.setBackground(Color.white);
		
		pN.add(r=new JRadioButton("Red"));
		pN.add(g=new JRadioButton("Green"));
		pN.add(b=new JRadioButton("Blue"));

		gr.add(r);//그룹화;단일선택 
		gr.add(g);
		gr.add(b);
		
		can=new Canvas();//도화지 역할의 컴포넌트; 사이즈와 배경색 필요
		can.setSize(200,200);//w,h
		can.setBackground(Color.yellow);
		p.add(can);
		
		//리스너 부착
//		r.addItemListener(this);//inner클래스가 implements했기때문에 this[x]
//		MyGui.MyEventHandler han=this.new MyEventHandler();//fm식
		MyEventHandler handler=new MyEventHandler();//약식 객체생성
		r.addItemListener(handler);
		g.addItemListener(handler);
		b.addItemListener(handler);
		
		
		//창닫기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자
	
	
	//inner member클래스로 이벤트 핸들러 구성
	class MyEventHandler implements ItemListener{//이너맴버 클래스
		@Override//어노테이션
		public void itemStateChanged(ItemEvent e) {
//			setTitle("@@@");//이벤트처리 확인용
			Object obj=e.getSource();//이벤트가 발생한 객체를 받아옴
			if(obj==r) {
				can.setBackground(Color.red);
			}else if(obj==g) {
				can.setBackground(Color.green);
			}else if(obj==b) {
				can.setBackground(Color.blue);
			}
		}//
	}

	public static void main(String[] args) {
		MyGui my = new MyGui();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}
