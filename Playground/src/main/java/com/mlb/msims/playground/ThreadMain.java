package com.mlb.msims.playground;

public class ThreadMain {
	
	public static void main(String... args) throws InterruptedException{
		Object lock = new Object();
		NonStaticVar nsv = new NonStaticVar();
		Runner1 r1 = new Runner1(lock,nsv);
		Thread t1 = new Thread(r1);
		NonStaticVar nsv2 = new NonStaticVar();
		Runner2 r2= new Runner2(lock,nsv2);
		Thread t2 = new Thread(r2);
		t1.start();
		Thread.sleep(1000);
		t2.start();
		Thread.sleep(2000);
		System.out.println(nsv.nonStaticVar);
	}
	
	public static class Runner1 implements Runnable{
		
		private  NonStaticVar nsv;
		private Object lock;
		
		public Runner1(Object lock,NonStaticVar nsv){
			this.nsv = nsv;
			this.lock = lock;
		}
		
		@Override
		public synchronized void run() {
			nsv.nonStaticVar = 1;
			System.out.println("r1 " + nsv.nonStaticVar);
		    try {
				synchronized(lock){
					lock.wait();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("r1 " + nsv.nonStaticVar);
		}
		
	}
	
	public static class Runner2 implements Runnable{
		private NonStaticVar nsv;
		private Object lock;
		
		public Runner2(Object lock,NonStaticVar nsv){
			this.nsv = nsv;
			this.lock = lock;
		}
		
		@Override
		public synchronized void run() {
			nsv.nonStaticVar = 2;
			System.out.println("r2 " + nsv.nonStaticVar);
			synchronized(lock){
				lock.notify();
			}
			System.out.println("r2 " + nsv.nonStaticVar);
		}
		
	}
}


