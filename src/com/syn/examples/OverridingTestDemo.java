package com.syn.examples;

import java.io.IOError;
import java.io.IOException;

class A{
	
	public void add(int a, int b) {
		System.out.println(a+b);
	}

	protected void sub(int a, int b) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(a-b);
		
	}
	
}

class B extends A{
	
	protected void sub(int a,int b) throws IOException{ 
		//System.out.println(a-b);
		System.out.println("from B : "+(a-b));
	}
	
	public void add(int a,int b) {
		System.out.println("from B : "+(a+b));
	}
}

public class OverridingTestDemo {
	
	public static void main(String[] args) throws Exception {
		
		A b = new B();
		b.sub(10,20);
	}
	
	

}
