package day09;
//이름없는 local inner클래스 사용 예제-Anonymous class; 
//GUI 이벤트 처리에서 자주 사용됨-->나중에 람다식 이해하는데 필수
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
 * 		- 이너 멤버 클래스
 *      - 이름없는 로컬 클래스[v]
 * [3] 외부 클래스로 구성하는 방법
 * */

public class MyGui2 extends JFrame {

	Container cp;
	JPanel p = new JPanel();
	JPanel pN=new JPanel();

	JRadioButton r,g,b;
	ButtonGroup gr=new ButtonGroup();
	Canvas can;
	
	public MyGui2() {
		super("::MyGui2::");
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
		//Anonymous class로 이벤트 핸들러 구성
		r.addItemListener(new ItemListener() {/*Anonymous class가 됨...1회용*///해당 radiobutton전용 이벤트 핸들러
			@Override
			public void itemStateChanged(ItemEvent e) {
				can.setBackground(Color.red);
			}
		});//@@Listener는 인터페이스; 추상매서드와 상속만 갖는데 new를 받음..{}붙이고 오버라이드 해줘야함
		g.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				can.setBackground(Color.green);
			}
		});
//		b.addItemListener(new ItemListener() {
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				can.setBackground(Color.blue);
//			}
//		});
		//Lamda식
		b.addItemListener(e->{can.setBackground(Color.blue);});//추상 매서드가 1개인것만 Lamda적용 가능
		
		//창닫기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자

	public static void main(String[] args) {
		MyGui2 my = new MyGui2();
		my.setSize(500, 500);
		my.setVisible(true);
	}

}
