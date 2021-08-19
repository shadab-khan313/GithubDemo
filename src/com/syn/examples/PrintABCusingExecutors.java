package com.syn.examples;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintABCusingExecutors {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		int i=0;
		while(i<10) {
		service.submit(()->System.out.print("A")).get();
		service.submit(()->System.out.print("B")).get();
		service.submit(()->System.out.print("C")).get();
		
		System.out.print(" ");
		i++;
		}
	}

}
