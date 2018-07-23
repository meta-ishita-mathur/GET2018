package shoppingCart;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart 
{
    ArrayList<Product> cartItems = new ArrayList<Product>();
    
    public void addProduct(int productId, String name, double price, int quantity)
    {
    	int updateList = 0, newQuantity;
    	Product item;
		for(Product product : cartItems)
		{
			if(product.getName().equals(name))
			{
				updateList = 1;
				newQuantity = product.getQuantity();
				product.setQuantity(quantity + newQuantity);
				break;
			}
		}
		if(updateList == 0)
		{
			item = new Product(productId, name, price, quantity);
			cartItems.add(item);
		}       
    }

    public void removeProduct(int productId) 
    {
    	for(Product product : cartItems)
    	{
    		if(productId == product.getProductId())
			{
				cartItems.remove(product);
				break;
			}
    	}
    }

    public double generateBill()
	{
		double sum = 0;
		System.out.println("productId\t\tname\t\tprice\t\tquantity\ttotal price");
		for(Product product : cartItems)
		{
			product.display();
			sum += product.totalPrice();
		}
		System.out.println();
		System.out.println("Grand Total:  " + sum);
		return sum;
	}
    
    public void totalPromotion(FixedOrderPromotion fixedOrderPromotion, ProductPromotion fixedProductPromotion)
	{
		String userCode;
		double totalDiscount = 0.0, totalBill = generateBill();
		int totalQuantity = 0;
		
		Scanner scan = new Scanner(System.in);
		Product newProduct = new Product();
		
		
		for(Product product : cartItems) 
		{
			totalQuantity += product.getQuantity();
		}
		
		System.out.print("Enter Promo code (Enter no if you don't have any) : ");
		userCode = scan.next();
		
		if(fixedOrderPromotion.isPromotionApplicable(totalBill, userCode))
		   totalDiscount = fixedOrderPromotion.getFixedDiscount() * totalBill;
		
		else if(fixedProductPromotion.isPromotionApplicable(totalQuantity, userCode))	// checking no of product & amount based discount
				totalDiscount = fixedProductPromotion.getFixedDiscount() * totalBill;
		
		System.out.println("Total discount applicable is : " + totalDiscount);
		System.out.println("\n************************\nFinal Payment : " +  (totalBill - totalDiscount) + "\n************************\n");
	}

}
