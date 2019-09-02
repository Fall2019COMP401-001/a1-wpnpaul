package a1;

import java.util.Arrays;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int numItems = scan.nextInt();
		String itemCatelog[][] = new String[numItems][2];
		
		for (int i = 0; i < numItems; i++) {
			String item = scan.next();
			String price = scan.next();
			itemCatelog[i][0] = item;
			itemCatelog[i][1] = price;
		}
		
		int numCustomers = scan.nextInt();
		String orderOutputs[][] = new String[numCustomers][2];
		
		for (int i = 0; i < numCustomers; i++) {
			String name = scan.next() + " " + scan.next();
			int customerItems = scan.nextInt();
			
			double total = 0.0;
			
			for (int j = 0; j < customerItems; j++) {
				int quantity = scan.nextInt();
				String item = scan.next();
				
				for (int k = 0; k < numItems; k++) {
					if (item.equals(itemCatelog[k][0])) {
						total = total + quantity * Double.parseDouble(itemCatelog[k][1]);
						break;
					}
				}
			}
			
			orderOutputs[i][0] = name;
			orderOutputs[i][1] = String.format("%.2f", total);
		}
		outputSort(orderOutputs);
		int last = orderOutputs.length - 1;
		System.out.println("Biggest: " + orderOutputs[last][0] + " (" + orderOutputs[last][1] + ")");
		System.out.println("Smallest: " + orderOutputs[0][0] + " (" + orderOutputs[0][1] + ")");
		System.out.println("Average: " + average(orderOutputs));
	}
	
	static void outputSort(String[][] array) {
		String tempName;
		String tempValue;
		
		for (int i = 0; i < (array.length - 1); i++) {
			double currentVal = Double.parseDouble(array[i][1]);
			double nextVal = Double.parseDouble(array[i+1][1]);
			if (currentVal > nextVal) {
				tempName = array[i][0];
				tempValue = array[i][1];
				
				array[i][0] = array[i+1][0];
				array[i][1] = array[i+1][1];
				array[i+1][0] = tempName;
				array[i+1][1] = tempValue;
			}
		}
	}
	
	static String average(String[][] array) {
		double total = 0.0;
		for (int i = 0; i < array.length; i++) {
			total = total + Double.parseDouble(array[i][1]);
		}
		double average = total / array.length;
		return String.format("%.2f", average);
	}
}
