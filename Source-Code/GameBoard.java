

public class GameBoard {
    
    //delcare instance variables
    public int [][] numbers = new int[9][9];
    private int count=0;
    //empty constructor
    public GameBoard () {
       
    }
    //initialize the instance variables
    public GameBoard (int [][]initial) {
        for(int i = 0; i < initial.length; i++) {
            System.arraycopy(initial[i], 0, numbers[i], 0, initial[i].length);    
        }
    }
    //returns true if the numbers is already in the given row
    private boolean isInRow(int row, int number) {
	for (int i = 0; i < 9; i++) {
            if (numbers[row][i] == number) {
		return true;
            }
        }	
	return false;
    }
	
    //returns true if the numbers is already in the given column
    private boolean isInCol(int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (numbers[i][col] == number) {
                return true;
            }
        }
        return false;
    }
	
    //returns true if the numbers is already in the given subgrid
    private boolean isInBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;
		
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (numbers[i][j] == number) {
                    return true;
                } 
            } 
        }
            return false;
    }
	
    //returns true if this is a legal placement for a sudoku number
    public boolean isOk(int row, int col, int number) {
        return !isInRow(row, number)  &&  !isInCol(col, number)  &&  !isInBox(row, col, number);
    }
        
    public boolean solve() {
        //construct loops to iterate over whole array
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //if the current number is zero test the outcome if the number is 1, 2, 3...
                if (numbers[i][j] == 0) {
                    for (int number = 1; number <= 9; number++) {
                        //if it is legal, place the number into the puzzle
                        if (isOk(i, j, number)) {
                            numbers[i][j] = number;
                            //if a solution works for this placement return true
                            if (solve()) { 
                                return true;
                            } 
                            //if there is no solution for this number set the position back to zero
                            else { 
                                numbers[i][j] = 0;
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }   
    //returns true if there are no zeros left in the puzzle
    public boolean solveNum() {
        //construct loops to iterate over whole array
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                //if the current number is zero test the outcome if the number is 1, 2, 3...
                if (numbers[row][col] == 0) {
                    //returns false if there are zeros left after this solution strand
                    for (int number = 1; number <= 9; number++) {
                        //if it is legal, place the number into the puzzle
                        if (isOk(row, col, number)) {
                            numbers[row][col] = number;
                            //if a solution works for this placement return true
                            //increment count if there is a solution
                            if (solveNum()) { 
                                count++;
                            } 
                            //if there is no solution for this number set the position back to zero
                            else { 
                                numbers[row][col] = 0;
                            }
                        }
                    }
                    
                    return false;
                }
            }
        }

        return true;
    }
    //returns the count of the number of solutions
    public int numOfSolutions(){
        solveNum();
        return count;
    }
}
