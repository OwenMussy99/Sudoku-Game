/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Option extends JFrame {
    /*Initializes vars, objects, and properties used*/
    Color color;
    Color Orange = new Color(231, 93, 42);
    Font titleFont = new Font("Impact", Font.BOLD, 200);
    Font btnFont = new Font("Ariel", Font.BOLD, 60);
    JFrame optFrame = new JFrame("OnTechU Sodoku");
    JLabel title = new JLabel("Options");
    JPanel optPanel = new JPanel();
    JButton menu = new JButton("Menu");
    JButton orangeBtn = new JButton("Orange");
    JButton greenBtn = new JButton("Green");
    JButton blueBtn = new JButton("Blue");

    
    public Option(){
    /*Aligns the option menu's colour buttons*/
    orangeBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
    greenBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
    blueBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
    menu.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    /*sets the font of the colour buttons*/
    orangeBtn.setFont(btnFont);
    greenBtn.setFont(btnFont);
    blueBtn.setFont(btnFont);
    menu.setFont(btnFont);
    
    optPanel.setLayout(new BoxLayout(optPanel, BoxLayout.Y_AXIS));//create layout of the panel
    optPanel.add(title);//adds the title to the panel
    optPanel.add(Box.createRigidArea(new Dimension(0,100)));//spacing between the buttons
    optPanel.add(orangeBtn);//adds orangeBtn to the panel
    optPanel.add(Box.createRigidArea(new Dimension(0,100)));//spacing between the buttons
    optPanel.add(greenBtn);//adds greenBtn to the panel
    optPanel.add(Box.createRigidArea(new Dimension(0,100)));//spacing between the buttons
    optPanel.add(blueBtn);//adds the blueBtn to the panel
    optPanel.add(Box.createRigidArea(new Dimension(0,100)));//spacing between the buttons
    optPanel.add(menu);//adds the menu button to the panel
    optFrame.add(optPanel);//adds the optPanel to be used
    optFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//adds a create button
    optFrame.setLocationRelativeTo(null);//minimize button
    optFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);//maximize button
    optFrame.getContentPane().setBackground(Color.red);//sets the background color to red
    optFrame.pack();//packs optFram
    optFrame.setVisible(true);//makes the optFrame visible
    title.setFont(titleFont);//sets the title font
    
    orangeBtn.addActionListener((ActionEvent e)->{//changes background colour to orange when clicked
    optPanel.setBackground(Orange);

    });
    
    greenBtn.addActionListener((ActionEvent e)->{//changes background colour to green when pressed
    optPanel.setBackground(Color.GREEN);

    });
    
    blueBtn.addActionListener((ActionEvent e)->{//changes background colour to blue when pressed
    optPanel.setBackground(Color.BLUE);

    });
    
    menu.addActionListener((ActionEvent e)->{//starts new menu and closes optFrame
    Menu menu = new Menu(optPanel.getBackground());
    optFrame.dispose();
    });
     
    }

    
}
