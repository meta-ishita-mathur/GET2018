package shoppingCart;

public interface Promotion 
{
	public double getMinimumPrice();
	
	public void setMinimumPrice(double minPrice);
	
	public double getFixedDiscount();
	
	public void setFixedDiscount(double fixedDiscount);
	
	public boolean isPromotionApplicable(double totalBill, String userCode);
}
