//채팅 기능 잘 돌아가나 확인용 클래스]
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ChatTest extends JFrame {
	private JPanel jp;
	private JLabel jl;
	private JTextArea jta;
	private JTextField jtf;

	public ChatTest () {
		jp = new JPanel();
		jp.setLayout( new BorderLayout() );
		jp = new JPanel();
		jp.setBackground(Color.WHITE);
		jp.setLayout( new BorderLayout() );
		jta = new JTextArea();
		jtf = new JTextField(40);
		JScrollPane jsp = new JScrollPane( jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		jp.add(jta);
		jp.add(jtf, BorderLayout.SOUTH);
		add(jp);
		
		setBounds(100, 100, 500, 300);
		setResizable( false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ChatTest();
	}
}