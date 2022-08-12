package GUIModel;

import jdk.swing.interop.SwingInterOpUtils;

import javax.imageio.ImageIO;
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
    private int screenWidth, screenHeight;
    private ImageIcon tileImage;

    PlayGUI() throws IOException {
        playGUIComponents();
        mapGrid();
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
        playFrame.add(playPanel);

        // playPanel
        playPanel.setBounds(0,0,1280,800);
        playPanel.setBackground(Color.black);

        // Up button
        buttonUp.addActionListener(this);

        // Down button
        buttonDown.addActionListener(this);

        // Left button
        buttonLeft.addActionListener(this);

        // Right button
        buttonRight.addActionListener(this);
    }

    private void mapGrid() throws IOException {

        URL url = this.getClass().getResource("/Sprites/tile.png");
        ImageIcon imageIcon = new ImageIcon(url);

        JLabel tileLabel = new JLabel(imageIcon);

        mapPanel.setLayout(new GridLayout(1,1,0,0));
        mapPanel.add(tileLabel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonUp) {
            System.out.println("Going up");
            // TODO: Fix
            LoseGUI loseGUI = new LoseGUI();
        }
        if (e.getSource() == buttonDown) {
            System.out.println("Going down");
            // TODO: Fix
            WinGUI winGUI = new WinGUI();
        }
        if (e.getSource() == buttonLeft) {
            System.out.println("Going left");
        }
        if (e.getSource() == buttonRight) {
            System.out.println("Going right");
        }
    }
}
