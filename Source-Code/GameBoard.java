/**
 * 
 * @author 100661873
 */

public class GameBoard {

   public int [][] numbers = new int[9][9];
   private int count=0;
   public GameBoard () {
       
   }
   public GameBoard (int [][]initial) {
        for(int i = 0; i < initial.length; i++) {
            System.arraycopy(initial[i], 0, numbers[i], 0, initial[i].length);    
        }
    }

    private boolean isInRow(int row, int number) {
	for (int i = 0; i < 9; i++) {
            if (numbers[row][i] == number) {
		return true;
            }
        }	
	return false;
    }
	
	
    private boolean isInCol(int col, int number) {
            for (int i = 0; i < 9; i++) {
		if (numbers[i][col] == number) {
                    return true;
                }
            }
            return false;
	}
	
	
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
	
	
	public boolean isOk(int row, int col, int number) {
            return !isInRow(row, number)  &&  !isInCol(col, number)  &&  !isInBox(row, col, number);
    }
        
    public boolean solve() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
          
                if (numbers[i][j] == 0) {
                    for (int number = 1; number <= 9; number++) {
                        if (isOk(i, j, number)) {
                            numbers[i][j] = number;
                            if (solve()) { 
                                return true;
                            } 
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
    public boolean solveNum() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
          
                if (numbers[row][col] == 0) {
                    for (int number = 1; number <= 9; number++) {
                        if (isOk(row, col, number)) {
                            numbers[row][col] = number;
                            if (solveNum()) { 
                                count++;
                            } 
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
    public int numOfSolutions(){
        solveNum();
        return count;
    }
}
