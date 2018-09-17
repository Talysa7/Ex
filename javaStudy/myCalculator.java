import java.math.BigDecimal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.*;
import javax.imageio.*;

class myCalculator extends JFrame implements ActionListener {
	//필요한 값들
	private double num1, num2;
	private double res;
	private int resInt;
	private String swt;
	private String userInput;
	private String doing;

	//필요한 화면 요소들
	private JFrame body = new JFrame();
	private JPanel padPanel = new JPanel();
	private JLabel padLabel = new JLabel(doing, Label.LEFT);
	private JPanel butPanel = new JPanel();
	private JButton plus =new JButton("+");
	private JButton minus =new JButton("-");
	private JButton multi =new JButton("*");
	private JButton div =new JButton("/");
	private JButton set =new JButton("=");
	private JButton n1 =new JButton("1");
	private JButton n2 =new JButton("2");
	private JButton n3 =new JButton("3");
	private JButton n4 =new JButton("4");
	private JButton n5 =new JButton("5");
	private JButton n6 =new JButton("6");
	private JButton n7 =new JButton("7");
	private JButton n8 =new JButton("8");
	private JButton n9 =new JButton("9");
	private JButton n0 =new JButton("0");
	private JButton nRev =new JButton("±");
	private JButton nM =new JButton("%");
	private JButton nC =new JButton("C");
	private JButton nR =new JButton("√");
	private JButton nG =new JButton("x²");
	private JButton nB =new JButton("1/x");
	private JButton nDot =new JButton(" . ");
	private JButton CE =new JButton("CE");
	private JButton bs =new JButton("←");
	private Font padFont = new Font(Font.SANS_SERIF, Font.BOLD, 20);
	private Font butFont = new Font(Font.SANS_SERIF, 0, 24);

	//값 초기화
	public void setDef () {
		num1 = 0;
		num2 = 0;
		res = num1;
		resInt = 0;
		swt = "=";
		userInput = "";
		doing = userInput;
		padLabel.setText(doing);
	}

	//반복 작업용
	public void repeat () {
		num1 = Double.valueOf(userInput);
		userInput="";
		padLabel.setText(userInput);
	}

