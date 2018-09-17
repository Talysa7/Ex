import java.awt.*;
import javax.swing.*;

class  DrawEx extends JFrame {
	public DrawEx() {
		setBounds(1200, 200, 400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void paint (Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g);
		g2.drawRect(10, 40, 50, 50);
		g2.setColor(Color.PINK);
		g2.fillRect(70, 40, 50, 50);
		g2.drawLine(140, 40, 300, 90);
		g2.drawLine(300, 40, 140, 90);
		g2.drawOval(10, 120, 60, 60); 
		g2.clearRect(70, 70, 100, 100);
		g2.fillRoundRect(10, 200, 100, 100, 50, 50);
		

	}

	public static void main(String[] args) {
		new DrawEx();
	}
}
