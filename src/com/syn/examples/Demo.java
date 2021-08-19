package com.syn.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Demo {
	
	public static void main(String[] args) {
		int[] numbers = {1,2,2,3,3,4,5,6,7,7,8,9,9,9,9};
		Map<Integer, Integer> map = new HashMap<>();
		IntStream num = IntStream.of(numbers);
		num.forEach(n-> map.put(n, map.containsKey(n) ? (Integer)map.get(n)+1 : 1));
		map.forEach((key,val)-> {
			if((Integer)val>1) {System.out.println("Key ::"+key +", Val ::"+val);}
		});
		
		
	}
	

}
