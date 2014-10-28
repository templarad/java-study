package strategy;

import java.util.Random;

public class RandomStrategy implements Strategy{
	private Hand prevHand;
	private Random random;
	
	public RandomStrategy(int seed){
		random = new Random(seed);
	}
	
	@Override
	public Hand nextHand() {
		prevHand = Hand.getHand(random.nextInt(3));
		return prevHand;
	}

	@Override
	public void study(boolean win) {
		// TODO Auto-generated method stub
		
	}

}
