package shoppingCart;

public class Product 
{
	private int pid;
	private String name;
	private double price;
	private int quantity;
	
	public Product()
	{
		
	}
	
	public Product(int pid,String name,double price,int quantity)
	{
		this.pid=pid;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price=price;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity=quantity;
	}
	
	public int getPid()
	{
		return pid;
	}
	
	public void setPid(int pid)
	{
		this.pid=pid;
	}
	
	public double totalPrice()
	{
		return price*quantity;
	}
	
	public void display()
	{
		System.out.println(pid+"\t\t"+name+"\t\t"+price+"\t\t"+quantity+"\t\t"+totalPrice());
	}

}
