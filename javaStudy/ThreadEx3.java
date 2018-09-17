//Thread 동기화 synchronized

class BreadPlate {
	private int cnt;					//빵 개수
	public synchronized void sell() {				//--
		if(cnt>0) {
			cnt--;
			System.out.println("빵 판매 : " +cnt+ "개");
			notifyAll();
		} else {
			System.out.println("빵이 모자란다");
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
			System.out.println("빵 생산 : "+cnt+"개");
			notifyAll();
		} else {
			System.out.println("빵이 남는다");
			try {
				wait();
			} catch 
		}
	}
}//빵공장

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
