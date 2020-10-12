import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {


    public static void main(String[] args) {
        // create frame of the window
        JFrame frame = new JFrame("My basic calculator");
        // create a panel to contain the text/ screen field
        JPanel textpanel = new JPanel(new BorderLayout());
        // position the textpanel in the frame (no layout)
        textpanel.setBounds(0, 0, 420, 100);
        // set the background of the textpael
        textpanel.setBackground(Color.lightGray);

        // create the text field/ screen with some text in it
        JTextField screen = new JTextField("Calculations here", 40);
        // add it to the textpanel
        textpanel.add(screen, BorderLayout.CENTER);

        // create a panel to hold buttons in a grid layout
        JPanel buttonpanel = new JPanel(new GridLayout(5, 4, 2, 2));
        // position the panel on the frame
        buttonpanel.setBounds(1, 100, 419, 361);
        // choose background for the panel
        buttonpanel.setBackground(Color.lightGray);

        // String array containing all the symbols of the calculator keys
        String[] keys = {
                "%", "+/-", "CE", "<=",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                ".", "0", "=", "+"
        };
        // create an array of buttons to which the keys are gonna be added
        JButton[] buttons = new JButton[keys.length];
        // add each String representing the key to a button and add the button the buttons array
        for (int i = 0; i < keys.length; i++) {
            JButton b = new JButton(keys[i]);
            buttons[i] = b;
        }

        // add each of the buttons to the buttonpanel in a grid layout
        for (JButton b : buttons) {
            buttonpanel.add(b);


            // add everything to the frame and set its characteristics
            frame.getContentPane().add(textpanel);
            frame.getContentPane().add(buttonpanel);
            frame.setSize(426, 500);
            frame.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }

        @Override
        public void actionPerformed (ActionEvent actionEvent){

        }
}
