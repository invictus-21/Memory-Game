import java.awt.Dimension;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import javax.swing.Box;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

    public Main() {}

    public static void main (String[] args) throws InterruptedException {
        MemoryGame game = new MemoryGame();
        GameActions actions = new GameActions();

        JFrame frame = new JFrame ("Memory Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize (new Dimension (600, 600));
        mainPanel.setLayout (new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.BLACK);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout (new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        titlePanel.setPreferredSize(new Dimension(titlePanel.getPreferredSize().width, -65));
        titlePanel.setBackground(Color.BLACK);

        JLabel titleText = new JLabel("Test Your Memory ");
        titleText.setForeground(Color.decode("#119cda"));
        titleText.setFont(new Font("Arial", Font.BOLD, 40));

        ImageIcon titleIcon = new ImageIcon("images/brain.jpg");
        titleIcon.setImage(titleIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        JLabel titleIconLabel = new JLabel(titleIcon);

        titlePanel.add(titleText);
        titlePanel.add(titleIconLabel);
        mainPanel.add(titlePanel);



        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        frame.add(mainPanel);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }
}