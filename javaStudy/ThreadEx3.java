//Thread ����ȭ synchronized

class BreadPlate {
	private int cnt;					//�� ����
	public synchronized void sell() {				//--
		if(cnt>0) {
			cnt--;
			System.out.println("�� �Ǹ� : " +cnt+ "��");
			notifyAll();
		} else {
			System.out.println("���� ���ڶ���");
			try {
				wait(0);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		public synchronized void run() {
			for (int 1=0; i<20; i++) {
				bp.sell();
			}
		}
	}
	public void make() {			//++
		if(cnt<10) {
			System.out.println("�� ���� : "+cnt+"��");
			notifyAll();
		} else {
			System.out.println("���� ���´�");
			try {
				wait();
			} catch 
		}
	}
}//������

class BreadSeller extends Thread {
	private BreadPlate bp;
	public Breadseller (BreadPlate bp) {
	}
	public synchronized void run() {
		bp.sell();
	}
}

class BreadMaker extends Thread {
	private BreadPlate bp;
	public BreadMaker(BreadPlate bp) {
		this.bp = bp;
	}
	public synchronized void run() {
		for (int i=0; i<20); i++) {
			bp.make();
		}
	}
}

class ThreadEx3 BreadSeller extends

class ThreadEx3 { 
	public static void main(String[] args)	{
	Breadplate  = bp = new Breadplate();
	Breadseller bs = new BreadCeller();
	Breadplate c
		bs.start();
		bsp.start();
	}
}
