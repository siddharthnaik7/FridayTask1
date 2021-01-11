/**
 * 
 */
package com.consultadd.fridaytask1;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @author siddharthnaik
 *
 */
public class FridayTaskOne {

	/**
	 * @param args
	 */
	
	Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FridayTaskOne ftOne = new FridayTaskOne();
		
		// Q1
		ftOne.starPattern();
		
		// Q2
		ftOne.numberPattern();
		
		// Q3
		ftOne.sortListByFrequency();
	}

	public void starPattern() {
		
		System.out.println("\n1. Star Pattern");
		
		System.out.println("Enter the number of rows: ");
		int rows = scanner.nextInt();
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<i+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	public void numberPattern() {
		
		System.out.println("\n2. Number Pattern");
		
		System.out.println("Enter the number of rows: ");
		int rows = scanner.nextInt();
		
		for(int i=0;i<rows;i++) {
			for(int k=rows;k>i+1;k--) {
				System.out.print(" ");
			}
			for(int j=0;j<i+1;j++) {
				System.out.print(j+1);
			}
			System.out.println();
		}
	}
	
	public void sortListByFrequency() {
		
		System.out.println("\n3. Sorted List By Frequency");
		
		int arr [] = {2,2,1,2,1,3,4,4};
		Map<Integer, Integer> valueCount = new HashMap<Integer, Integer>();
		
		Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
		
		for(int i : arr) {
			if(valueCount.containsKey(i)) {
				valueCount.replace(i, valueCount.get(i)+1);
			}else valueCount.put(i, 1);
		}
		
		
		
		valueCount.entrySet().stream()
		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		
		
		List<Integer> l = new ArrayList<Integer>(sortedMap.keySet());
		
		for(Entry<Integer, Integer> ov: sortedMap.entrySet()) {
			for(Entry<Integer, Integer> iv: sortedMap.entrySet()) {
				if(ov.getValue()==iv.getValue() && iv.getKey()>ov.getKey()) {
					int innerKey = iv.getKey();
					int outerKey = ov.getKey();
					int lIndx = l.indexOf(innerKey);
					int sIndx = l.indexOf(outerKey);
					
					l.set(lIndx, outerKey);
					l.set(sIndx, innerKey);
				}
			}
		}
		
		List<Integer> nl = new ArrayList<Integer>();
		for(int i : l) {
			int itr = sortedMap.get(i);
			while(itr>0) {
				nl.add(i);
				itr--;
			}
		}
		System.out.println(nl);
	}
}
