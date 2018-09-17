//Thread 우선순위 조절
//권장&강제, 그런데 권장은 원하는 순서 보장 못 함

import java.util.Calendar;

class Thread1 extends Thread {
	public void run() {
		for (int i=0; i<5; i++) {
			System.out.println(Calendar.getInstance().get(Calendar.SECOND) + " : 첫번째 쓰레드");
			try {
				Thread.sleep(1000);							// 쓰레드 재우기. InterruptedException 발생, 1000이 1초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}//Thread1

class Thread2 extends Thread {
	public void run() {
		for (int i=0; i<5; i++) {
			System.out.println(Calendar.getInstance().get(Calendar.SECOND) + " : 두번째 쓰레드");
			try {
				Thread.sleep(1000);							// 쓰레드 재우기. InterruptedException 발생
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}//Thread2

class Thread3 extends Thread {
	public void run() {
		for (int i=0; i<5; i++) {
			System.out.println(Calendar.getInstance().get(Calendar.SECOND) + " : 세번째 쓰레드");
			try {
				Thread.sleep(1000);							// 쓰레드 재우기. InterruptedException 발생
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

		//t1.setPriority(Thread.MAX_PRIORITY);					//강제성 없어서 그닥 효과가... yield()라는 것도 있는데 얘도 효과 없음
		//t3.setPriority(Thread.MIN_PRIORITY);						//이렇게 다른 스레드의 우선순위를 낮추는 식으로 조금이라도 조절


		t1.start();
		try {
			t1.join();																//join은 먼저 끝내라고 시키는 메소드
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		t3.start();
	}
}