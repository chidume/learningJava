/*
    This program simulates a standard combination lock with values 0-39
*/

public class ComboLock{
    private int dial;
    private int count;
    private int secret1;
    private int secret2;
    private int secret3;
    private boolean unlocked;
    public static final int MAX_INT_ON_LOCK = 40;    

    public ComboLock(int secret1, int secret2, int secret3){
	this.dial = 0;
	this.count = 0;			//incremented up to 2 each time user enters correct sequence
        this.secret1 = secret1;
	this.secret2 = secret2;
	this.secret3 = secret3;
	this.unlocked = false;
    }

    public void reset(){
	this.dial = 0;
	this.count = 0;
	this.unlocked = false;
    }

    public void turnLeft(int ticks){
	if(ticks == 0){ return; }	

	dial = (dial + (MAX_INT_ON_LOCK - ticks % MAX_INT_ON_LOCK)) % MAX_INT_ON_LOCK;
	System.out.printf("dial: %d\n", dial);

	if(secret2 == dial && count == 1){
	    count++;
	}else{
 	    this.count = 0;
        }
    }

    public void turnRight(int ticks){
	if(ticks == 0){ return; }

	dial = (dial + ticks) % MAX_INT_ON_LOCK;
	System.out.printf("dial: %d\n", dial);

	if(secret1 == dial && count == 0){
	    count++;
	}else if(secret3 == dial && count == 2){
	    unlocked = true;
	    System.out.println("Unlocked!");
	}else{
	    this.count = 0;
	}
    }

    public boolean open(){
        return unlocked;
    }
}