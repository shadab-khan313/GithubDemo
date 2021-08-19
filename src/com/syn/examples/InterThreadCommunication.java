package com.syn.examples;

class Pattern{
	
	public volatile int status =1;
}

public class InterThreadCommunication {
	
	static Pattern p = new Pattern();
	
	public static void main(String[] args) {
		
	
	
	Thread1 t1 = new Thread1(p);
	Thread2 t2 = new Thread2(p);
	Thread3 t3 = new Thread3(p);
	
	t1.start();
	t2.start();
	t3.start();
	
	}

}

class Thread1 extends Thread{
	Pattern p1;
	public Thread1(Pattern p)
	{
		this.p1=p;
		
	}
	
	public void run() {
		
		for(int i=1;i<=10;i++) {
			synchronized (p1) {
				
			
			while(p1.status!=1) {
				try {
					p1.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			p1.status=2;
			p1.notifyAll();
			System.out.print("A");
			}
		}
	}
}

class Thread2 extends Thread{
	Pattern p2;
	public Thread2(Pattern p)
	{
		this.p2=p;
		
	}
	
	public void run() {
		
		for(int i=1;i<=10;i++) {
			synchronized (p2) {
			while(p2.status!=2) {
				try {
					p2.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			p2.status=3;
			p2.notifyAll();
			System.out.print("B");
			}
		}
	}
}


class Thread3 extends Thread{
	Pattern p3;
	public Thread3(Pattern p)
	{
		this.p3=p;
		
	}
	
	public void run() {
		
		for(int i=1;i<=10;i++) {
			synchronized (p3) {
			while(p3.status!=3) {
				try {
					p3.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			p3.status=1;
			p3.notifyAll();
			System.out.print("C");
			System.out.print(" ");
			}
		}
	}
}

