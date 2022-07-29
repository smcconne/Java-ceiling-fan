import java.util.*;

public class FanController {
	public static void main(String[] args) {
		// Initialize variables
		Scanner sc = new Scanner(System.in);
		int userInput;
		CeilingFan newFan = new CeilingFan();
	
		outerloop:
		while(true) {
			// Main menu
			System.out.println("\nPick an option to interact with the ceiling fan:");
			System.out.println("0 - Observe the fan");
			System.out.println("1 - Pull cord one");
			System.out.println("2 - Pull cord two");
			System.out.println("3 - Exit program");
			System.out.print(">> ");
			
			try {
				// Read user input as an int
				userInput = sc.nextInt();
				
				switch(userInput) {
				case 0: // Observe the fan
					observeFan(newFan);
					break;
				case 1: // Pull cord one
					pullCord1(newFan);
					break;
				case 2: // Pull cord two
					pullCord2(newFan);
					break;
				case 3: // Exit program
					System.out.println("You decide to leave the fan alone.");
					break outerloop;
				default: // User inputs an out-of-range integer
					System.out.println("Please press a valid option number and hit enter.");
				}
			}
			catch(InputMismatchException e) { // User input is not an integer
				sc.next(); // Free the scanner for new input
				System.out.println("Please press a valid option number and hit enter.");
			}
			catch(Exception e) { // Unknown error
				System.out.println("An unexpected error occurred: " + e + "\n Please report this to a developer.");
			}
		}
	}
	
	// Print current fan setting
	private static void observeFan(CeilingFan newFan) {
		int currentSetting = newFan.checkFanSetting();
		if (currentSetting == 0) {
			System.out.println("The fan is not moving.");
		}
		else {
			System.out.print("The fan is moving ");
			// Check fan direction
			if (currentSetting > 0) {
				System.out.println("clockwise at speed " + currentSetting + ".");
			}
			else {
				// Counterclockwise speed is displayed as a positive int for readability
				System.out.println("counterclockwise at speed " + (currentSetting * -1) + ".");
			}
		}
	}
	
	// Pull cord one to change fan speed and print a suitable message
	private static void pullCord1(CeilingFan newFan) {
		newFan.changeSpeed();
		System.out.print("You pulled cord one. ");
		
		// Determine spin direction
		int currentSetting = newFan.checkFanSetting();
		String direction = "clockwise";
		if (currentSetting < 0) {
			direction = "counter" + direction;
		}
		
		// Display a descriptive message
		switch(currentSetting) {
		case 0:
			System.out.println("The fan slows down more and more, and eventually comes to a stop.");
			break;
		case 1:
		case -1:
			System.out.println("The fan boots up, spinning " + direction + " at a steady, leisurely pace.");
			break;
		case 2:
		case -2:
			System.out.println("The fan picks up more " + direction + " speed and you feel a light breeze.");
			break;
		case 3:
		case -3:
			System.out.println("The fan spins " + direction + " so quickly, loose paper starts blowing around!");
			break;
		}
	}
	
	// Pull cord two to reverse spin direction and print a suitable message
	private static void pullCord2(CeilingFan newFan) {
		newFan.reverseDirection();
		System.out.print("You pulled cord two. ");
		
		//Display a descriptive message
		int currentSetting = newFan.checkFanSetting();
		if (newFan.checkFanSetting() != 0) {
			System.out.println("The fan slows down, reverses direction and builds back up to speed!");
		}
		else {
			System.out.println("The fan remains motionless.");
		}
	}
}