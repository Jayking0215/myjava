package day08;
//템플릿 불러오기
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//awt의 서브패키지...서브패키지는 별도로 명시해야함
import day07.MyJPanel;

public class MyCalc extends JFrame implements ActionListener{

	Container cp;
	JPanel p = new MyJPanel();
	JLabel lb1, lb2, lb3;//정수 1, 정수2, 결과 Label
	JTextField tf1, tf2, tfResult;
	JButton btPlus, btReset;

	public MyCalc() {
		super("::MyCalc::");
		cp = this.getContentPane();
		cp.add(p);
		p.setBackground(Color.white);
		//레이아웃 잡기
		p.setLayout(new GridLayout(4,2,10,10));//4행 2열 간격10
		
		//컴포넌트 생성하기
		lb1=new JLabel("정수1: ",JLabel.CENTER);//중앙배치
		lb2=new JLabel("정수2: ",JLabel.CENTER);
		lb3=new JLabel("결 과: ",JLabel.CENTER);
		
		tf1=new JTextField(20);
		tf2=new JTextField(20);
		tfResult=new JTextField(20);
		
		btPlus=new JButton("Plus");
		btReset=new JButton("Reset");
		
		//컴포넌트 붙이기(모양 순서대로)
		p.add(lb1); p.add(tf1);
		p.add(lb2); p.add(tf2);
		p.add(lb3); p.add(tfResult);
		p.add(btPlus); p.add(btReset);

		//단축키 설정
		btPlus.setMnemonic('P');// alt+p
		btReset.setMnemonic('R');// alt+R
		
		//읽기전용 textbox
		tfResult.setEditable(false);//편집 불가능(Read only)
		
		//리스너 부착
		btPlus.addActionListener(this);
		btReset.addActionListener(this);
		
		
		//창닫기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		setTitle("@@@");//Event연동 확인용 title변경
		Object obj=e.getSource();
		if(obj==btPlus) {
			try {
				calc();//매서드 호출하기
			}catch(NumberFormatException ee) {
				JOptionPane.showMessageDialog(this, "정수를 입력해주세요");
			}
		}else if(obj==btReset) {
			reset();
		}
	}
	//ActionEvent 매서드 구현
	public void calc() throws NumberFormatException {
		//tf1, tf2에 입력한 값 반환(String 반환됨)
		//정수로 변환하기 ==> 예외처리: JOptionPane.showMessageDialog()
		int num1=Integer.parseInt(tf1.getText());
		int num2=Integer.parseInt(tf2.getText());//NumberFormatException
		//더하기 연산 수행 결과 tfResult에 출력
		tfResult.setText(String.valueOf(num1+num2));
	}
	public void reset() {
		//tf1, tf2, tfResult를 모두 초기화
		tf1.setText("");
		tf2.setText("");
		tfResult.setText("");
	}
	
	public static void main(String[] args) {
		MyCalc my = new MyCalc();
		my.setSize(300, 300);//w,h
		my.setLocation(500, 300);//x,y좌표
		
		my.setVisible(true);
	}
}

