/**
    discount is awarded if a customer makes purchases in at least three 
    out of 20 different shops, spending a total of $100 or more
*/

public class DowntownShopper{
    private boolean hasDiscount;  
    private double[] shops;
    private double totalAmountPurchased;
    private int numOfShopsPurchasedFrom;
    private static final double DISCOUNT = 10;
    private static final int NUM_OF_SHOPS = 20;
    private static final double DISCOUNT_THRESHOLD = 100;

    public DowntownShopper(){
	hasDiscount = false;
	shops = new double[NUM_OF_SHOPS];
	totalAmountPurchased = 0;
	numOfShopsPurchasedFrom = 0; 
    }

    public void makePurchase(double amount, int shop){
	if(amount < 0){  
	    System.out.println("Invalid amount!");
	    return;
	}

	if(-1 > shop || shop > shops.length){
	   System.out.println("Invalid shop!");
	   return;
	}
	
	System.out.println("amount: " + amount);

	if(shops[shop] == 0){  numOfShopsPurchasedFrom++; } 
	
	double discountedAmount = amount;
	if(hasDiscount()){
	   discountedAmount = amount - DISCOUNT;		
	   shops[shop] = (amount <= 10) ? shops[shop] : shops[shop] + discountedAmount;
        }else{
	    shops[shop] += discountedAmount;
	}

	totalAmountPurchased += discountedAmount; 

	System.out.println("has discount: " + hasDiscount); 
	System.out.println("shop " + shop + ": " + shops[shop]);
	System.out.println("total amount purchased: " + totalAmountPurchased);
	System.out.println("number of shops purchased from: " + numOfShopsPurchasedFrom);
	System.out.println("------------------------------------------------");
    }

    public boolean hasDiscount(){
	if(numOfShopsPurchasedFrom > 3 && totalAmountPurchased > DISCOUNT_THRESHOLD){
	    setDiscount(true);
	}

	return hasDiscount;
    }
    
    public void setDiscount(boolean discount){
	hasDiscount = discount;
    }
}