package GUIModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates the GUI
 */
public class TitleGUI extends GUIController implements ActionListener{

    private JFrame titleGUIFrame;
    private JPanel titleNamePanel;
    private JButton startButton;
    int screenWidth, screenHeight;

    /**
     * Constructor that calls GUI Methods
     */
    TitleGUI() {
        TitleGUIComponents();
    }

    public void TitleGUIComponents() {
        screenWidth = 1280;
        screenHeight = 800;

        Font titleFont = new Font("Comic Sans",Font.PLAIN,90); // Title Font
        Font normalFont = new Font("Comic Sans", Font.PLAIN, 20); // normal Font

        // Window
        titleGUIFrame = new JFrame(); // Creates new JFrame "window"
        titleGUIFrame.setSize(screenWidth, screenHeight); // "window" width and height
        titleGUIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // "window" close operation on exit
        titleGUIFrame.setLocationRelativeTo(null); // "window" spawns in middle of screen
        titleGUIFrame.setVisible(true); // "window" visibility
        titleGUIFrame.setLayout(null); // "window" layout
        titleGUIFrame.getContentPane().setBackground(Color.black); // "window" background color
        titleGUIFrame.setResizable(false); // "window" resizability

        // Title Name Panel
        titleNamePanel = new JPanel(); // Creates JPanel "titleNamePanel"
        int newTitleX = (int)Math.round(screenWidth *0.125); // X location for "titleNamePanel"
        int newTitleY = (int)Math.round(screenHeight *0.166); // Y location for "titleNamePanel"
        int newTitleWidth =(int)Math.round(screenWidth *0.75); // Width for "titleNamePanel"
        int newTitleHeight = (int)Math.round(screenHeight *0.25); // Height for "titleNamePanel"
        titleNamePanel.setBounds(newTitleX,newTitleY,newTitleWidth,newTitleHeight); // "titleNamePanel" bounds
        titleNamePanel.setBackground(Color.black); // "titleNamePanel" background color

        // Title Name Label
        JLabel titleNameLabel = new JLabel("Dungeon Adventure"); // Creates a new JLabel "Dungeon Adventure"
        titleNameLabel.setForeground(Color.white); // "Dungeon Adventure" Foreground color
        titleNameLabel.setFont(titleFont); // "Dungeon Adventure" font
        titleNamePanel.add(titleNameLabel); // adds "Dungeon Adventure" JLabel to JPanel

        // Start Button Panel
        JPanel startButtonPanel = new JPanel(); // Creates a new JPanel "startButtonPanel"
        int newButtonX = (int)Math.round(screenWidth *0.360); // X location for "startButtonPanel"
        int newButtonY = (int)Math.round(screenHeight *0.667); // Y location for "startButtonPanel"
        int newButtonWidth =(int)Math.round(screenWidth *0.25); // Width for "startButtonPanel"
        int newButtonHeight = (int)Math.round(screenHeight *0.125); // Height for "startButtonPanel"
        startButtonPanel.setBounds(newButtonX,newButtonY,newButtonWidth,newButtonHeight); // "startButtonPanel" bounds
        startButtonPanel.setBackground(Color.black); // "startButtonPanel" background color

        // Start Button
        startButton = new JButton("START"); // Name button "Start"
        startButton.setBackground(Color.gray); // "Start" background color
        startButton.setForeground(Color.black); // "Start" Foreground color
        startButton.setFont(normalFont); // "Start" font
        startButton.setFocusPainted(false); // Removes interior box from "Start"
        startButton.addActionListener(this); // Button action
        startButtonPanel.add(startButton); // add "Start" to ButtonPanel

        // Actions
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {}
        });

        titleGUIFrame.add(titleNamePanel); // Add titleNamePanel to JFrame "window"
        titleGUIFrame.add(startButtonPanel); // Add startButtonPanel to JFrame "window"

        titleGUIFrame.setVisible(true); // "window" JFrame is visible
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Lets Begin!");
        titleGUIFrame.dispose();
        if (e.getSource() == startButton) {
            MenuGUI GUIMenu = new MenuGUI();
        }
    }
}
