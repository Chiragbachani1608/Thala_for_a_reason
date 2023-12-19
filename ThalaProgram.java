import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class ThalaProgram {
    public static void main(String[] args) {
        // GUI setup
        JFrame frame = new JFrame("Thala String Counter and Calculator");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // String Counter Section
        JLabel stringLabel = new JLabel("Enter a string:");
        frame.add(stringLabel);

        JTextField stringEntry = new JTextField(20);
        frame.add(stringEntry);

        JButton checkLengthButton = new JButton("Check Length");
        checkLengthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkStringLength(stringEntry.getText());
            }
        });
        frame.add(checkLengthButton);

        // Calculator Section
        JLabel calculatorLabel = new JLabel("Calculator");
        frame.add(calculatorLabel);

        JTextField num1Entry = new JTextField(5);
        frame.add(num1Entry);

        String[] operations = {"Addition", "Subtraction"};
        JComboBox<String> operationMenu = new JComboBox<>(operations);
        frame.add(operationMenu);

        JTextField num2Entry = new JTextField(5);
        frame.add(num2Entry);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performCalculation(num1Entry.getText(), (String) operationMenu.getSelectedItem(), num2Entry.getText());
            }
        });
        frame.add(calculateButton);

        // Display the frame
        frame.setVisible(true);
    }

    private static void checkStringLength(String input) {
        if (input.length() == 7) {
            displayGifImage("C:\\Users\\chira\\Downloads\\Thala\\bole jo koyal.gif");
            playSuccessSound("C:\\Users\\chira\\Downloads\\Thala\\Thala.m4a");
            JOptionPane.showMessageDialog(null, "Congratulations\nThala for a reason");
        } else {
            JOptionPane.showMessageDialog(null, "Try Again\nThe length of the string is not 7. Try again!");
        }
    }

    private static void performCalculation(String num1, String operation, String num2) {
        try {
            double result;
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);

            switch (operation) {
                case "Addition":
                    result = n1 + n2;
                    break;
                case "Subtraction":
                    result = n1 - n2;
                    break;
                default:
                    result = Double.NaN;
            }

            if (result == 7) {
                displayGifImage("C:\\Users\\chira\\Downloads\\Thala\\bole jo koyal.gif");
                playSuccessSound("C:\\Users\\chira\\Downloads\\Thala\\Thala.m4a");
                JOptionPane.showMessageDialog(null, "Congratulations\nThala for a reason");
            } else {
                JOptionPane.showMessageDialog(null, "Result\nThe result is: " + result);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error\nPlease enter valid numbers.");
        }
    }

    private static void displayGifImage(String gifPath) {
        try {
            File file = new File(gifPath);
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void playSuccessSound(String m4aPath) {
        try {
            File soundFile = new File(m4aPath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Add a listener to close the clip after playback is complete
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    event.getLine().close();
                }
            });

            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
}
