package shoppingCart;

import java.util.Scanner;

public class MainCart
{
	public static void main(String[] args)
	{
		int choice, productId, quantity, newProductId;
		String name;
		double price;
		FixedOrderPromotion fixedOrderPromotion = new FixedOrderPromotion(5000.00);				// set the limits for discounts
		ProductPromotion fixedProductPromotion = new ProductPromotion(20);
	
		Cart cart = new Cart();
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.println("MENU");
			System.out.println("1. Add item to cart");
			System.out.println("2. Remove item from cart");
			System.out.println("3. Generate bill");
			System.out.println("4. Checkout");
			System.out.println("5. Exit");
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
						newProductId = sc.nextInt();
						cart.removeProduct(newProductId);
						break;
				
				case 3: cart.generateBill();
						break;
				
				case 4: cart.totalPromotion(fixedOrderPromotion, fixedProductPromotion);
		        		break;
		        		
				case 5: break;
		
				default: System.out.println("Wrong input!! Try again!!");
			}
		}while(choice != 5);
	}
}
