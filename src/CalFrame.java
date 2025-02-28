import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CalFrame extends JFrame {
    private JTextArea screen;
    private InputProcessor iProcessor = new InputProcessor();
    private Calculator calculator = new Calculator();
    private Log log = Log.getInstance();
    private OutputProcessor oProcessor = new OutputProcessor();
    private List<Token> tokens = new ArrayList<Token>();
    private double result;

    private final String defaultText = "Enter '@help' for extra commands";

    public CalFrame(){
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        screen = new JTextArea(defaultText);
        screen.setEditable(true);
        screen.setFont(new Font("Arial", Font.BOLD, 24));
        screen.setLineWrap(true);
        screen.setWrapStyleWord(true);
        screen.setForeground(Color.GRAY);

        JScrollPane scrollPane = new JScrollPane(screen);
        scrollPane.setPreferredSize(new Dimension(450, 400));
        add(scrollPane, BorderLayout.NORTH);

        screen.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e){
                if(screen.getText().equals(defaultText)){
                    screen.setText("");
                    screen.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(screen.getText().isEmpty()){
                    screen.setText(defaultText);
                    screen.setForeground(Color.GRAY);
                }
            }
        });

        screen.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    processCalculation();
                }
            }
        });




        JPanel buttonPanel = new JPanel();;
        buttonPanel.setLayout(new GridLayout(4,6,5,5));

        String[] buttons ={
                "7","8","9","/","(","@",
                "4","5","6","*",")","log",
                "1","2","3","-","!","sin",
                "0","C","=","+","^","cos"
        };

        for(String text : buttons){
            JButton button = new JButton(text);
            button.setFont(new Font("Arial",Font.BOLD, 20));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);


        setSize(600, 800);
        setVisible(true);
    }


    private void processCalculation() {
        String currentText = screen.getText();

        if (!currentText.isEmpty() && !currentText.equals(defaultText)) {
            tokens = iProcessor.init(currentText);
            result = calculator.init(tokens);
            oProcessor.init(result, tokens);
            screen.setText(log.getCurrentLog());
            tokens.clear();
        }
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String buttonText = e.getActionCommand();
            String currentText = screen.getText();


            if (buttonText.matches("[0-9]")) {
                playNumberSound(buttonText);
            }

            if(buttonText.equals("C")){
                screen.setText(defaultText);
                screen.setForeground(Color.GRAY);
            }else if(buttonText.equals("=")){
                processCalculation();
            }else {
                if (currentText.equals(defaultText)) {
                    screen.setForeground(Color.BLACK);
                    screen.setText(buttonText);
                }else if(currentText.contains("=")){
                    screen.setText(result+buttonText);
                }else{
                    screen.setText(currentText + buttonText);

                }
            }
        }
    }

    private void playNumberSound(String number) {
        try {
            String soundFileName = "src/sound/sound_" + number + ".wav";
            File soundFile = new File(soundFileName);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }


}
