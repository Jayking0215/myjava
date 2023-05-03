package MovieApp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;//awt의 서브패키지...서브패키지는 별도로 명시해야함

public class MovieAppView extends JFrame implements ActionListener {

	Container cp;
	JPanel pN = new JPanel(new GridLayout(2,1));//2행1열
	JPanel pN_sub=new JPanel();
	JPanel pC = new JPanel();
	
	JLabel lbTitle;
	JButton btAdd, btSch, btDel, btEdit, btPrt;
	JTable table = null;
	
	public MovieAppView() {
		super("::MovieAppView::");
		cp = this.getContentPane();//default: BorderLayout
		cp.setBackground(Color.black);
		
		//table
		String initT[] = new String[6];
		initT[0]="영화 제목";
		initT[1]="개 봉 일";
		initT[2]="시청 연령";
		initT[3]="영화 장르";
		initT[4]="영화 감독";
		initT[5]="영화 요약";
		String data[][]=new String[0][0];
		table = new JTable(data, initT);
		JScrollPane sp=new JScrollPane(table);
		sp.setPreferredSize(new Dimension(400,200));
		pC.add(sp);
		
		//Panel 배치
		cp.add(pN,"North");
		cp.add(pC,"Center");
		
		//Title Name Label 설정
		lbTitle=new JLabel("Moview Manager",JLabel.CENTER);
		pN.add(lbTitle);
		lbTitle.setFont(new Font("",Font.BOLD,20));
		
		//Button 패널에 추가
		pN.add(pN_sub);
		pN_sub.add(btAdd=new JButton("추가"));
		pN_sub.add(btDel=new JButton("삭제"));
		pN_sub.add(btPrt=new JButton("출력"));
		pN_sub.add(btSch=new JButton("검색"));
		pN_sub.add(btEdit=new JButton("수정"));
		
		//ActionEvent
		btAdd.addActionListener(this);
		btSch.addActionListener(this);
		btDel.addActionListener(this);
		btEdit.addActionListener(this);
		btPrt.addActionListener(this);
		
		//창닫기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btAdd) {
			InputMovie my = new InputMovie();
			my.setSize(400, 400);
			my.setLocation(450,300);
			my.setVisible(true);
		}
		if(e.getSource() == btDel) {
			if(table.getSelectedRow() == -1) {
			}else {
				int deleteIndex = table.getSelectedRow();
				mvManager.list.remove(deleteIndex);
				this.datTable();
			}
		}
		if(e.getSource() == btPrt){
			String dataTmp[] = new String[6];
			dataTmp[0]="영화 제목";
			dataTmp[1]="개 봉 일";
			dataTmp[2]="시청 연령";
			dataTmp[3]="영화 장르";
			dataTmp[4]="영화 감독";
			dataTmp[5]="영화 요약";
			
			int size = mvManager.list.size();
			String[][] movieArr = new String[size][3];
			
			for(int i=0; i<size; i++) {
				Mvl dataMovie = mvManager.list.get(i);
				
				movieArr[i][0]=dataMovie.title;
				movieArr[i][1]=dataMovie.date;
				movieArr[i][2]=dataMovie.age;
				movieArr[i][3]=dataMovie.genre;
				movieArr[i][4]=dataMovie.director;
				movieArr[i][5]=dataMovie.summ;
			}
			table.setModel(new DefaultTableModel(movieArr,dataTmp));
		}
		if(e.getSource() == btSch) {
			//검색기능
		}
		if(e.getSource() == btEdit) {
			//수정기능
		}
	}

	//Movie data 설정
	public void datTable() {
		String dataTmp[] = new String[6];
		dataTmp[0]="영화 제목";
		dataTmp[1]="개 봉 일";
		dataTmp[2]="시청 연령";
		dataTmp[3]="영화 장르";
		dataTmp[4]="영화 감독";
		dataTmp[5]="영화 요약";
		
		int size = mvManager.list.size();
		String[][] movieArr = new String[size][3];
		
		for(int i=0; i<size; i++) {
			Mvl dataMovie = mvManager.list.get(i);
			
			movieArr[i][0]=dataMovie.title;
			movieArr[i][1]=dataMovie.date;
			movieArr[i][2]=dataMovie.age;
			movieArr[i][3]=dataMovie.genre;
			movieArr[i][4]=dataMovie.director;
			movieArr[i][5]=dataMovie.summ;
		}
		
		table.setModel(new DefaultTableModel(movieArr,dataTmp));
	}
	
	public static void main(String[] args) {
		MovieAppView my = new MovieAppView();
		my.setSize(500, 500);
		my.setLocation(450,300);
		my.setVisible(true);
	}
}