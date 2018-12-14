import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Game extends Canvas{
    private static final long serialVersionUID = 1L;
    public static JFrame window;
    public static Container c;
    JPanel titlePanel,startButtonPanel, quitButtonPanel;
    JLabel titleLabel;
    JButton startButton, quitButton;
    Font titleFont = new Font("Cooper Black", Font.PLAIN,90);
    private static int width = 800;
    private static int height = 600;
    public static String title ="JRPG";

    /*----------------------------------------------------------------------------------------------------*/
    public static void main(String[] args){
        Game game = new Game();
        Game.window.setResizable(false);
        Game.window.setTitle(Game.title);
        Game.window.add(game);
        Game.window.pack();
        Game.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game.window.setLocationRelativeTo(null);
        Game.window.setVisible(true);
    }
    /*----------------------------------------------------------------------------------------------------*/
    public Game(){

        window = new JFrame();
        setPreferredSize(new Dimension(width, height));
        window.getContentPane().setBackground(Color.BLACK);
        c = window.getContentPane();

        //////////TITLE PANEL//////////////////////
        titlePanel = new JPanel();
        titlePanel.setBounds(100, 100, 600, 150);
        titlePanel.setBackground(Color.BLACK);
        titleLabel = new JLabel("TEXT RPG");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(titleFont);

        //////////START BUTTON PANEL//////////////////////
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 100, 100);
        startButtonPanel.setForeground(Color.RED);
        startButtonPanel.setBackground(Color.BLACK);

        //////////START BUTTON//////////////////////
        startButton = new JButton("START");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);

        //////////QUIT BUTTON PANEL/////////////////
        quitButtonPanel = new JPanel();
        quitButtonPanel.setBounds(350, 400, 200, 200);
        quitButtonPanel.setForeground(Color.pink);
        quitButtonPanel.setBackground(Color.BLACK);

        //////////QUIT BUTTON///////////////
        quitButton = new JButton("QUIT");
        quitButton.setBackground(Color.BLACK);
        quitButton.setForeground(Color.WHITE);


        //////////ADD ELEMENTS TO WINDOW//////////////////////
        titlePanel.add(titleLabel);
        startButtonPanel.add(startButton);
        quitButtonPanel.add(quitButton);

        //////////ADD ELEMENTS TO CONTAINER//////////////////////
        c.add(titlePanel);
        c.add(startButtonPanel);
        c.add(quitButtonPanel);

    }
    /*----------------------------------------------------------------------------------------------------*/
}