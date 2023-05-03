package day08;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class MyLoginPage extends JPanel{
	
	JTextField tfName;
	JPasswordField tfPwd;
	JButton btLogin;
	//x, y좌표 지정해서 붙이기: 기본Layout을 해제 해야한다
	//대신 컴포넌트 사이즈와 x,y좌료를 수동지정 해줘야한다.=>setBounds(x,y,w,h)
	public MyLoginPage() {
		this.setLayout(null);//Layout해제
		
		tfName=new JTextField(20);
		tfPwd=new JPasswordField(20);
		btLogin=new JButton("Login");
		
		tfName.setBounds(90, 170, 200, 50);//x,y,w,h
		tfPwd.setBounds(90, 240, 200, 50);
		btLogin.setBounds(90, 310, 200,50);
		btLogin.setBackground(new Color(130,200,160));//RGB컬러
		btLogin.setForeground(Color.white);
		
		tfName.setBorder(new TitledBorder("Name"));
		tfPwd.setBorder(new TitledBorder("Password"));
		
		add(tfName);
		add(tfPwd);
		add(btLogin);
		
	}//생성자
}

/*
 * 로그인 버튼 이벤트 처리하기
- 퐁씨가 로그인하면 p2패널을 보여주기
   card.show(cp,"home");
- 콩씨가 로그인하면
  NotSupportedNameException발생시켜
 경고창 띄우기
- 기타 성씨가 로그인하면
  NotSupportedNameException발생시켜
  경고창 띄우고 화면 전환 p2패널 보여주기
 */