	//액션
	public void actionPerformed(ActionEvent e) {
		JButton tempB = (JButton)e.getSource();
		String temp = tempB.getText();
		if (temp.equals("0")) {
			userInput = userInput + "0";
			num2=Double.valueOf(userInput);
			padLabel.setText(userInput);
		} else if (temp.equals("1"))	{
			userInput = userInput + "1";
			num2=Double.valueOf(userInput);
			padLabel.setText(userInput);
		} else if (temp.equals("2"))	{
			userInput = userInput + "2";
			num2=Double.valueOf(userInput);
			padLabel.setText(userInput);
		} else if (temp.equals("3"))	{
			userInput = userInput + "3";
			num2=Double.valueOf(userInput);
			padLabel.setText(userInput);
		} else if (temp.equals("4"))	{
			userInput = userInput + "4";
			num2=Double.valueOf(userInput);
			padLabel.setText(userInput);
		} else if (temp.equals("5"))	{
			userInput = userInput + "5";
			num2=Double.valueOf(userInput);
			padLabel.setText(userInput);
		} else if (temp.equals("6"))	{
			userInput = userInput + "6";
			num2=Double.valueOf(userInput);
			padLabel.setText(userInput);
		} else if (temp.equals("7"))	{
			userInput = userInput + "7";
			num2=Double.valueOf(userInput);
			padLabel.setText(userInput);
		} else if (temp.equals("8"))	{
			userInput = userInput + "8";
			num2=Double.valueOf(userInput);
			padLabel.setText(userInput);
		} else if (temp.equals("9"))	{
			userInput = userInput + "9";
			num2=Double.valueOf(userInput);
			padLabel.setText(userInput);
		} else if (temp.equals("0"))	{
			userInput = userInput + "0";
			num2=Double.valueOf(userInput);
			padLabel.setText(userInput);
		} else if (temp.equals("+")) {
			swt = "+";
			repeat();
			doing = "";
			calculator(num1, swt, num2);
			if (res%1!=0) {
				doing = ""+res;
			} else {
				doing = "" + Math.floor(res);
			}
		} else if (temp.equals("-")){
			swt = "-";
			repeat();
			calculator(num1, swt, num2);
			if (res%1>0&&res%1<1) {
				doing = ""+res;
			} else {
				doing = "" + resInt;
			}
		} else if (temp.equals("*")){
			swt = "*";
			repeat();
			calculator(num1, swt, num2);
			if (res%1>0&&res%1<1) {
				doing = ""+res;
			} else {
				doing = "" + resInt;
			}
		} else if (temp.equals("/")) {
			swt = "/";
			repeat();
			calculator(num1, swt, num2);
			if (res%1>0&&res%1<1) {
				doing = ""+res;
			} else {
				doing = "" + resInt;
			}
		} else if (temp.equals("%")){
			swt = "%";
			repeat();
			calculator(num1, swt, num2);
			if (res%1>0&&res%1<1) {
				doing = ""+res;
			} else {
				doing = "" + resInt;
			}
		} else if (temp.equals("√")){
			swt = "√";
			num1 = Double.valueOf(userInput);
			calculator(num1, swt, num2);
			if (res%1>0&&res%1<1) {
				doing = ""+res;
			} else {
				doing = "" + resInt;
			}
		} else if (temp.equals("x²")){
			swt = "x²";
			num1 = Double.valueOf(userInput);
			calculator(num1, swt, num2);
			doing = ""+res;
		} else if (temp.equals("1/x")){
			swt = "1/x";
			repeat();
			calculator(num1, swt, num2);
			if (res%1!=0) {
				doing = ""+res;
			} else {
				doing = "" + resInt;
			}
		} else if (temp.equals("±")){
			num1 = num1*-1;
			doing = "" + num1;
		} else if (temp.equals(" . ")){
			userInput = userInput + ".";
			doing=userInput;
		} else if (temp.equals("C")){
			setDef();
		} else if (temp.equals("CE")){
			setDef();
		} else if (temp.equals("←")){
			userInput = userInput.substring(0, userInput.length()-1);
			padLabel.setText(userInput);
		} else if (temp.equals("=")){
			num2=Double.valueOf(userInput);
			calculator(num1, swt, num2);
			doing = ""+res;
			padLabel.setText(doing);
		}
	}

