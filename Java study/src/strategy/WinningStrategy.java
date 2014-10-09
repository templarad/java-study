package strategy;

import java.util.Random;

public class WinningStrategy implements Strategy{

	private boolean won = false;
	private Random random;
	private Hand prevHand;
	public WinningStrategy(int seed){
		random = new Random(seed);
	}
	public Hand nextHand() {
		if(!won){
			prevHand = Hand.getHand(random.nextInt(3));
		}
		return prevHand;
	}

	public void study(boolean win) {
		won = win;
		
	}
	

}
