package shoppingCart;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		Cart cart = new Cart();
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do
		{
			System.out.println("MENU");
			System.out.println("1. Add item to cart");
			System.out.println("2. Remove item from cart");
			System.out.println("3. Generate bill");
			System.out.println("4. Exit");
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
		
			switch(choice)
			{
				case 1: System.out.println("Enter the pid, name, price, quantity of the item");
						int pid = sc.nextInt();
						String name = sc.next();
						double price = sc.nextDouble();
						int quantity = sc.nextInt();
						cart.addProduct(pid, name, price, quantity);
						break;
				
				case 2: System.out.println("Enter the product ID of the item to be removed:");
						int pid1 = sc.nextInt();
						cart.removeProduct(pid1);
						break;
				
				case 3: cart.generateBill();
						break;
				
				case 4: break;
		
			default: System.out.println("Wrong input!! Try again!!");
		
			}
		}while(choice != 4);

	}
}
