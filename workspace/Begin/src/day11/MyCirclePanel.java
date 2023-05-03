package day11;
import javax.swing.JPanel;
import java.awt.*;
public class MyCirclePanel extends JPanel {//class생성시 super class->javsx_swing_JPanel(없어서 선택 못했음)
	
	int x=50, y=150;//도형 움직임을 위한 변수 선언
	
	@Override//어노테이션
	public void paint(Graphics g) {//그림그리는 도구상자 Graphics
		super.paint(g);//오버라이드 되었기때문에 super로 JPanel의 paint호출..부모요소 super해주는게 좋다.
		g.setColor(Color.blue);
//		g.drawRect(50,50,100,100);//x,y,w,h..선사각형
		g.fillRect(x, y, 100, 100);//면사각형
	
		g.setColor(Color.yellow);
//		g.drawOval(50,50,100,100);//선 원
		g.fillOval(x, y, 100, 100);//면 원
		//g.drawImage()//이미지 넣기
	}
}
