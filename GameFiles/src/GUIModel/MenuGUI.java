package GUIModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuGUI extends GUIController implements ActionListener {
    private JFrame menuFrame;
    private JPanel menuPanel;
    private JButton newGameButton, loadGameButton;
    private JPanel newGamePanel, loadGamePanel;
    int screenWidth,screenHeight;

    /**
     * Constructor
     */
    MenuGUI() {menuGUIComponents();}

    /**
     * Method that creates menu GUI along with menuGUI.form
     */
    private void menuGUIComponents() {
        screenWidth = 1280;
        screenHeight = 800;

        // Menu Frame
        menuFrame = new JFrame();
        menuFrame.setSize(screenWidth, screenHeight);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);
        menuFrame.setLayout(null);
        menuFrame.setBackground(Color.black);
        menuFrame.setResizable(false);
        menuFrame.add(menuPanel);

        // Menu Main Panel
        menuPanel.setBounds(0,0,screenWidth,screenHeight);
        menuPanel.setBackground(Color.black);

        // New Game Panel
        newGamePanel.setBounds(0,screenHeight/2,120,60);

        // Load Game Panel
        loadGamePanel.setBounds(screenWidth/2,screenHeight/2,120,160);

        // New Game Button
        newGameButton.addActionListener(this);
        newGameButton.setFocusPainted(false);

        // Load Game Button
        loadGameButton.addActionListener(this);
        loadGameButton.setFocusPainted(false);
    }

    /**
     * Action performed if a button is clicked
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newGameButton) {
            System.out.println("New game");
            menuFrame.dispose();
            try {
                PlayGUI playGUI = new PlayGUI();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
        if(e.getSource() == loadGameButton) {
            System.out.println("Load game");
            menuFrame.dispose();
            try {
                PlayGUI playGUI = new PlayGUI();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
