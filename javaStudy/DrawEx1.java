import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DrawEx1 extends JFrame {
	int ox, oy, x, y;
	Graphics g;

	public DrawEx1 () {
		g = getGraphics();
		setBounds(1400, 200, 400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addMouseListener(
			new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
				System.out.println( x + " : " +y);
				}
			}
		);
		addMouseMotionListener(
			new MouseAdapter() {
				public void mouseDraged(MouseMotion e) {
					ox = x;
					oy = y;
					x = e.getX(); 
					y = e.getY();
					g.drawLine(ox, oy, x, y);
				}
			}
		);

	public void paint(Image image, int x, int y, int width, int height) {
		//¿©±â ¹¹Áö
	}

	public static void main(String[] args) {
		new DrawEx1();
		new mouseDraged();
	}
}
