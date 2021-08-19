package com.syn.examples;

import java.io.IOException;

class Overloaded {

	protected void add(int a, int b) throws Exception{

		System.out.println("from 1st methoed :: " + (a + b));
	}

	protected void add(long a, int b) {

		System.out.println("from 2nd methoed :: " + (a + b));
		//return 0;
	}
}

public class OverloadingTestDemo {

	public static void main(String[] args) throws Exception {
		Overloaded o = new Overloaded();
		o.add(10L, 20);
		

	}

}
