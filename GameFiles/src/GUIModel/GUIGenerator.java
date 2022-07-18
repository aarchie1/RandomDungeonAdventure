package GUIModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// take in strings
// output strings
public class GUIGenerator implements ActionListener {


    public static void main(String[] args) {
        guiSetup();
    }
    public static void guiSetup() {
        JFrame frame = new JFrame("RandomAdventureDungeonSim Ver 1.0"); // Window Title

        // Frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation on closing window
        frame.setSize(1000,700); // size

        frame.setVisible(true); // show frame is visible

        // Buttons
        JButton buttonUP = new JButton("UP");
        JButton buttonDOWN = new JButton("DOWN");
        JButton buttonLEFT = new JButton("LEFT");
        JButton buttonRIGHT = new JButton("RIGHT");

        // Button Sizes
        buttonUP.setSize(50,50);
        buttonDOWN.setSize(50,50);
        buttonLEFT.setSize(50,50);
        buttonRIGHT.setSize(50,50);

        // Button Location
        buttonUP.setBounds(100,0,100,100);
        buttonDOWN.setBounds(100,100,100,100);
        buttonLEFT.setBounds(0,100,100,100);
        buttonRIGHT.setBounds(200,100,100,100);

        // Add buttons to panel
        frame.getContentPane().add(buttonUP);
        frame.getContentPane().add(buttonDOWN);
        frame.getContentPane().add(buttonLEFT);
        frame.getContentPane().add(buttonRIGHT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
