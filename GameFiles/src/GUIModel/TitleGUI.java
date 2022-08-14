package GUIModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates the title GUI
 */
public class TitleGUI extends GUIController implements ActionListener{

    private JFrame titleFrame;
    private JPanel titleNamePanel;
    private JButton startButton;
    private JPanel buttonPanel;
    private JLabel titleLabel;
    int screenWidth, screenHeight;

    /**
     * Constructor
     */
    TitleGUI() {
        titleGUIComponents();
    }

    /**
     * Creates title GUI along with titleGUI.form
     */
    private void titleGUIComponents() {
        screenWidth = 1280;
        screenHeight = 800;

        // Window
        titleFrame = new JFrame();
        titleFrame.setSize(screenWidth, screenHeight);
        titleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        titleFrame.setLocationRelativeTo(null);
        titleFrame.setVisible(true);
        titleFrame.setLayout(null);
        titleFrame.setBackground(Color.black);
        titleFrame.setResizable(false);
        titleFrame.add(titleNamePanel);

        // Title Name Panel
        titleNamePanel.setBounds(0,0,1280,800);
        titleNamePanel.setBackground(Color.black);

        // Start Button
        startButton.addActionListener(this);
    }

    /**
     * Action if button clicked
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Lets Begin!");
        titleFrame.dispose();
        if (e.getSource() == startButton) {
            MenuGUI GUIMenu = new MenuGUI();
        }
    }
}
