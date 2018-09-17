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
		//	�޴��� ����
		mb = new JMenuBar();
		setJMenuBar(mb);

		//�޴� ������ ����, Mnemonic�� JMenu��
		mfile = new JMenu("����(F)");
		medit = new JMenu("����(E)");
		mview = new JMenu("����(V)");
		mcolor = new JMenu("����");
		mfile.setMnemonic(KeyEvent.VK_F);
		medit.setMnemonic(KeyEvent.VK_E);
		mview.setMnemonic(KeyEvent.VK_V);

		mb.add(mfile);
		mb.add(medit);
		mb.add(mview);
		mview.add(mcolor);
		
		mnew = new JMenuItem("������");
		mopen = new JMenuItem("����");
		msave = new JMenuItem("����");
		mexit = new JMenuItem("����");

		mfile.add(mnew);
		mfile.add(mopen);
		mfile.add(msave);
		mfile.add(mexit);

		minput = new JMenuItem("�Է�");
		moutput = new JMenuItem("���");
		medit.add(minput);
		medit.add(moutput);

		mred = new JMenuItem("����");
		mblue = new JMenuItem("�Ķ�");
		myellow = new JMenuItem("���");
		mcolor.add(mred);
		mcolor.add(mblue);
		mcolor.add(myellow);

		mselect = new JMenuItem("����");
		mview.add(mselect);

		//	��
		south = new JPanel();
		ok = new JButton("Ȯ��");
		can = new JButton("���");
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20);

		ok.setFont(f);
		can.setFont(f);
		south.add(ok);
		south.add(can);
		add(south, "South");

		//	��
		ta = new JTextArea();
		ta.setFont(f);
		sp = new JScrollPane(ta);
		add(sp, "Center");

		//	��
		north = new JPanel();
		la = new JLabel("�Է� : ");
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

		//Ű�̺�Ʈ
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

		//�׼� �����ڵ�
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
	}	//������

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==ok || obj==tf) {							//�ؽ�Ʈ������� ������!
			String str = tf.getText();
			if(!str.equals("")) {
				ta.append(tf.getText() + "\n");
				tf.setText("");
			}
			tf.requestFocus();
		} else if(obj==can) {
			tf.setText("");
			tf.requestFocus();
		} else if(obj==mred) {								//�ؽ�Ʈ������ �÷� ����
			ta.setBackground(Color.RED);
			ta.setForeground(Color.WHITE);
		} else if(obj==mblue) {
			ta.setBackground(Color.BLUE);
			ta.setForeground(Color.WHITE);
		} else if(obj==myellow) {
			ta.setBackground(Color.YELLOW);
			ta.setForeground(Color.BLACK);
		} else if(obj==mselect) {
			ta.setBackground(JColorChooser.showDialog(this, "������ �����ϼ���", Color.BLUE));
			ta.setForeground(JColorChooser.showDialog(this, "���ڻ��� �����ϼ���", Color.WHITE));
		} else if(obj==mnew) {
			//new SwingEx();							//�̷��� ���� �� �� �� �����µ�? close�� ���ľ��� ��?
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
			int select = JOptionPane.showConfirmDialog(this, "��¥ ����", "���� �޽���", JOptionPane.YES_NO_OPTION);
			if (select==JOptionPane.YES_OPTION || select ==-1) {
				JOptionPane.showMessageDialog(this, "����", "��", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			} else if (select == JOptionPane.NO_OPTION) {	
				JOptionPane.showMessageDialog(this, "�Ȳ�", "��", JOptionPane.ERROR_MESSAGE);
			}
		} else if (obj==minput) {
			String msg = JOptionPane.showInputDialog(this, "�Է��ϼ�", "����", JOptionPane.QUESTION_MESSAGE);
			if(msg!=null && !msg.equals("")) {
				msg = msg+"\n";
				ta.append(msg);
			}
		} else if(obj==moutput) {
			JOptionPane.showInputDialog(this, "�ϰ� ����", ta);				//ta�� �ִ� �ؽ�Ʈ�� ���� ����Ϸ��� ������ fail �� ����
		}
	} //	�׼� ����

	public static void main(String[] args) 	{
		new SwingEx();
	}
}
