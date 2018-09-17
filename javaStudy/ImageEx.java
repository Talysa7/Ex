import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ImageEx extends JFrame {
	Toolkit tk;
	Image img;
	int x=10, y=50;

	public ImageEx() {
		tk=getToolkit();
		img=tk.getImage("duke.gif");

		setBounds(50, 50, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addKeyListener(
			new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					switch(e.getKeyCode()) {
						case KeyEvent.VK_UP : 
							y-=5;
							break;
						case KeyEvent.VK_DOWN : 
							y+=5;
							break;
						case KeyEvent.VK_LEFT : 
							x-=5;
							break;
						case KeyEvent.VK_RIGHT :
							x+=5;
							break;
					}
					repaint();									//옮겨진 위치에 다시 그림
				}
			}
		);
	}

	public void paint(Graphics g) {
		Graphics g2 = (Graphics2D) g;
		super.paint(g2);
		g2.drawImage(img, x, y, 50, 50, this);
	}

	public static void main(String[] args) {
		new ImageEx();
	}
}
