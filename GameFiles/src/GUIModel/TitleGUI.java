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

    TitleGUI() {
        titleGUIComponents();
    }


    private void titleGUIComponents() {
        screenWidth = 1280;
        screenHeight = 800;

        Font titleFont = new Font("Comic Sans",Font.PLAIN,90);
        Font normalFont = new Font("Comic Sans", Font.PLAIN, 20);

        // Window
        titleGUIFrame = new JFrame();
        titleGUIFrame.setSize(screenWidth, screenHeight);
        titleGUIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        titleGUIFrame.setLocationRelativeTo(null);
        titleGUIFrame.setVisible(true);
        titleGUIFrame.setLayout(null);
        titleGUIFrame.getContentPane().setBackground(Color.black);
        titleGUIFrame.setResizable(false);

        // Title Name Panel
        titleNamePanel = new JPanel();
        int newTitleX = (int)Math.round(screenWidth *0.125);
        int newTitleY = (int)Math.round(screenHeight *0.166);
        int newTitleWidth =(int)Math.round(screenWidth *0.75);
        int newTitleHeight = (int)Math.round(screenHeight *0.25);
        titleNamePanel.setBounds(newTitleX,newTitleY,newTitleWidth,newTitleHeight);
        titleNamePanel.setBackground(Color.black);

        // Title Name Label
        JLabel titleNameLabel = new JLabel("Dungeon Adventure");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        // Start Button Panel
        JPanel startButtonPanel = new JPanel();
        int newButtonX = (int)Math.round(screenWidth *0.360);
        int newButtonY = (int)Math.round(screenHeight *0.667);
        int newButtonWidth =(int)Math.round(screenWidth *0.25);
        int newButtonHeight = (int)Math.round(screenHeight *0.125);
        startButtonPanel.setBounds(newButtonX,newButtonY,newButtonWidth,newButtonHeight);
        startButtonPanel.setBackground(Color.black);

        // Start Button
        startButton = new JButton("START");
        startButton.setBackground(Color.gray);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(this);
        startButtonPanel.add(startButton);

        titleGUIFrame.add(titleNamePanel);
        titleGUIFrame.add(startButtonPanel);
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
