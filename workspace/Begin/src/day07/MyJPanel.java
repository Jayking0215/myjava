package day07;

import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel{
	
	private int top, left, bottom, right;
	
	public MyJPanel() {
		top=left=bottom=right=10;
	}
	public MyJPanel(int top, int left, int bottom, int right) {
		this.top=top;
		this.left=left;
		this.bottom=bottom;
		this.right=right;
	}
	
	//바깥 여백을 반환하는 메서드
	@Override
	public Insets getInsets() {
		Insets in=new Insets(top, left, bottom, right);//반시계방향
		return in;
	}
}
