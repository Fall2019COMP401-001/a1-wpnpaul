package a1;

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
			orderOutputs[i][1] = Double.toString(total);
		}
		int bigIndex = findBiggest(orderOutputs);
		int smallIndex = findSmallest(orderOutputs);
		System.out.println("Biggest: " + orderOutputs[bigIndex][0] + " (" + String.format("%.2f", Double.parseDouble(orderOutputs[bigIndex][1])) + ")");
		System.out.println("Smallest: " + orderOutputs[smallIndex][0] + " (" + String.format("%.2f", Double.parseDouble(orderOutputs[smallIndex][1])) + ")");
		System.out.println("Average: " + average(orderOutputs));
		scan.close();
		
	}
	
	static int findBiggest(String[][] array) {
		int index = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (Double.parseDouble(array[i][1]) > Double.parseDouble(array[index][1])) {
				index = i;
			}
		}
		return index;
	}
	
	static int findSmallest(String[][] array) {
		int index = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (Double.parseDouble(array[i][1]) < Double.parseDouble(array[index][1])) {
				index = i;
			}
		}
		return index;
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
