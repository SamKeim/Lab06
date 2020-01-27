import java.util.Scanner;
public class rollDice {

	public int rollDie(int sides) {
		//rolls one dice, the number of sides is passed in as an argument
		return (int) (Math.random() * sides) + 1;
	}
	
	public String rollingTwoDice(int sides, int counter) {
		// create objects
		rollDice cls = new rollDice();
		Scanner scnr = new Scanner(System.in);
		
		// number of roll, counter passed in as a variable
		System.out.println("Roll " + counter);
		
		// stores two dice rolls in integer variables
		int diceA = cls.rollDie(sides);
		int diceB = cls.rollDie(sides);
		
		// bonus, display special messages for craps, snake eyes, and box cars
		String crapsString = "";
		int crapsInt = diceA + diceB;
		
		// Frist checks if it's a six sided die, and if the sum balance equals requirements
		if (sides == 6 && (crapsInt == 2 || crapsInt == 12 || crapsInt == 3)) {
			if (crapsInt == 2) {
				crapsString = "Craps and Snake Eyes!\n";
			} else if (crapsInt == 3) {
				crapsString = "Craps!\n";
			} else {
				crapsString = "Craps and Box Cars!\n";
			}
		}
		
		//returns string of result  of both dice and special message (if craps)
		return diceA + "\n" + diceB + "\n" + crapsString;
	}
	
	public static void main(String[] args) {
		//create objects
		rollDice cls = new rollDice();
		Scanner scnr = new Scanner(System.in);
		String userChoice = "";
		
		// Initial run
		System.out.println("Welcome to the Grand Circus Casino!");
		System.out.println("How many sides should each die have?");
		int userSides = scnr.nextInt();
		int counter = 1; // Counts how many dies rolls have been made, per example
		System.out.println(cls.rollingTwoDice(userSides, counter));
		System.out.println("Roll again? (Y/N)");
		userChoice = scnr.next();
		
		// Begins loop for continued rolls
		do {	
			if(userChoice.equalsIgnoreCase("Y")) {
				counter ++; // Adds to counter
				System.out.println("How many sides should each die have?");
				userSides = scnr.nextInt();
				System.out.println(cls.rollingTwoDice(userSides, counter));
				System.out.println("Roll again? (Y/N)");
				userChoice = scnr.next();
			} else if (userChoice.equalsIgnoreCase("N")) {
				System.out.println("Thank you, goodbye.");
				break;
			} else {
				System.out.println("Please enter a valid selection.");
			}
		} while (true);
	}
}
