package GUIModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI extends GUIController implements ActionListener {
    private JFrame menuFrame;
    private JPanel menuPanel;
    private JButton newGameButton, loadGameButton;
    private JPanel newGamePanel, loadGamePanel;
    int screenWidth,screenHeight;

    MenuGUI() {menuGUIComponents();}

    public void menuGUIComponents() {
        screenWidth = 1280;
        screenHeight = 800;

        // Menu Frame
        menuFrame = new JFrame(); // Creates new JFrame "menuFrame"
        menuFrame.setSize(screenWidth, screenHeight); // "menuFrame" width and height
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // "menuFrame" close operation on exit
        menuFrame.setLocationRelativeTo(null); // "menuFrame" spawns in middle of screen
        menuFrame.setVisible(true); // "menuFrame" visibility
        menuFrame.setLayout(null); // "menuFrame" layout
        menuFrame.setBackground(Color.black); // "menuFrame" background color
        menuFrame.setResizable(false); // "menuFrame" resizability
        menuFrame.add(menuPanel);

        // Menu Main Panel
        menuPanel.setBounds(0,0,1280,800); // "Random Adventure Dungeon Simulator" bounds
        menuPanel.setBackground(Color.black); // "Random Adventure Dungeon Simulator" background color

        // New Game Panel
        newGamePanel.setBounds(0,400,120,60);

        // Load Game Panel
        loadGamePanel.setBounds(640,400,120,160);

        // New Game Button
        newGameButton.addActionListener(this);
        newGameButton.setFocusPainted(false);

        // Load Game Button
        loadGameButton.addActionListener(this);
        loadGameButton.setFocusPainted(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newGameButton) {
            System.out.println("New game");
            menuFrame.dispose();
            PlayGUI playGUI = new PlayGUI();

        }
        if(e.getSource() == loadGameButton) {
            System.out.println("Load game");
            menuFrame.dispose();
            PlayGUI playGUI = new PlayGUI();
        }
    }

}
