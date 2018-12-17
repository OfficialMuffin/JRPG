import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Game extends Canvas{
    private static final long serialVersionUID = 1L;
    public static JFrame window;
    public static Container c;
    JPanel titlePanel,startButtonPanel, quitButtonPanel, mainTextPanel, choiceButtonPanel,
            playerInfoPanel;
    JLabel titleLabel, playerMoodLabel, playerMood;
    JButton startButton, quitButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    String mood, position;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    quitGameHandler qHandler = new quitGameHandler();
    choiceHandler cHandler = new choiceHandler();
    Font titleFont = new Font("Cooper Black", Font.PLAIN,90);
    Font gameFont = new Font("Times New Roman", Font.PLAIN, 18);
    private static int width = 800;
    private static int height = 600;
    public static String title ="OfficialMuffin's RPG";

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
        startButton.setFocusPainted(false);

        startButton.addActionListener(tsHandler); // Add listener to start button

        //////////QUIT BUTTON PANEL/////////////////
        quitButtonPanel = new JPanel();
        quitButtonPanel.setBounds(350, 400, 200, 200);
        quitButtonPanel.setForeground(Color.pink);
        quitButtonPanel.setBackground(Color.BLACK);

        //////////QUIT BUTTON///////////////
        quitButton = new JButton("QUIT");
        quitButton.setBackground(Color.BLACK);
        quitButton.setForeground(Color.WHITE);
        quitButton.addActionListener(qHandler);
        quitButton.setFocusPainted(false);


        //////////ADD ELEMENTS TO WINDOW//////////////////////
        titlePanel.add(titleLabel);
        startButtonPanel.add(startButton);
        quitButtonPanel.add(quitButton);

        //////////ADD ELEMENTS TO CONTAINER//////////////////////
        c.add(titlePanel);
        c.add(startButtonPanel);
        c.add(quitButtonPanel);

        /////////MAIN GAME SCREEN//////////////
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.BLACK);
        c.add(mainTextPanel);

        mainTextArea = new JTextArea("Welcome to OfficialMuffin's RPG!\n" +
                "What would you like to do?");

        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(gameFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextPanel.add(mainTextArea);
        mainTextPanel.setVisible(false);


        /////////////CHOICE BUTTONS///////////////////
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(100, 350, 600, 150);
        choiceButtonPanel.setBackground(Color.BLACK);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        choiceButtonPanel.setVisible(false);
        c.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.BLACK);
        choice1.setForeground(Color.WHITE);
        choice1.setFont(gameFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.BLACK);
        choice2.setForeground(Color.WHITE);
        choice2.setFont(gameFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.BLACK);
        choice3.setForeground(Color.WHITE);
        choice3.setFont(gameFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.BLACK);
        choice4.setForeground(Color.WHITE);
        choice4.setFont(gameFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        /////////PLAYER INFO PANEL//////////
        playerInfoPanel = new JPanel();
        playerInfoPanel.setBounds(100, 15, 600, 50);
        playerInfoPanel.setBackground(Color.BLACK);
        playerInfoPanel.setVisible(false);
        c.add(playerInfoPanel);

        playerMoodLabel = new JLabel("Mood: ");
        playerMoodLabel.setFont(gameFont);
        playerMoodLabel.setForeground(Color.WHITE);
        playerInfoPanel.add(playerMoodLabel);

        playerMood = new JLabel();
        playerMood.setFont(gameFont);
        playerMood.setForeground(Color.WHITE);
        playerMood.setVisible(false);
        playerInfoPanel.add(playerMood);

        playerSetup();

    }

    //////////PLAYER INFO///////////////////
    public void playerSetup() {

        mood = "Happy";
        playerMood.setText(mood);

        intro();

    }

    /////////DISABLE THE MAIN SCREEN PANELS//////////////////
    public void createGameScreen() {

        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        quitButtonPanel.setVisible(false);

        mainTextPanel.setVisible(true);
        choiceButtonPanel.setVisible(true);
        playerInfoPanel.setVisible(true);
        playerMoodLabel.setVisible(true);
        playerMood.setVisible(true);

    }

    //////////GAME PLACES/////////////
    public void intro() {

        position = "intro";
        mainTextArea.setText("*You wake up, get dressed and ask yourself* What to do today?");

        choice1.setText("Look at your Bedroom");
        choice2.setText("Go to the Kitchen");
        choice3.setText("View the Garden");
        choice4.setText("Talk to your sister in her room");

    }

    public void bedroom() {

        position = "bedroom";
        mainTextArea.setText("*You say to yourself* Ughh, my bedroom is a mess. I really need to clean up...");
        playerMood.setText("Uncomfortable");

        choice1.setText("Look at your Bedroom");
        choice2.setText("Go to the Kitchen");
        choice3.setText("View the Garden");
        choice4.setText("Talk to your sister in her room");


    }

    public void kitchen() {

        position = "kitchen";
        mainTextArea.setText("*You say to yourself* Im feeling quite hungry. What's for snack? *Looks in the fridge*\n" +
                                "I'll take this!");
        playerMood.setText("Hungry");

        choice1.setText("Look at your Bedroom");
        choice2.setText("Go to the Kitchen");
        choice3.setText("View the Garden");
        choice4.setText("Talk to your sister in her room");

    }

    public void garden() {

        position = "garden";
        mainTextArea.setText("*takes a deep breath* Ahhh, what a beautiful day!\n" +
                                "*Birds chirp nearby*");
        playerMood.setText("Calm");

        choice1.setText("Look at your Bedroom");
        choice2.setText("Go to the Kitchen");
        choice3.setText("View the Garden");
        choice4.setText("Talk to your sister in her room");

    }

    public void sistersBedroom() {

        position = "sistersBedroom";
        mainTextArea.setText("*Sister shouts at you* GET OUT! NO BOYS ALLOWED!\n\n" +
                "*You say to yourself* Ok, Ok, Jeeze! No need to be a bitch about it.\n\n" +
                "*You walk away from her room, sighing*\n\n" +
                "*You think to yourself* I wish I could get along with her better\n\n" +
                "*Your mother walks by and says* Why haven't you cleaned your room yet?\n\n");
        playerMood.setText("Upset");

        choice1.setText("Look at your Bedroom");
        choice2.setText("Go to the Kitchen");
        choice3.setText("View the Garden");
        choice4.setText("Talk to your sister in her room");

    }

    //////////SHOW A CONFIRM TO QUIT DIALOG////////////////////
    public void quitGame() {

        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {

            Game.window.setVisible(false);
            System.exit(0);

        }
    }

    //////////HANDLES USER MOUSE INPUT TO PERFORM ACTION/////////////
    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            createGameScreen();

        }
    }
    ///////QUIT GAME WHEN BUTTON IS PRESSED///////////
    public class quitGameHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            quitGame();

        }
    }
    /////////CHOICE BUTTON HANDLER/////////////
    public class choiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String playerChoice = event.getActionCommand();

            switch (position) {

                case "intro":

                    switch(playerChoice) {

                        case "c1":
                            bedroom();
                            break;
                        case "c2":
                            kitchen();
                            break;
                        case "c3":
                            garden();
                            break;
                        case "c4":
                            sistersBedroom();
                            break;
                    }
                    break;

                case "bedroom":

                    switch (playerChoice) {

                        case "c1":
                            bedroom();
                            break;
                        case "c2":
                            kitchen();
                            break;
                        case "c3":
                            garden();
                            break;
                        case "c4":
                            sistersBedroom();
                            break;
                    }
                    break;

                case "kitchen":

                    switch (playerChoice) {

                        case "c1":
                            bedroom();
                            break;
                        case "c2":
                            kitchen();
                            break;
                        case "c3":
                            garden();
                            break;
                        case "c4":
                            sistersBedroom();
                            break;
                    }
                    break;

                case "garden":

                    switch (playerChoice) {

                        case "c1":
                            bedroom();
                            break;
                        case "c2":
                            kitchen();
                            break;
                        case "c3":
                            garden();
                            break;
                        case "c4":
                            sistersBedroom();
                            break;
                    }
                    break;

                case "sistersBedroom":

                    switch (playerChoice) {

                        case "c1":
                            bedroom();
                            break;
                        case "c2":
                            kitchen();
                            break;
                        case "c3":
                            garden();
                            break;
                        case "c4":
                            sistersBedroom();
                            break;
                    }
                    break;
                }
            }

        }
    }
    /*----------------------------------------------------------------------------------------------------*/