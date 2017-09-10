import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		WhackAMole whackAMole = new WhackAMole(50, 10);

		println("********** Welcome to the Whack A Mole game!!! *********");

		while(whackAMole.areThereAvailableAttemps())
		{
			println("Insert the position X.");
			int x = sc.nextInt();

			println("Insert the position Y.");
			int y = sc.nextInt();

			if (x == -1 & y == -1)
			{
				whackAMole.printGrid();
				println("You are leaving the game. :'(");
				System.exit(0);
			}

			if(whackAMole.areThereMoles() == false)
			{
				println("You win the game!!!. Final Score: " + whackAMole.getScore());
				whackAMole.printGrid();
				System.exit(0);
			}
            clearConsole();
            println("--------------------------------");
            whackAMole.printGridToUser();

			whackAMole.whack(x, y);
		}
	}

	private static void println(String message)
	{
		System.out.println(message);
	}

	private static void clearConsole()
	{
		try 
        {
            Runtime.getRuntime().exec("cmd cls");
        }
        catch(final Exception e)
        {
            System.out.print(e);
        }
	}
}
