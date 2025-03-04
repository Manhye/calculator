package front;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class GUI extends JFrame {
    private JTextArea screen;
    private GUIListener listener;
    String defaultText = "Enter '@help' for extra commands";


    public GUI(){
        setTitle("CALCULATOR");
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
            public void focusGained(FocusEvent e) {
                if (screen.getText().equals(defaultText)) {
                    screen.setText("");
                    screen.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (screen.getText().isEmpty()) {
                    screen.setText(defaultText);
                    screen.setForeground(Color.GRAY);
                }
            }
        });

        screen.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendInput();
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 6, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/", "(", "DEL",
                "4", "5", "6", "*", ")", "@",
                "1", "2", "3", "-", "!", "3.14",
                "0", "C", "=", "+", "^", "."
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setSize(600, 800);
        setVisible(true);

    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonText = e.getActionCommand();
            String currentText = screen.getText();

            if (buttonText.matches("[0-8]")) {
                playNumberSound(buttonText);
            }

            switch (buttonText) {
                case "C" -> {
                    screen.setText(defaultText);
                    screen.setForeground(Color.GRAY);
                }
                case "=" -> sendInput();
                case "DEL" -> screen.setText(screen.getText().substring(0, screen.getText().length() - 1));
                default -> {
                    if (currentText.equals(defaultText)) {
                        screen.setForeground(Color.BLACK);
                        screen.setText(buttonText);
                    } else {
                        screen.setText(currentText + buttonText);
                    }
                }
            }
        }
    }

    private void playNumberSound(String number) {
        try {
            String soundFileName = "src/front/sound/sound_" + number + ".wav";
            File soundFile = new File(soundFileName);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public void sendInput() {
        if (listener != null) {
            listener.onInputReceived(screen.getText());
        }
    }

    public void getOutput(String result) {
        screen.setText(result);
    }

    public void setGUIListener(GUIListener listener) {
        this.listener = listener;
    }

}
