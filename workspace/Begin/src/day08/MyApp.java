package day08;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//awt의 서브패키지...서브패키지는 별도로 명시해야함
//CardLayout
public class MyApp extends JFrame{

	Container cp;
	MyLoginPage p = new MyLoginPage();//1번 카드
	JPanel p2= new JPanel();//2번 카드
	CardLayout card;//CardLayout은 맴버변수로 생성
	
	JButton btBack;

	public MyApp() {
		super("::MyApp::");
		cp = this.getContentPane();//=>CardLayout으로 변경
		card=new CardLayout();
		cp.setLayout(card);

//		cp.add(p);		
		cp.add(p,"login");//Card는 별칭 붙여줘야함
		cp.add(p2,"home");

//		card.show(cp, "home");//"home"카드 먼저 보이기
//		p.btLogin.addActionListener(this);
		
		MyHandler handler=new MyHandler();
		p.btLogin.addActionListener(handler);
		
		p.setBackground(Color.yellow);
		p2.setBackground(Color.pink);
		
		p2.setLayout(new BorderLayout());
		btBack=new JButton("뒤로가기");
		p2.add(btBack, "South");
		btBack.addActionListener(handler);

		//창닫기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//생성자
	
	class MyHandler implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource();
			if(p.tfName==null) return;
			if(obj==p.btLogin) {
				String name=p.tfName.getText();
				char[] ch=p.tfPwd.getPassword();
				String pwd=new String(ch);
				try {
					login(name, pwd);
				} catch(NotSupportedNameException ee) {
					JOptionPane.showMessageDialog(cp, ee.getMessage());
					reset();
				}
			}else if(obj==btBack) {
				card.show(cp,  "login");
				reset();
			}
		}
	}//MyHandler
	
	public void passwdCheck(String name, String pwd) throws NotSupportedNameException{
		if(pwd.equals("123")) {
			card.show(cp, "home");
			setTitle(name+"님 환잉꽌링~");
		}else {
			throw new NotSupportedNameException("비밀번호가 일치하지 않습니다.");
		}
	}//passwdCheck
	
	//login() 이름제한
	public void login(String name, String pwd) throws NotSupportedNameException{
		if(name.startsWith("퐁")) {
			passwdCheck(name, pwd);
		}else if(name.startsWith("콩")) {
			reset();
			throw new NotSupportedNameException("콩씨는 절대로 로그인 불가!!!");
		}else {
			reset();
			card.show(cp, "home");
			throw new NotSupportedNameException("퐁씨 이외의 기타 성씨는 이용에 제한이 있어요");//예외를 발생시킴
		}
	}
	
	//reset()기능
	public void reset() {
		p.tfName.setText("");
		p.tfPwd.setText("");
		//tfName에 커서이동
		p.tfName.requestFocus();
	}
	
	public static void main(String[] args) {
		MyApp my = new MyApp();
		my.setSize(400, 700);
		my.setLocation(700, 200);
		my.setVisible(true);
	}
}
