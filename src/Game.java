import javax.swing.*;
import java.awt.*;

public class Game {

    JFrame window;
    Container c;
    JPanel titlePanel;
    JPanel startButtonPanel;
    JLabel titleLabel;
    JButton startButton;
    Font titleFont = new Font("Cooper Black", Font.PLAIN, 90);
    Font buttonFont = new Font("Cooper Black", Font.PLAIN, 32);

    public static void main(String[] args) {
        new Game();
    }

    public Game() {

        //Main Window
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        c = window.getContentPane();

        //Title Panel
        titlePanel = new JPanel();
        titlePanel.setBounds(100, 100, 600, 150);
        titlePanel.setBackground(Color.GRAY);

        titleLabel = new JLabel("TEXT RPG");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(titleFont);

        //Start Button Panel
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100 );
        startButtonPanel.setBackground(Color.BLUE);

        //Start Button
        startButton = new JButton("START");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(buttonFont);


        //Add Elements to Window
        titlePanel.add(titleLabel);
        startButtonPanel.add(startButton);

        //Add Elements to Container
        c.add(titlePanel);
        c.add(startButtonPanel);

    }
}
