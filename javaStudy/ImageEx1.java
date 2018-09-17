import java.awt.*;
import javax.swing.*;
import java.net.*;

class ImageEx1 extends JFrame {
	Toolkit tk;
	Image img;
	URL url;

	public ImageEx1 () {
		try {
			tk=getToolkit();
			url=new URL("https://t1.daumcdn.net/news/201807/06/yonhap/20180706083706681ubla.jpg");
			img=tk.getImage(url);

			MediaTracker mt = new MediaTracker(this);
			mt.addImage(img, 0);

			System.out.println("이미지 로딩 중");
			mt.waitForAll();

			if (mt.isErrorAny()) {
				System.out.println("이미지 로딩 실패");
				System.exit(0);
			}

			System.out.println("성공");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		setBounds(800, 50, 1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g2);
		g2.drawImage(img, 50, 50, 800, 500, this);
	}

	public static void main(String[] args) 
	{
		new ImageEx1();
	}
}
