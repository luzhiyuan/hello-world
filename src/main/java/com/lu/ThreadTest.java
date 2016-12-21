package com.lu;

/**
 * 此demo说明，如果新启了子线程，要等到子线程执行结束，主线程才会结束
 * 
 * @author lzy
 */
public class ThreadTest implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
	public static void main(String[] args) {
		ThreadTest t = new ThreadTest();
		t.call();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
	public void call(){
		ThreadTest t = new ThreadTest();
		Thread thread = new Thread(t);
		thread.start();
	}
}
