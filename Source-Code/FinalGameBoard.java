import java.util.Random;



public class FinalGameBoard{
    //delcare instance variable numbers with default sudoku layout
    public int [][] numbers= {{1,2,3,4,5,6,7,8,9},{4,5,6,7,8,9,1,2,3},{7,8,9,1,2,3,4,5,6},{2,3,4,5,6,7,8,9,1},{5,6,7,8,9,1,2,3,4},{8,9,1,2,3,4,5,6,7},{3,4,5,6,7,8,9,1,2},{6,7,8,9,1,2,3,4,5},{9,1,2,3,4,5,6,7,8}};
    
    public FinalGameBoard(){
        //create random object with seed
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        //perform pseudo random operations to randomize game layout
        for (int i = 0; i<50; i++){
            int xy = random.nextInt(20);
            int j = random.nextInt(9);
            int k = random.nextInt(9);
            if (xy <20 && xy>=15)
                flip(j/3,k/3);
            else if (xy == 14)
                transpose();
            else if (xy >=10 && xy < 14)
                colShift(j);
            else if (xy >=6 && xy<10)
                rowShift(j);
            else if (xy >= 3 && xy <6)
                colSwap(j/3, k/3);         
            else
                rowSwap(j/3, k/3);
        }
    }
    public GameBoard generateBoard (){
        //create nine-by-nine array for the numbers to be added to the board
        int [][] boardNumbers = new int[9][9];

        // create game board and random objects
        GameBoard gb;
        Random random = new Random();
        //set the seed of the random number generator
        random.setSeed(System.currentTimeMillis());
        // declare flag to check if there are multiple solutions for the gameboard
        boolean flag;
        do {
            //copy the numbers from the solution to the boardNumbers
            for(int i = 0; i < numbers.length; i++) {
                System.arraycopy(numbers[i], 0, boardNumbers[i], 0, numbers[i].length);    
            }
            //set flag to false
            flag=false;
            //randomly set pairs of numbers on the board to zero to remove the clues
            for (int j=0; j<69;j++){
            
            int x, y;
            //certain positions of x do not require as many y values as others
            x = random.nextInt(9);
            if(x>5){
                y = random.nextInt(3);
            }
            else if (x == 5){
                y = random.nextInt(4);
            }
            else if (x > 2){
                y = random.nextInt(5);
            }
            else{
                y = random.nextInt(6);
            }
            //set the numbers at x and y as well as x and y's complement to zero
            boardNumbers[x][y] = 0;
            boardNumbers[Math.abs(x-8)][Math.abs(y-8)] = 0; //}
            //create gameboard object with boardNumbers
            gb = new GameBoard (boardNumbers);
                //if the number of solutions ever increases past 1 break free of the for loop and reset variables
                if(gb.numOfSolutions()!=1){
                    flag=true;
                    break;
                }
            }
            
        } while(flag);
        
        gb= new GameBoard (boardNumbers);
        return gb;
    }
    private void transpose() {
        int [][] transpose = new int[9][9];
        for (int m = 0; m < 9; m++)
            for (int n = 0; n < 9; n++)              
                transpose[n][m] = numbers[m][n];
        for(int i = 0; i < numbers.length; i++) {
            System.arraycopy(transpose[i], 0, numbers[i], 0, transpose[i].length);    
        }
    }
    private void colShift(int j) {
        int [][] shift = new int[9][9];
        for (int m = j; m < 9; m++)
            System.arraycopy(numbers[m], 0, shift[m], 0, 9); 
        for (int m = 0; m < j; m++)
            System.arraycopy(numbers[m], 0, shift[m], 0, 9); 
        for(int i = 0; i < numbers.length; i++) {
            System.arraycopy(shift[i], 0, numbers[i], 0, shift[i].length);    
        }
    }
    private void rowShift(int j) {
        int [][] shift = new int[9][9];
        for (int m = j; m < 9; m++)
            for (int n = 0; n < 9; n++)              
                shift[n][m] = numbers[n][m]; 
        for (int m = 0; m < j; m++)
            for (int n = 0; n < 9; n++)              
                shift[n][m] = numbers[n][m]; 
        for(int i = 0; i < numbers.length; i++) {
            System.arraycopy(shift[i], 0, numbers[i], 0, shift[i].length);    
        }
    }
    private void colSwap(int j, int k){
        for (int m=0; m<3; m ++){
            for (int n=0; n < 9; n++) {
                int temp = numbers[n][3*(j)+m];
                numbers[n][3*(j)+m] = numbers[n][3*(k)+m];
                numbers[n][3*(k)+m] = temp;
            }    
        } 
    }
    private void rowSwap(int j, int k){
        for (int m=0; m<3; m ++){
           for (int n=0; n < 9; n++) {
            int temp = numbers[3*(j)+m][n];
            numbers[3*(j)+m][n] = numbers[3*(k)+m][n];
            numbers[3*(k)+m][n] = temp;
            }    
        }        
    }
    private void flip(int j, int k){
        Random random = new Random();
        int b = random.nextInt(2);
        int c = random.nextInt(3-b)+b;
        for(int n = 0; n <9; n++){
            int temp = numbers[3*(j)+b][n];
            numbers[3*(j)+b][n] = numbers[3*(j)+c][n];
            numbers[3*(j)+c][n] = temp;
        }
        b = random.nextInt(2);
        c = random.nextInt(3-b)+b;
        for(int n = 0; n <9; n++){
            int temp = numbers[n][3*(k)+b];
            numbers[n][3*(k)+b] = numbers[n][3*(k)+c];
            numbers[n][3*(k)+c] = temp;
        }
    }
}
