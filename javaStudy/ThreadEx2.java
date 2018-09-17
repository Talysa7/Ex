//Thread �켱���� ����
//����&����, �׷��� ������ ���ϴ� ���� ���� �� ��

import java.util.Calendar;

class Thread1 extends Thread {
	public void run() {
		for (int i=0; i<5; i++) {
			System.out.println(Calendar.getInstance().get(Calendar.SECOND) + " : ù��° ������");
			try {
				Thread.sleep(1000);							// ������ ����. InterruptedException �߻�, 1000�� 1��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}//Thread1

class Thread2 extends Thread {
	public void run() {
		for (int i=0; i<5; i++) {
			System.out.println(Calendar.getInstance().get(Calendar.SECOND) + " : �ι�° ������");
			try {
				Thread.sleep(1000);							// ������ ����. InterruptedException �߻�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}//Thread2

class Thread3 extends Thread {
	public void run() {
		for (int i=0; i<5; i++) {
			System.out.println(Calendar.getInstance().get(Calendar.SECOND) + " : ����° ������");
			try {
				Thread.sleep(1000);							// ������ ����. InterruptedException �߻�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}//Thread3


class ThreadEx2 {
	public static void main(String[] args) 	{
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		Thread3 t3 = new Thread3();

		//t1.setPriority(Thread.MAX_PRIORITY);					//������ ��� �״� ȿ����... yield()��� �͵� �ִµ� �굵 ȿ�� ����
		//t3.setPriority(Thread.MIN_PRIORITY);						//�̷��� �ٸ� �������� �켱������ ���ߴ� ������ �����̶� ����


		t1.start();
		try {
			t1.join();																//join�� ���� ������� ��Ű�� �޼ҵ�
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		t3.start();
	}
}