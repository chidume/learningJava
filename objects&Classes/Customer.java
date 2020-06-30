/**
    After accumulating $100 in purchases, the customer receives a $10 discount
*/

public class Customer{
    private boolean hasDiscount; 
    private double progressToNextDiscount;
    private static final double DISCOUNT = 10;
    private static final double DISCOUNT_THRESHOLD = 100;

    public Customer(){
	hasDiscount = false; 
	progressToNextDiscount = 0;
    }

    public void makePurchase(double amount){
	if(amount < 0){  
	    System.out.println("Invalid amount!");
	    return;
	}
	
	double discountedAmount = amount;
	if(hasDiscount()){
	    discountedAmount = (discountedAmount <= 10) ? 0 : discountedAmount - DISCOUNT; 
	    setDiscount(false);   
	}

	updateProgressToNextDiscount(discountedAmount);

	System.out.println("has discount: " + hasDiscount);
	System.out.println("progress to next discount: " + progressToNextDiscount);
	System.out.println("------------------------------------------------");
    }

    public boolean hasDiscount(){
	return hasDiscount;
    }
    
    public void setDiscount(boolean discount){
	hasDiscount = discount;
    } 

    private void updateProgressToNextDiscount(double amount){
	progressToNextDiscount += amount;
	if(progressToNextDiscount >= DISCOUNT_THRESHOLD ){
	    progressToNextDiscount %= DISCOUNT_THRESHOLD;
	    setDiscount(true);
        }
    }
}