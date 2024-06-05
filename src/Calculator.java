
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		boolean again = true; 
		int n1 = 0;
		int n2 = 0;
		int operation = 0; 
		double result = 0;
		char opChar= ' ';
		Scanner readNum = new Scanner(System.in);
		
		System.out.printf("Welcome to the Simple Calculator!%n");
		
		while (again) {
			System.out.printf("Enter the first number: ");
			n1 = readNum.nextInt();
			System.out.printf("Enter the second number: ");
			n2 = readNum.nextInt();
			
			while (operation < 1 || operation >5) {
				System.out.printf("Select an operation:%n1. Addition%n2. Subtraction%n3. Multiplication%n4. Division%nEnter the operation number: ");
				operation = readNum.nextInt();
				if (operation <1 || operation > 4)
					System.out.println("Invalid Entry!");
			}
			
			switch(operation) {
			
				case 1:
					result = n1 + n2;
					opChar='+';
					break;
				case 2:
					result = n1 - n2;
					opChar='-';
					break;
				case 3:
					result = n1 * n2;
					opChar='*';
					break;
				case 4: 
					if (n2 != 0) { //check for divide by zero
						result = (double) n1 / n2;
						opChar='/';
					} else { //if divide by zero is requested, repeat the input process. 
						System.out.println("Error: Division by zero not allowed.");
						operation = 0 ; 
						continue;
					}
					break;
			}
			
			if (operation != 4 || result % 1 == 0) {
				//for operations with an integer output
				System.out.printf("Result: %d %c %d = %.0f%n", n1, opChar, n2, result);
			} else {
				//for operations with a decimal output round to 2 decimal places
				System.out.printf("Result: %d %c %d = %.2f%n", n1, opChar, n2, result);
			}
			System.out.println("Do you want to perform another calculation? (yes/no): ");
			
			readNum.nextLine(); //Consume leftover newline character from nextInt
			if(!readNum.nextLine().trim().equals("yes"))
				again = false; 
			operation = 0; 
			
			
		}
		System.out.println("Goodbye!");
		readNum.close(); 
		

	}

}
