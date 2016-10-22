package virtualPet;

import java.util.Scanner;

public class VirtualPetProgram {

	private static Scanner sc;
	private static VirtualPet horace;
	private static int complaints = 0;
	private static int turns = 0;
	private static int love = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] stats;
		horace = new VirtualPet();
		sc = new Scanner(System.in);

		while (complaints < 20) {
			stats = horace.messageStats();
			displayStats(stats);
			chooseAction();
			horace.tick();
			turns++;
		}
		System.out.println("Horace Protection Services has taken custody of your pet.");
		System.out.println("He was in your care for " + turns + " days.");
		if(love >= 2){
			System.out.println("He said he loved you " + love + " times.");
		}
		else if (love == 1) {
			System.out.println("He said he loved you just once.");
		}
		else {
			System.out.println("He never said he loved you.");
		}
		

	}

	private static void chooseAction() {
		// TODO Auto-generated method stub
		System.out.println("[1] Play");
		System.out.println("[2] Feed");
		System.out.println("[3] Rest");
		System.out.println("[4] Do Nothing");
		int select = sc.nextInt();
		switch (select) {
		case 1:
			horace.petPlay();
			break;
		case 2:
			horace.petFeed();
			break;
		case 3:
			horace.petRest();
			break;
		default:
			break;
		}
	}

	public static void displayStats(int[] stats) {
		// TODO Auto-generated method stub
		System.out.println("Boredom: " + stats[0]);
		System.out.println("Hunger: " + stats[1]);
		System.out.println("Sleepiness: " + stats[2]);
		if (stats[0] > 26) {
			System.out.println("Horace is INSANE.");
			complaints += 2;
		} else if (stats[0] > 20) {
			System.out.println("Horace is bored.");
			complaints += 1;
		} else if (stats[0] < -10) {
			System.out.println("Horace is OVERSTIMULATED.");
			complaints += 2;
		}
		if (stats[1] > 26) {
			System.out.println("Horace is STARVING.");
			complaints += 2;
		} else if (stats[1] > 20) {
			System.out.println("Horace is hungry.");
			complaints += 1;
		} else if (stats[1] < -10) {
			System.out.println("Horace is STUFFED.");
			complaints += 2;
		}
		if (stats[2] > 26) {
			System.out.println("Horace is EXHAUSTED.");
			complaints += 2;
		} else if (stats[2] > 20) {
			System.out.println("Horace is tired.");
			complaints += 1;
		} else if (stats[2] < -10) {
			System.out.println("Horace is HYPER.");
			complaints += 2;
		}
		if (turns == 3 && complaints < 2) {
			System.out.println("Horace calls you \"Mama\" for the first time.");
		}
		if (turns > 3 && (turns - 2) % 7 == 0 && complaints * 2 < turns) {
			System.out.println("Horace says, \"I love you.\"");
			love++;
			}
		
//		System.out.println("T " + turns + " C " + complaints);
	}

}
