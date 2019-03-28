import java.awt.*;        
import java.awt.event.*;  
import javax.swing.*;     

public class Sudoku extends JFrame {
    //initialize instance variables
    //set the variables to the appropriate values
    public static final int SUDOKU_SIZE = 9;    
    public static final int SUBGRID_SIZE = 3; 
 
    
    public static final int CELL_LENGTH = 60;   
    public static final int WIDTH  = CELL_LENGTH * SUDOKU_SIZE;
    public static final int HEIGHT = CELL_LENGTH * SUDOKU_SIZE;
                                             
    public Color OPEN_BGCOLOR;
    public static final Color CC_BGCOLOR = new Color(230, 230, 230); 
    public static final Color CC_TEXT = Color.BLACK;
    public static final Font NUMBER_FONT = new Font("Serif", Font.PLAIN, 24);
 
   
    private final JTextField[][] cells = new JTextField[SUDOKU_SIZE][SUDOKU_SIZE];
 
    private final GameBoard gb;
    private final FinalGameBoard fgb;
   
   
    public Sudoku(GameBoard game, FinalGameBoard finalGame, Color customColor) {
        //set the instance variables to the provided arguments
        gb = game;
        fgb = finalGame;
        //create the content pane
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(SUDOKU_SIZE, SUDOKU_SIZE));  
        OPEN_BGCOLOR=customColor;
        //add inputlistener so the user can interact with the program
        InputListener listener = new InputListener();
        
        //for the sudoku size go through the cells array and set them as a JTextField
        for (int i = 0; i < SUDOKU_SIZE; ++i) {
            for (int j = 0; j < SUDOKU_SIZE; ++j) {
                cells[i][j] = new JTextField(); 
                cp.add(cells[i][j]);
                //if the position contains zero on the gameboard do not display text
                //also allow the cell to be used by the user
                if (gb.numbers[i][j]==0) {
                    cells[i][j].setText("");     
                    cells[i][j].setEditable(true);
                    cells[i][j].setBackground(OPEN_BGCOLOR);
 
                    cells[i][j].addActionListener(listener);
                }
                //otherwise just display the number from the board
                else {
                    cells[i][j].setText(gb.numbers[i][j] + "");
                    cells[i][j].setEditable(false);
                    cells[i][j].setBackground(CC_BGCOLOR);
                    cells[i][j].setForeground(CC_TEXT);
                }
                //set allignment to center and the font to the desired style
                cells[i][j].setHorizontalAlignment(JTextField.CENTER);
                cells[i][j].setFont(NUMBER_FONT);
            }
        }
 
        //set the dimensions and pack the frame
        cp.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        pack();
 
        
        setTitle("ONTechU Sudoku");
        setVisible(true);
    }
    
  
    //create input listener class for sudoku
    private class InputListener implements ActionListener {
        //override the parent methods
        @Override
        public void actionPerformed(ActionEvent e) {
         
            int row = -1;
            int col = -1;
 
            JTextField source = (JTextField)e.getSource();
            //if the number is found set the row and column to the position
            boolean found = false;
            for (int i = 0; i < SUDOKU_SIZE && !found; ++i) {
                for (int j = 0; j < SUDOKU_SIZE && !found; ++j) {
                    if (cells[i][j] == source) {
                        row = i;
                        col = j;
                        found = true;  
                    }
                }
            }
 
            //get the number
            String input = cells[row][col].getText();
            int number = Integer.parseInt(input);
            //set the number back to zero
            gb.numbers[row][col]=0;
            //if the move is legal set the number in the game board otherwise put it back to zero
            if(number>0 && number<=9){
                if (gb.isOk(row,col, number)){
                    gb.numbers[row][col]=number;
                    cells[row][col].setBackground(Color.YELLOW);
                }
                //otherwise alert the user that the move is illegal
                else {
                    cells[row][col].setBackground(Color.RED);
                    JOptionPane.showMessageDialog(null, "You cannot input "+number+" at this position!","Warning",0);
                }
            }
            else{
                cells[row][col].setBackground(Color.RED);
            }
            //set complete to true
            boolean complete = true;
            //go through the whole array and check if the numbers on the board match what is on the final board
            for (int i = 0; i < SUDOKU_SIZE && complete; ++i) {
                for (int j = 0; j < SUDOKU_SIZE && complete; ++j) {
                    if (fgb.numbers[i][j]!=gb.numbers[i][j]) {
                        complete = false;
                    }
                }
            }
            //if it is complete alert the user
            if (complete){
                JOptionPane.showMessageDialog(null, "Congrats, you won!","Victory",1);
            }
        }
    }
}