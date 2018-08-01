package shoppingCart;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		Cart cart = new Cart();
		Scanner sc = new Scanner(System.in);
		int choice, productId, quantity, productId1;
		String name;
		double price;
		
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
					productId = sc.nextInt();
					name = sc.next();
					price = sc.nextDouble();
					quantity = sc.nextInt();
					cart.addProduct(productId, name, price, quantity);
					break;
				
				case 2: System.out.println("Enter the product ID of the item to be removed:");
					productId1 = sc.nextInt();
					cart.removeProduct(productId1);
					break;
				
				case 3: cart.generateBill();
					break;
				
				case 4: break;
		
				default: System.out.println("Wrong input!! Try again!!");
			}
		}while(choice != 4);
	}
}
