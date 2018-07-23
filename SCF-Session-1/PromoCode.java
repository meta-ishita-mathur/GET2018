package shoppingCart;

public enum PromoCode 
{

	first("Promo1", 1, 10), second("Promo2", 11, 20), third("Promo3", 21, 30);
    String promoCode;
    int startDate, endDate;

	PromoCode(String promoCode, int startDate, int endDate) 
	{
		this.promoCode = promoCode;
		this.startDate = startDate;
		this.endDate   = endDate;
    }
	
	public String getPromoCode() 
	{
		return promoCode;
	}
	
	public int getStartDate() 
	{
		return startDate;
	}
	
	public int getEndDate() 
	{
		return endDate;
	}

}
