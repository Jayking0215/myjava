package day06;//GUI연습

import javax.swing.*;
import java.awt.*;
/*
 * 컨테이너
 * Window
 * 	ㄴFrame계열(default레이아웃: BorderLayout) 
 *  ㄴPanel계열(default레이아웃: FlowLayout)
 *  
 *  LayoutManager
 *  -BorderLayout : 동 서 남 북 중앙의 영역을 지정해서 컴포넌트를 붙여 배치
 *  	영역을 지정하지 않으면 default로 중앙에 붙인다
 *  -FlowLayout
 *  -GridLayout
 *  -CardLayout
 * */

public class MyBorderDemo extends JFrame{
	
	Container cp;
	JPanel p;
	
	JButton b1, b2, b3, b4, b5;
	
	public MyBorderDemo() {
		super("::MyBorderDemo::");//JFrame의 string 메서드 불러옴:문자열이 제목에 출력된다
		cp=this.getContentPane();//컨텐트페인=>BorderLayout
		p=new JPanel();//컨테이너=>FlowerLayout(중앙 정렬이 기본)
		cp.add(p);
		
		//패널에 배경색
		p.setBackground(Color.white);
		
		BorderLayout b=new BorderLayout(10,10);//hgap, vgap
		p.setLayout(b);
		
		b1=new JButton("b1");
		b2=new JButton("b2");
		b3=new JButton("b3");
		b4=new JButton("b4");
		b5=new JButton("b5");
		
		p.add(b1, BorderLayout.NORTH); 
		p.add(b2, BorderLayout.SOUTH);
		p.add(b3, BorderLayout.EAST); 
		p.add(b4, "West");
		p.add(b5, "Center");
		
		//창닫기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//MyBorderDemo

	public static void main(String[] args) {
		MyBorderDemo my=new MyBorderDemo();
		my.setSize(500, 500);
		my.setVisible(true);
		
	}//main()

}//
