package GUIModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayGUI extends GUIController implements ActionListener {
    private JFrame playFrame;
    private JPanel playPanel, directionPanel, viewPanel, logPanel, mapPanel;
    private JButton buttonUp, buttonDown, buttonLeft, buttonRight;
    private int screenWidth, screenHeight;

    PlayGUI() {playGUIComponents();}

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

        // viewPanel
        viewPanel.setBounds(0,0,1280,800);
        viewPanel.setBackground(Color.gray);

        // mapPanel
        mapPanel.setBounds(0,0,1050,550);
        mapPanel.setBackground(Color.gray);
        mapPanel.setVisible(true);
        // directionPanel
        // logPanel


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
