package shoppingCart;

import java.util.Calendar;

public class FixedOrderPromotion implements Promotion
{
	double minimumPrice, fixedDiscount;
	
	FixedOrderPromotion(double minimumPrice)
	{
		this.minimumPrice = minimumPrice;
		setFixedDiscount();
	}
	
	public void setFixedDiscount()
	{
		fixedDiscount = 0.05;
	}
	
	public double getFixedDiscount()
	{
		 return fixedDiscount;
	}
	
	public double getMinimumPrice()
	{
		return minimumPrice;
	}
	
	public void setMinimumPrice(double minPrice)
	{
		this.minimumPrice = minPrice;
	}
	
	public void setFixedDiscount(double fixedDiscount)
	{
		this.fixedDiscount = fixedDiscount;
	}
	
	public boolean isPromotionApplicable(double totalBill, String userCode)
	{
		if(totalBill >= getMinimumPrice())
		{
		    Calendar calenderObject = Calendar.getInstance();												
		    int dayOfMonth = calenderObject.get(Calendar.DAY_OF_MONTH);
		    
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
		return false;
	}
}