

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.*;
import java.awt.Font;
import java.awt.Color;

public class Menu extends JFrame
{
    /*Initialize the main prop*/
    int newSizeX = 500;
    int newSizeY = 500;
    
    Color RB = new Color(65,105,225);
    Dimension d = new Dimension(500, 500);
    Font titleFont = new Font("Impact", Font.BOLD, 200);
    Font btnFont = new Font("Ariel", Font.BOLD, 60);
    JLabel title = new JLabel("OnTechU Sudoku");
    JFrame mainFrame = new JFrame("OnTechU Sudoku");
    JPanel mainPanel = new JPanel();
    JButton play = new JButton("Play");
    JButton option = new JButton("Options");
    JButton quit = new JButton("Quit");
    
    

    public Menu()
    {
        mainPanel.setBackground(new Color(65,105,225));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);//Align the buttons to centre
        play.setAlignmentX(Component.CENTER_ALIGNMENT);//Align the buttons to centre
        option.setAlignmentX(Component.CENTER_ALIGNMENT);//Align the buttons to centre
        quit.setAlignmentX(Component.CENTER_ALIGNMENT);//Align the buttons to centre
        play.setFont(btnFont);//Set the font of the button contents
        option.setFont(btnFont);//Set the font of the button contents
        quit.setFont(btnFont);//Set the font of the button contents
        
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));//Constructs panel
        mainPanel.add(title);//adds title to panel
        mainPanel.add(Box.createRigidArea(new Dimension(0,100)));//spacing between buttons
        mainPanel.add(play);//adds play button to panel
        mainPanel.add(Box.createRigidArea(new Dimension(0,100)));//spacing between buttons
        mainPanel.add(option);//adds option button to panel
        mainPanel.add(Box.createRigidArea(new Dimension(0,100)));//spacing between buttons
        mainPanel.add(quit);//adds quit button to panel
        mainFrame.add(mainPanel);//creates the main panel
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//creates close button
        mainFrame.setLocationRelativeTo(null);//minimize button
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);//creates maximize button
        mainFrame.getContentPane().setBackground(Color.red);//set background colour
        mainFrame.pack();//packs the mainFrame
        mainFrame.setVisible(true);//makes the mainFrame visible
        title.setFont(titleFont);//sets title font
        
        play.addActionListener((ActionEvent e)->{//changes to gameboard when the play button is clicked
            FinalGameBoard fgb = new FinalGameBoard();
            GameBoard gb = fgb.generateBoard();
            Sudoku sudoku = new Sudoku(gb,fgb,mainPanel.getBackground());
        });
        option.addActionListener((ActionEvent e) ->{ //changes to options panel when the options button is pressed
            Option options = new Option();
            mainFrame.dispose();//closes the main menu windo
            
            
            
        });
        quit.addActionListener((ActionEvent e) -> {//closes the application when pressed
            System.exit(0);
        });
        
    }
    public Menu(Color customColor)
    {
        /*Same descriptions as before, just redone to save the themes selected*/
        mainPanel.setBackground(customColor);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        play.setAlignmentX(Component.CENTER_ALIGNMENT);
        option.setAlignmentX(Component.CENTER_ALIGNMENT);
        quit.setAlignmentX(Component.CENTER_ALIGNMENT);
        play.setFont(btnFont);
        option.setFont(btnFont);
        quit.setFont(btnFont);
        
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0,100)));
        mainPanel.add(play);
        mainPanel.add(Box.createRigidArea(new Dimension(0,100)));
        mainPanel.add(option);
        mainPanel.add(Box.createRigidArea(new Dimension(0,100)));
        mainPanel.add(quit);
        mainFrame.add(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.getContentPane().setBackground(Color.red);
        mainFrame.pack();
        mainFrame.setVisible(true);
        title.setFont(titleFont);
        
        play.addActionListener((ActionEvent e)->{
            FinalGameBoard fgb = new FinalGameBoard();
            GameBoard gb = fgb.generateBoard();
            Sudoku sudoku = new Sudoku(gb,fgb,mainPanel.getBackground());
        });
        option.addActionListener((ActionEvent e) ->{
            Option options = new Option();
            mainFrame.dispose();
            
            
        });
        quit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
    }
    public static void main (String[] args) {
        SwingUtilities.invokeLater(Menu::new);//invokes swing utilities
    
    }
    
}