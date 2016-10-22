package virtualPet;

import java.util.Random;

public class VirtualPet {

	int boredom;
	int hunger;
	int sleepiness;
	Random randomGenerator = new Random();

	public VirtualPet() {
		// TODO Auto-generated constructor stub
		boredom = 0;
		hunger = 0;
		sleepiness = 0;
	}

	public void petPlay() {
		boredom -= 30;
		hunger += 2;
	}

	public void petFeed() {
		hunger -= 30;
		sleepiness += randomGenerator.nextInt(2) + 5;
	}

	public void petRest() {
		hunger += randomGenerator.nextInt(2) + 5;
		sleepiness -= 30;
	}

	public void tick() {
		boredom += (randomGenerator.nextInt(4) - 2) + 10;
		hunger += (randomGenerator.nextInt(4) - 2) + 6;
		sleepiness += (randomGenerator.nextInt(4) - 2) + 4;
	}

	public int[] messageStats() {
		int[] stats = { boredom, hunger, sleepiness };
		return stats;
	}
}
