package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int numCustomers = scan.nextInt();
		String orderOutputs[] = new String[numCustomers];
		
		for (int i = 0; i < numCustomers; i++) {
			String firstName = scan.next();
			String name = firstName.substring(0, 1) + ". " + scan.next();
			int numOfItems = scan.nextInt();
			
			double total = 0.0;
			for (int j = 0; j < numOfItems; j++) {
				int quantity = scan.nextInt();
				scan.next();
				double price = scan.nextDouble();
				
				total = total + quantity * price;
			}
			String customerOrderTotal = name + ": " + String.format("%.2f", total);
			orderOutputs[i] = customerOrderTotal;
		}

		for (int i = 0; i < numCustomers; i++) {
			System.out.println(orderOutputs[i]);
		}
		scan.close();
	}
}
