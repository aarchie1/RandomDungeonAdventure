package GUIModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class PlayGUI extends GUIController implements ActionListener {
    private JFrame playFrame;
    private JPanel playPanel, directionPanel, viewPanel, logPanel, mapPanel;
    private JButton buttonUp, buttonDown, buttonLeft, buttonRight;
    private JTextArea logHistory;
    private int screenWidth, screenHeight;
    private JTextArea log;
    private ImageIcon tileImage;
    private JPanel[] bgPanel;

    PlayGUI() throws IOException {
        playGUIComponents();
        placeTile();
        // historyLogUpdate();
        // placeUpWall();
    }

    private void playGUIComponents() {
        screenWidth = 1280;
        screenHeight = 800;

        // Play Frame
        playFrame = new JFrame();
        playFrame.setSize(screenWidth,screenHeight);
        playFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        playFrame.setLocationRelativeTo(null);
        playFrame.setVisible(true);
        playFrame.setLayout(null);
        playFrame.setBackground(Color.black);
        playFrame.setResizable(false);

        // mapPanel
        mapPanel.setBounds(0,0,1075,550);
        playPanel.setBackground(Color.DARK_GRAY);
        playFrame.add(mapPanel);

        // playPanel
        playPanel.setBounds(0,0,1280,800);
        playPanel.setBackground(Color.black);
        playFrame.add(playPanel);

        // logPanel
        logPanel.setBounds(1075,0,205,550);
        logPanel.setBackground(Color.lightGray);
        playFrame.add(logPanel);

        // Up button
        buttonUp.setFocusPainted(false);
        buttonUp.addActionListener(this);

        // Down button
        buttonDown.setFocusPainted(false);
        buttonDown.addActionListener(this);

        // Left button
        buttonLeft.setFocusPainted(false);
        buttonLeft.addActionListener(this);

        // Right button
        buttonRight.setFocusPainted(false);
        buttonRight.addActionListener(this);
    }

    private void placeTile() throws IOException {
        // Tile Icon
        URL tileURL = this.getClass().getResource("/resources/tile.png");
        ImageIcon tileIcon = new ImageIcon(tileURL);
        JLabel tileLabel = new JLabel(tileIcon);

        mapPanel.setLayout(new GroupLayout(mapPanel));
        mapPanel.add(tileLabel);
    }

    private void placeUpWall() throws IOException {
        // Wall Icon
        URL upWallURL = this.getClass().getResource("/resources/upWall.png");
        ImageIcon upWallIcon = new ImageIcon(upWallURL);
        JLabel upWallLabel = new JLabel(upWallIcon);

        upWallLabel.setBounds(500,200,200,100);

    }

    /**
     * Method that checks to see where to place walls
     */
    private void wallDisplay() throws IOException {

    }


    /**
     * Method that will update the history log
     */
//    private void historyLogUpdate() {
//      logHistory
//    }


    /**
     * Perform action when button clicked
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonUp) {
            System.out.println("Going up");
        }
        if (e.getSource() == buttonDown) {
            System.out.println("Going down");
        }
        if (e.getSource() == buttonLeft) {
            System.out.println("Going left");
        }
        if (e.getSource() == buttonRight) {
            System.out.println("Going right");
        }
    }
}
