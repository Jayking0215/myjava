package MovieApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//awt의 서브패키지...서브패키지는 별도로 명시해야함
import java.util.ArrayList;

public class InputMovie extends JFrame implements ActionListener {

	Container cp;
	JPanel p = new JPanel(new GridLayout(7,1));
	JPanel pTitle = new JPanel();
	JPanel pDate = new JPanel();
	JPanel pAge = new JPanel();
	JPanel pGenre = new JPanel();
	JPanel pDirector = new JPanel();
	JPanel pSumm = new JPanel();
	JPanel pButton = new JPanel();
	
	JLabel lbTitle,lbDate,lbAge,lbGenre,lbDirector,lbSumm;
	JTextField tfTitle, tfDate, tfGenre, tfDirector;
	JRadioButton rbAll, rb15, rb19;
	ButtonGroup group;
	JButton btSave, btCancel;
	JTextArea ta;

	public InputMovie() {
		super("::InputMovie::");
		cp = this.getContentPane();
		cp.add(p);//기본이 Center
		p.setBackground(Color.white);
		this.setLayout(new FlowLayout());
		
		ta=new JTextArea(2,20);
		JScrollPane sp=new JScrollPane(ta);
		
		//패널에 Layout 붙이기
		p.add(pTitle);
		p.add(pDate);
		p.add(pAge);
		p.add(pGenre);
		p.add(pDirector);
		p.add(pSumm);
		p.add(pButton);
		
		//Layout 설정
		pTitle.setLayout(new FlowLayout(FlowLayout.LEFT));
		pDate.setLayout(new FlowLayout(FlowLayout.LEFT));
		pAge.setLayout(new FlowLayout(FlowLayout.LEFT));
		pGenre.setLayout(new FlowLayout(FlowLayout.LEFT));
		pDirector.setLayout(new FlowLayout(FlowLayout.LEFT));
		pSumm.setLayout(new FlowLayout(FlowLayout.LEFT));
		pButton.setLayout(new FlowLayout(FlowLayout.LEFT));

		//버튼 패널에 추가
		pTitle.add(lbTitle=new JLabel("영화 제목"));
		pTitle.add(tfTitle=new JTextField(20));
		
		pDate.add(lbDate=new JLabel("개 봉 일"));
		pDate.add(tfDate = new JTextField(10));
		
		pAge.add(lbAge=new JLabel("시청 연령"));
		pAge.add(rbAll = new JRadioButton("전체 이용가",false));
		pAge.add(rb15 = new JRadioButton("15세 이용가",false));
		pAge.add(rb19 = new JRadioButton("19세 이용가",false));
		group = new ButtonGroup();
		group.add(rbAll);
		group.add(rb15);
		group.add(rb19);
		
		pGenre.add(lbGenre=new JLabel("영화 장르"));
		pGenre.add(tfGenre=new JTextField(10));
		
		pDirector.add(lbDirector=new JLabel("영화 감독"));
		pDirector.add(tfDirector=new JTextField(10));
		
		pSumm.add(lbSumm=new JLabel("영화 요약"));
		pSumm.add(sp);
		
		pButton.add(btSave = new JButton("저장"));
		pButton.add(btCancel = new JButton("취소"));
		
		//ActionEvent
		btSave.addActionListener(this);
		btCancel.addActionListener(this);
		
		//창닫기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btSave) {
			String age="";
			if(rbAll.isSelected()) {
				age=rbAll.getText().toString();
			}else if(rb15.isSelected()) {
				age=rb15.getText().toString();
			}else if(rb19.isSelected()) {
				age=rb19.getText().toString();
			}
			Mvl mv = new Mvl(tfTitle.getText().toString().trim(), 
					tfDate.getText().toString().trim(),
					age,
					tfGenre.getText().toString().trim(),
					tfDirector.getText().toString().trim(),
					ta.getText().toString().trim()
					);
			mvManager.list.add(mv);
		}
		if(e.getSource()==btCancel) {
			dispose();
		}
	}

	public static void main(String[] args) {
		InputMovie my = new InputMovie();
		my.setSize(400, 400);
		my.setLocation(450,300);
		my.setVisible(true);
	}
}

class Mvl{
	String title;
	String date;
	String age;
	String genre;
	String director;
	String summ;

	public Mvl(String trim, String trim2, String age2, String trim3, String trim4, String trim5) {
	}
}

class mvManager{
	public static ArrayList<Mvl> list=new ArrayList<Mvl>();
}