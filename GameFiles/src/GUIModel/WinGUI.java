package GUIModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WinGUI extends GUIController implements ActionListener {

    private JFrame winFrame;
    private JPanel winPanel;
    private JLabel winLabel;
    private JPanel buttonPanel;
    private JButton newGameButton;
    private JButton loadGameButton;
    int screenWidth,screenHeight;

    WinGUI() {winGUIComponents();}

    private void winGUIComponents() {
        screenWidth = 1280;
        screenHeight = 800;

        // Lose Frame
        winFrame = new JFrame();
        winFrame.setSize(screenWidth,screenHeight);
        winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winFrame.setLocationRelativeTo(null);
        winFrame.setVisible(true);
        winFrame.setBackground(Color.black);
        winFrame.setResizable(false);
        winFrame.add(winPanel);

        // Lose Panel
        winPanel.setBounds(0,0,screenWidth,screenHeight);
        winPanel.setBackground(Color.black);

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
            winFrame.dispose();
        } try {
            // TODO: Fix
            PlayGUI playGUI = new PlayGUI();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        if(e.getSource() == loadGameButton) {
            System.out.println("Load game");
            winFrame.dispose();
        } try {
            // TODO: Fix
            PlayGUI playGUI = new PlayGUI();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
