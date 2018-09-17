import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class  SwingEx extends JFrame implements ActionListener	{
		private JPanel north, south;
		private JScrollPane sp;
		private JButton ok, can;
		private JLabel la;
		private JTextField tf;
		private JTextArea ta;

		private JMenuBar mb;
		private JMenu mfile, medit, mview, mcolor;
		private JMenuItem mnew, mopen, msave, mexit, minput, moutput, mred, mblue, myellow, mselect;
	
	public SwingEx () {
		//	메뉴바 생성
		mb = new JMenuBar();
		setJMenuBar(mb);

		//메뉴 아이템 생성, Mnemonic은 JMenu꺼
		mfile = new JMenu("파일(F)");
		medit = new JMenu("편집(E)");
		mview = new JMenu("보기(V)");
		mcolor = new JMenu("색상");
		mfile.setMnemonic(KeyEvent.VK_F);
		medit.setMnemonic(KeyEvent.VK_E);
		mview.setMnemonic(KeyEvent.VK_V);

		mb.add(mfile);
		mb.add(medit);
		mb.add(mview);
		mview.add(mcolor);
		
		mnew = new JMenuItem("새파일");
		mopen = new JMenuItem("열기");
		msave = new JMenuItem("저장");
		mexit = new JMenuItem("종료");

		mfile.add(mnew);
		mfile.add(mopen);
		mfile.add(msave);
		mfile.add(mexit);

		minput = new JMenuItem("입력");
		moutput = new JMenuItem("출력");
		medit.add(minput);
		medit.add(moutput);

		mred = new JMenuItem("빨강");
		mblue = new JMenuItem("파랑");
		myellow = new JMenuItem("노랑");
		mcolor.add(mred);
		mcolor.add(mblue);
		mcolor.add(myellow);

		mselect = new JMenuItem("선택");
		mview.add(mselect);

		//	하
		south = new JPanel();
		ok = new JButton("확인");
		can = new JButton("취소");
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20);

		ok.setFont(f);
		can.setFont(f);
		south.add(ok);
		south.add(can);
		add(south, "South");

		//	중
		ta = new JTextArea();
		ta.setFont(f);
		sp = new JScrollPane(ta);
		add(sp, "Center");

		//	상
		north = new JPanel();
		la = new JLabel("입력 : ");
		JLabel east = new JLabel (" ");
		tf = new JTextField();
		north.setLayout(new BorderLayout());
		north.add(la, "West");
		north.add(tf, "Center");
		north.add(east, "East");
		add(north, "North");
		
		setBounds(1200, 200, 400, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//키이벤트
		tf.addKeyListener(
			new KeyAdapter() {
			public void keyPressed (KeyEvent e) {
				switch(e.getKeyCode()) {
					case KeyEvent.VK_ESCAPE :
						tf.setText("");
						break;
					case KeyEvent.VK_Q : 
						if (e.getModifiers() == KeyEvent.CTRL_MASK) {
							System.exit(0);
						}	
						break;
					}
				}
			}
		);

		//액션 감시자들
		ok.addActionListener(this);
		tf.addActionListener(this);
		can.addActionListener(this);
		mred.addActionListener(this);
		mblue.addActionListener(this);
		myellow.addActionListener(this);
		mselect.addActionListener(this);
		mnew.addActionListener(this);
		mopen.addActionListener(this);
		msave.addActionListener(this);
		mexit.addActionListener(this);
		minput.addActionListener(this);
		moutput.addActionListener(this);

		// FocusEvent
		tf.addFocusListener(
			new FocusAdapter() {
				public void focusLost(FocusEvent e) {
					tf.requestFocus();
				}
			}
		);
	}	//생성자

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==ok || obj==tf) {							//텍스트에리어로 가버렷!
			String str = tf.getText();
			if(!str.equals("")) {
				ta.append(tf.getText() + "\n");
				tf.setText("");
			}
			tf.requestFocus();
		} else if(obj==can) {
			tf.setText("");
			tf.requestFocus();
		} else if(obj==mred) {								//텍스트에리어 컬러 설정
			ta.setBackground(Color.RED);
			ta.setForeground(Color.WHITE);
		} else if(obj==mblue) {
			ta.setBackground(Color.BLUE);
			ta.setForeground(Color.WHITE);
		} else if(obj==myellow) {
			ta.setBackground(Color.YELLOW);
			ta.setForeground(Color.BLACK);
		} else if(obj==mselect) {
			ta.setBackground(JColorChooser.showDialog(this, "배경색을 선택하세요", Color.BLUE));
			ta.setForeground(JColorChooser.showDialog(this, "글자색을 선택하세요", Color.WHITE));
		} else if(obj==mnew) {
			//new SwingEx();							//이러면 닫을 때 둘 다 닫히는데? close를 고쳐야할 듯?
			ta.setText("");
			ta.setBackground(Color.WHITE);
			ta.setForeground(Color.BLACK);
			tf.setText("");
		} else if(obj==mopen) {
			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(this);
			ta.append(fc.getName(fc.getSelectedFile()));
		} else if(obj==msave) {
			JFileChooser fc = new JFileChooser();
			fc.showSaveDialog(this);
		} else if(obj==mexit) {
			int select = JOptionPane.showConfirmDialog(this, "진짜 끄냐", "종료 메시지", JOptionPane.YES_NO_OPTION);
			if (select==JOptionPane.YES_OPTION || select ==-1) {
				JOptionPane.showMessageDialog(this, "끈다", "끔", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			} else if (select == JOptionPane.NO_OPTION) {	
				JOptionPane.showMessageDialog(this, "안끔", "끔", JOptionPane.ERROR_MESSAGE);
			}
		} else if (obj==minput) {
			String msg = JOptionPane.showInputDialog(this, "입력하셈", "쓰셈", JOptionPane.QUESTION_MESSAGE);
			if(msg!=null && !msg.equals("")) {
				msg = msg+"\n";
				ta.append(msg);
			}
		} else if(obj==moutput) {
			JOptionPane.showInputDialog(this, "니가 쓴거", ta);				//ta에 있는 텍스트를 갖다 출력하려고 했으나 fail 아 몰라
		}
	} //	액션 동작

	public static void main(String[] args) 	{
		new SwingEx();
	}
}
