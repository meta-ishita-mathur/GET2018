package shoppingCart;

import java.util.Calendar;

public class ProductPromotion implements Promotion
{
	int minQuantity;
	double fixedDiscount, minimumPrice;
	 
	ProductPromotion(int minQuantity) 
	{
		this.minQuantity = minQuantity;					// setting up minimum price and no of products limit to avail discount
		setFixedDiscount();										// also declaring discount percent
	}
	
	public void setFixedDiscount()
	{
		fixedDiscount = 0.05;
	}
	
	public double getFixedDiscount()
	{
	    return fixedDiscount;
	}
	
	public int getMinQuantity()
	{
	    return minQuantity;
	}
	
	public void setMinimumPrice(double minPrice)
	{
		this.minimumPrice = minPrice;
	}
	
	public void setFixedDiscount(double fixedDiscount)
	{
		this.fixedDiscount = fixedDiscount;
	}
	
	public double getMinimumPrice()
	{
		return minimumPrice;
	}
	
	public boolean isPromotionApplicable(double totalQuantity, String userCode)
	{
		int dayOfMonth;
		Calendar cal = Calendar.getInstance();													
		dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		
		if(totalQuantity >= getMinQuantity())
		{
			for(PromoCode promo : PromoCode.values())
			{
				if(userCode.equals(promo.getPromoCode()))
				{
					if(dayOfMonth >= promo.getStartDate() && dayOfMonth <= promo.getEndDate())
						return true;
					else
					{
						System.out.println("SORRY!!! This promo-code is not active now.");
						return false;
					}
				}
			}
			System.out.println("SORRY!!! This promo-code doesn't exist.");
		}
		else
			System.out.println("You don't have the minimum number of products to avail any offers.");
		return false;
	}
}