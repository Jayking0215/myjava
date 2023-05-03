package day06;

import javax.swing.*;
import java.awt.*;
//GridLayout: 행과 열의 형태로 배치
public class MyGridDemo extends JFrame{

	Container cp;
	JPanel p=new JPanel();
	JButton[] b=new JButton[6];
	
	JPanel p1_1,p1_2;	
	JCheckBox c1;
	JButton bt;
	
	public MyGridDemo() {
		super("::MyGridDemo::");
		cp=this.getContentPane();
		cp.add(p);
		
		p.setLayout(new GridLayout(4,2,10,10));//행, 열, hgap, vgap
		
		//배열의 버튼객체 생성 후 배정하고 p에 붙이기
		for(int i=0; i<b.length; i++) {
			b[i]=new JButton("b"+(i+1));
			p.add(b[i]);
		}
		p1_1=new JPanel();//FlowLayout 오른쪽 정렬
		p1_2=new JPanel();//FlowLayout 왼쪽 정렬
		p1_1.setBackground(Color.white);
		p1_2.setBackground(Color.darkGray);
		
		p1_1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p1_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		p.add(p1_1);
		p.add(p1_2);
		
		c1=new JCheckBox("동의 합니다",true);
		p1_1.add(c1);
		c1.setBackground(Color.white);
		
		p1_2.add(bt=new JButton("Submit"));
		
		//창닫기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MyGridDemo my=new MyGridDemo();
		my.setSize(500,500);
		my.setVisible(true);
	}

}
