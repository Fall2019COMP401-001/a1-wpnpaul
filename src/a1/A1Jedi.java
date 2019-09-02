package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int numItems = scan.nextInt();
		String itemCatelog[] = new String[numItems];
		int itemQuantity[] = new int[numItems];
		int numCustomersBoughtItem[] = new int[numItems];
		
		for (int i = 0; i < numItems; i++) {
			String item = scan.next();
			String price = scan.next();
			itemCatelog[i] = item;
		}
		
		int numCustomers = scan.nextInt();
		boolean[][] hasBought = new boolean[numCustomers][numItems];
		
		for (int i = 0; i < numCustomers; i++) {
			String fullName = scan.next() + " " + scan.next();
			int customerItems = scan.nextInt();
			
			for (int j = 0; j < customerItems; j++) {
				int quantity = scan.nextInt();
				String item = scan.next();

				for (int k = 0; k < numItems; k++) {
					if (itemCatelog[k].equals(item)) {
						itemQuantity[k] = itemQuantity[k] + quantity;
						if (!hasBought[i][k]) {
							numCustomersBoughtItem[k] = numCustomersBoughtItem[k] + 1;
						}
						hasBought[i][k] = true;
					}
				}
			}
		}
		
		for (int i = 0; i < itemCatelog.length; i++) {
			if (itemQuantity[i] == 0) {
				System.out.println("No customers bought " + itemCatelog[i]);
			}
			else {
				System.out.println(numCustomersBoughtItem[i] + " customers bought " + itemQuantity[i] + " " + itemCatelog[i]);
			}
		}
	}
}
