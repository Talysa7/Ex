//ȭ�� ��¿�
import java.awt.*;
import javax.swing.*;
//�� �Է¿�
import java.util.Scanner;
import java.awt.event.*;

/*implements ActionListener*/

class WindowSet extends JPanel {
	JPanel upper = new JPanel();
	JPanel middle = new JPanel();
	JPanel lower = new JPanel();
	void WindowSet () {
		upper.setBackground(new Color(180, 180, 180));
		upper.setLayout(new BorderLayout());
		middle.setBackground(new Color(100, 100, 100));
		middle.setLayout(new GridLayout());
		lower.setBackground(new Color(20, 20, 20));
		lower.setLayout(new GridLayout());
	}
}

class MainWork {
	double x;
	double y;
	double res;
	String words;
	Scanner in = new Scanner(System.in);
	
	public double calulate (double a, double b) {
		words = in.nextLine();
		//����
		res=x+y;
		//����
		res=x-y;
		//����
		res=x*y;
		//������
		res=x/y;
		//������
		res=x%y;
		//������
		res=Math.sqrt(res);
		//����
		res=res*res;
		//�м�
		res=1/res;

		return res;
	}	
}

class SimpleCalculator extends JFrame {
	//������
	public SimpleCalculator() {
		/*WindowSet ws = new WindowSet();
		add(ws.upper);
		add(ws.middle);
		add(ws.lower);*/
		setBounds(1400, 200, 400, 600);
		setTitle("����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	} //������ ��
	
	//����
	public static void main(String[] args) {
		new SimpleCalculator();
	} //main ��
} //main �� Ŭ����
