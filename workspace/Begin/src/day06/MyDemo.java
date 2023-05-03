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
 *  -BorderLayout
 *  -FlowLayout
 *  -GridLayout
 *  -CardLayout
 * */

public class MyDemo extends JFrame{
	
	Container cp;
	JPanel p;
	
	JButton b1, b2, b3, b4;
	
	public MyDemo() {
		super("::MyDemo::");//JFrame의 string 메서드 불러옴:문자열이 제목에 출력된다
		cp=this.getContentPane();//컨텐트페인=>BorderLayout
		p=new JPanel();//컨테이너=>FlowerLayout(중앙 정렬이 기본)
		cp.add(p);
		
		//패널에 배경색
		p.setBackground(Color.white);
		
		//JPanel의 레이아웃 설정
		//FlowLayout(int align)
		//FLowLayout(int align, int hgap, int vgap)//컴포넌트 사이 간격
		FlowLayout fl=new FlowLayout(FlowLayout.RIGHT, 20, 50);
		p.setLayout(fl);
		//컴포넌트를 붙이기 전에 레이아웃을 설정해야한다
		
		b1=new JButton("b1");
		b2=new JButton("b2");
		b3=new JButton("b3");
		b4=new JButton("b4");
		
		p.add(b1); p.add(b2);
		p.add(b3); p.add(b4);
		
		//창닫기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//MyDemo

	public static void main(String[] args) {
		MyDemo my=new MyDemo();
		my.setSize(500, 500);
		my.setVisible(true);
		
	}//main()

}//
