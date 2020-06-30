public class ComboLockTester{
    public static void main(String[] args){
	ComboLock lock = new ComboLock(1,2,3);
	lock.turnRight(1);
	lock.turnLeft(39);
	lock.turnRight(1);
    }
}