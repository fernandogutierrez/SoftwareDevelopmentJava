import java.util.Arrays;

public class WhackAMole {
	int score, molesLeft, attemptsLeft;
	char[][] moleGrid;
	private static final char MOLE = 'M';
	private static final char WHACKED_MOLE = 'W';
	private static final char UNKNOWN_CELL = '*';

	public WhackAMole(int numAttemps, int gridDimesion) {
		attemptsLeft = numAttemps;
		moleGrid = new char[gridDimesion][gridDimesion];
		molesLeft = gridDimesion;
		fillGrid();	
		placeMoles(molesLeft, gridDimesion);
	}

	private void fillGrid()
	{
		for (char[] row: moleGrid) 
		{
			Arrays.fill(row, UNKNOWN_CELL);
		}
	}

	private void placeMoles(int numberMaxMoles, int gridDimension)
	{
		int moles = numberMaxMoles;
		while (moles > 0)
		{
			int randX = (int) (Math.random() * gridDimension);
			int randY = (int) (Math.random() * gridDimension);  	
			if (moleGrid[randX][randY] != MOLE)   
			{
				moleGrid[randX][randY] = MOLE;
				moles --;
			}
		}
	}

	public boolean place(int x, int y)
	{
		if (moleGrid[x][y] != MOLE)
		{
			moleGrid[x][y] = MOLE;
			return true;
		}
		return false;
	}

	public boolean areThereAvailableAttemps()
	{
		return attemptsLeft > 0 ? true: false;
	}

	public boolean areThereMoles()
	{
		return molesLeft > 0 ? true: false;
	}

	public void whack(int x, int y)
	{
		if(attemptsLeft > 0 & moleGrid[x][y] == MOLE)
		{
			score ++;
			molesLeft --;
			moleGrid[x][y] = WHACKED_MOLE;
		}
		attemptsLeft --;
	}

	public void printGridToUser()
	{
		for (char[] row: moleGrid) 
		{
			for (char cell: row)
			{
				if (cell == MOLE) 
				{
					System.out.print(UNKNOWN_CELL);
				}
				else 
				{
					System.out.print(cell);
				}
			}
			System.out.println();
		}
	}

	public void printGrid()
	{
		for (char[] row: moleGrid) 
		{
			for (char cell: row)
			{
				System.out.print(cell);
			}
			System.out.println();
		}
	}
}
