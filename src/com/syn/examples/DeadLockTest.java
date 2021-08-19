package com.syn.examples;

public class DeadLockTest {
	
	public static void main(String[] args) {
		
	

	String s1 = "John";
	String s2 = "Jenny";

	Thread t1=new Thread(){

	public void run(){

	synchronized(s1){

	System.out.println(Thread.currentThread().getName()+" :: Locked s1");

	try{Thread.sleep(400);}catch(InterruptedException e){
	// TODO Auto-generated catch block
	e.printStackTrace();}

	synchronized(s2){

	System.out.println(Thread.currentThread().getName()+" :: Locked s2");}

	}}

	};

       Thread t2 = new Thread() {
		
		public void run() {
			
			synchronized (s2) {
				
				System.out.println(Thread.currentThread().getName()+" :: Locked s2");
				
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				synchronized (s1) {
					
					System.out.println(Thread.currentThread().getName()+" :: Locked s1");
				}
				
			}
		}
		
	};
	
	t1.start();
	t2.start();
	
	}
}
