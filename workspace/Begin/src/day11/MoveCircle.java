package day11;
//Thread GUI로 확인해보기
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//awt의 서브패키지...서브패키지는 별도로 명시해야함

public class MoveCircle extends JFrame implements Runnable{//thread위해 runnable상속->추상메서드 생성
	//맴버변수
	Container cp;
	JPanel p = new JPanel();
	MyCirclePanel p2=new MyCirclePanel();//중앙에 붙이기
	JButton btStart, btStop;
	Thread tr;
	boolean isStop=false;//여러 쓰레드를 멈추게 하기 위한 변수 선언

	public MoveCircle() {
		super("::MoveCircle::");
		cp = this.getContentPane();//기본이 BorderLayout
		cp.add(p2,"Center");
		cp.add(p,"North");
		p.setBackground(Color.magenta);
		p2.setBackground(Color.white);
		
		p.add(btStart=new JButton("Start"));
		p.add(btStop=new JButton("Stop"));
		
		//Anonymous로 btStart버튼 ActionEvent처리
		//타이틀 변경"Start"
		btStart.addActionListener(new ActionListener(){//Anonymous
			public void actionPerformed(ActionEvent e) {
//				System.out.println(this);//Anonymous클래스의 this는 anonymous이다.
				setTitle("Start...");
				isStop=false;
				//thread 생성해서 동작 시키기
//				MoveCircle r=new MoveCircle();//Runnable객체 이면서 JFrame객체(setVisible하면 보임)[x]
//				r.setSize(200,200);
//				r.setVisible(true);
				tr=new Thread(MoveCircle.this);//Runnable객체 반드시 들어가야 함...그냥this=Anonymous클래스를 가리킴
				tr.start();
			}
		});
		
		//Lambda식으로 btStop버튼 ActionEvent처리
		//타이틀 변경"Stop"
		btStop.addActionListener(e->{//변수명만 입력해줘도 됨
//			System.out.println(this);//Lambda식은 함수이기때문에 this는 MoveCircle(outer)이다
			setTitle("Stop...");
			isStop=true;
			//thread 동작 중지
//			tr.stop();//[x] 안쓰는것이 좋다.취소선:deprecated(문제가 많아서 안쓰도록 안내하는 것)
//			tr.interrupt();//예외 발생시키기-예외 발생시 while문에서 break
		});
		
		//창닫기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자
	
	@Override
	public void run() {
		while(!isStop) {//isStop이 false일대만 동작..
			//stop하면 true가 되면서 모든 Thread 중지...interrupt 할 필요가 없음
			
			//무한반복 돌면서 MyCirclePanel의 x값을 증가시킨다.
			if(p2.x>p2.getWidth()) {//Width값보다 커지면 원점으로
				p2.x=0;
			}
			p2.x+=5;
			System.out.println("p2.x: "+p2.x);//콘솔에 x값 변화 찍어보기
			//sleep()걸어주기
			try {
				Thread.sleep(10);//Exception발생
			}catch(InterruptedException e) {
				System.out.println(e);
				break;//exception발생시 break
			}
//			p2.paint(getGraphics());//[x] paint()메서드는 JVM이 호출하는 메서드==>개발자는 repaint()를 호출해야한다.
			p2.repaint();//JVM이 알아서 paint()호출함
		}
		
	}//run()

	public static void main(String[] args) {
		MoveCircle my = new MoveCircle();//JFrame객체
		my.setSize(700, 500);
		my.setVisible(true);
	}

}
