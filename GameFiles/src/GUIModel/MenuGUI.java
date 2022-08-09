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
        menuPanel.setBounds(0,0,1280,800);
        menuPanel.setBackground(Color.black);

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
            try {
                PlayGUI playGUI = new PlayGUI();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
