package GUIModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoseGUI extends GUIController implements ActionListener {

    private JFrame loseFrame;
    private JPanel losePanel, buttonPanel;
    private JLabel loseLabel;
    private JButton newGameButton, loadGameButton;
    private int screenWidth,screenHeight;

    LoseGUI() {loseGUIComponents();}

    private void loseGUIComponents() {
        screenWidth = 1280;
        screenHeight = 800;

        // Lose Frame
        loseFrame = new JFrame();
        loseFrame.setSize(screenWidth,screenHeight);
        loseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loseFrame.setLocationRelativeTo(null);
        loseFrame.setVisible(true);
        loseFrame.setBackground(Color.black);
        loseFrame.setResizable(false);
        loseFrame.add(losePanel);

        // Lose Panel
        losePanel.setBounds(0,0,screenWidth,screenHeight);
        losePanel.setBackground(Color.black);

        // Lose Label
       // losePanel.add(loseLabel);

        // New Game button
        newGameButton.addActionListener(this);
        newGameButton.setFocusPainted(false);

        // Load Game button
        loadGameButton.addActionListener(this);
        loadGameButton.setFocusPainted(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newGameButton) {
            System.out.println("New game");
            loseFrame.dispose();
        } try {
            // TODO: Fix
            PlayGUI playGUI = new PlayGUI();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        if(e.getSource() == loadGameButton) {
            System.out.println("Load game");
            loseFrame.dispose();
            // TODO: Fix
            WinGUI winGUI = new WinGUI();
        }
    }
}