	//계산기 초기화
	public myCalculator () {
		setUI();
		setDef();
		setBounds(200, 200, 300, 400);
		setTitle("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		//키보드 입력 받기
		
	}//생성자/초기화 끝
	
	//계산 메소드
	public void calculator (double a, String b, double c) {
		switch(b) {
			case "+" : 
				res = num1+num2;
				resInt = (int)res;
				break;
			case "-" :
				res = num1-num2;
				resInt = (int)res;
				break;
			case "*" : 
				res = num1*num2;
				resInt = (int)res;
				break;
			case "/" : 
				if (num2==0) {
					padLabel.setText("0으로 나눌 수 없습니다.");
					setDef();
				} else {
					res = num1/num2;
				}	
				resInt = (int)res;
				break;
			case "%" :
				res = num1%num2;
				resInt = (int)res;
				break;
			case "√" :
				res = Math.sqrt(num1);
				resInt = (int)res;
				break;
			case "x²" : 
				res = num1*num1;
				resInt = (int)res;
				break;
			case "1/x" : 
				res = num1/num2;
				resInt = (int)res;
				break;
			default : 
				break;
		};
	}

	//UI 메소드
	public void setUI () {
		padPanel.setLayout(new BorderLayout());
		butPanel.setLayout(new GridLayout(0, 4));
		padPanel.setBackground(Color.WHITE);
		padLabel.setForeground(Color.BLACK);
		add(padPanel);
		padPanel.add(padLabel, "East");
		add(butPanel, "South");
		padLabel.setFont(padFont);

		//버튼 색칠하고 붙이기
		butPanel.add(nM);
		nM.setFont(butFont);
		nM.setBackground(new Color(234, 234, 234));
		nM.setForeground(Color.BLACK);
		nM.addActionListener(this);
		butPanel.add(nR);
		nR.setFont(butFont);
		nR.setBackground(new Color(234, 234, 234));
		nR.setForeground(Color.BLACK);
		nR.addActionListener(this);
		butPanel.add(nG);
		nG.setFont(butFont);
		nG.setBackground(new Color(234, 234, 234));
		nG.setForeground(Color.BLACK);
		nG.addActionListener(this);
		butPanel.add(nB);
		nB.setFont(butFont);
		nB.setBackground(new Color(234, 234, 234));
		nB.setForeground(Color.BLACK);
		nB.addActionListener(this);

		butPanel.add(CE);
		CE.setFont(butFont);
		CE.setBackground(new Color(234, 234, 234));
		CE.setForeground(Color.BLACK);
		CE.addActionListener(this);
		butPanel.add(nC);
		nC.setFont(butFont);
		nC.setBackground(new Color(234, 234, 234));
		nC.setForeground(Color.BLACK);
		nC.addActionListener(this);
		butPanel.add(bs);
		bs.setFont(butFont);
		bs.setBackground(new Color(234, 234, 234));
		bs.setForeground(Color.BLACK);
		bs.addActionListener(this);
		butPanel.add(div);
		div.setFont(butFont);
		div.setBackground(new Color(234, 234, 234));
		div.setForeground(Color.BLACK);
		div.addActionListener(this);

		butPanel.add(n7);
		n7.setFont(butFont);
		n7.setBackground(Color.WHITE);
		n7.setForeground(Color.BLACK);
		n7.addActionListener(this);
		butPanel.add(n8);
		n8.setFont(butFont);
		n8.setBackground(Color.WHITE);
		n8.setForeground(Color.BLACK);
		n8.addActionListener(this);
		butPanel.add(n9);
		n9.setFont(butFont);
		n9.setBackground(Color.WHITE);
		n9.setForeground(Color.BLACK);
		n9.addActionListener(this);
		butPanel.add(multi);
		multi.setFont(butFont);
		multi.setBackground(new Color(234, 234, 234));
		multi.setForeground(Color.BLACK);
		multi.addActionListener(this);

		butPanel.add(n4);
		n4.setFont(butFont);
		n4.setBackground(Color.WHITE);
		n4.setForeground(Color.BLACK);
		n4.addActionListener(this);
		butPanel.add(n5);
		n5.setFont(butFont);
		n5.setBackground(Color.WHITE);
		n5.setForeground(Color.BLACK);
		n5.addActionListener(this);
		butPanel.add(n6);
		n6.setFont(butFont);
		n6.setBackground(Color.WHITE);
		n6.setForeground(Color.BLACK);
		n6.addActionListener(this);
		butPanel.add(minus);
		minus.setFont(butFont);
		minus.setBackground(new Color(234, 234, 234));
		minus.setForeground(Color.BLACK);
		minus.addActionListener(this);

		butPanel.add(n1);
		n1.setFont(butFont);
		n1.setBackground(Color.WHITE);
		n1.setForeground(Color.BLACK);
		n1.addActionListener(this);
		butPanel.add(n2);
		n2.setFont(butFont);
		n2.setBackground(Color.WHITE);
		n2.setForeground(Color.BLACK);
		n2.addActionListener(this);
		butPanel.add(n3);
		n3.setFont(butFont);
		n3.setBackground(Color.WHITE);
		n3.setForeground(Color.BLACK);
		n3.addActionListener(this);
		butPanel.add(plus);
		plus.setFont(butFont);
		plus.setBackground(new Color(234, 234, 234));
		plus.setForeground(Color.BLACK);
		plus.addActionListener(this);

		butPanel.add(nRev);
		nRev.setFont(butFont);
		nRev.setBackground(Color.WHITE);
		nRev.setForeground(Color.BLACK);
		nRev.addActionListener(this);
		butPanel.add(n0);
		n0.setFont(butFont);
		n0.setBackground(Color.WHITE);
		n0.setForeground(Color.BLACK);
		n0.addActionListener(this);
		butPanel.add(nDot);
		nDot.setFont(butFont);
		nDot.setBackground(Color.WHITE);
		nDot.setForeground(Color.BLACK);
		nDot.addActionListener(this);
		butPanel.add(set);
		set.setFont(butFont);
		set.setBackground(new Color(234, 234, 234));
		set.setForeground(Color.BLACK);
		set.addActionListener(this);
	}

	public static void main(String[] args) 	{
		new myCalculator();
	} //메인 끝
}