import java.awt.Dimension;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Box;

public class Main {

    public Main() {}

    public static void main (String[] args) throws InterruptedException {
        MemoryGame game = new MemoryGame();
        GameActions actions = new GameActions();

        JFrame frame = new JFrame ("Memory Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize (new Dimension (500, 600));
        mainPanel.setLayout (new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.BLACK);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout (new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
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

        JPanel newButtonPanel = new JPanel();
        newButtonPanel.setLayout (new FlowLayout(FlowLayout.CENTER));
        newButtonPanel.setPreferredSize(new Dimension(newButtonPanel.getPreferredSize().width, -90));
        newButtonPanel.setBackground(Color.BLACK);

        JButton newGameButton = new JButton("New Game");
        newGameButton.setPreferredSize(new Dimension(100, 50));
        newGameButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        newGameButton.setForeground(Color.BLACK);

        newButtonPanel.add(newGameButton);
        mainPanel.add(newButtonPanel);

        JPanel turnsPanel = new JPanel();
        turnsPanel.setLayout (new FlowLayout(FlowLayout.CENTER));
        turnsPanel.setPreferredSize(new Dimension(turnsPanel.getPreferredSize().width, -110));
        turnsPanel.setBackground(Color.BLACK);

        JLabel turnsLabel = new JLabel("Turns: " + String.valueOf(game.getTurns()) + "/15");
        turnsLabel.setForeground(Color.decode("#fc9200"));
        turnsLabel.setFont(new Font("Arial", Font.PLAIN, 30));

        turnsPanel.add(turnsLabel);
        mainPanel.add(turnsPanel);

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout (new GridLayout(3, 4, 2, 2));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        gridPanel.setPreferredSize(new Dimension(gridPanel.getPreferredSize().width, 280));
        gridPanel.setBackground(Color.BLACK);

        for (int i = 0; i < 12; i++) {
            JLabel label = new JLabel(game.getCustomIcon(i).getDefaultIconImage());
            label.putClientProperty("customIcon", game.getCustomIcon(i));
            gridPanel.add(label);
            actions.addMouseListener(label, game, turnsLabel);
        }

        actions.addActionListener(newGameButton, gridPanel, game, turnsLabel);

        mainPanel.add(gridPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        frame.add(mainPanel);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }
}