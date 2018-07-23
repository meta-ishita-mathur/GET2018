package shoppingCart;

public class Product 
{
	private int productId, quantity;
	private String name;
	private double price;
	
	public Product()
	{
		
	}
	
	public Product(int productId, String name, double price, int quantity)
	{
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public int getProductId()
	{
		return productId;
	}
	
	public void setProductId(int productId)
	{
		this.productId = productId;
	}
	
	public double totalPrice()
	{
		return price * quantity;
	}
	
	public void display()
	{
		System.out.println(productId + "\t\t" + name + "\t\t" + price + "\t\t" + quantity+"\t\t" + totalPrice());
	}
}