import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CalculatorGUI extends JFrame implements ActionListener {

    // create a frame of the window
    static JFrame frame;
    //create the two text fields for the screen
    static JTextField screen0;
    static JTextField screen;

    //numbers and operands
    double n, firstNo, secondNo, result;
    String op;

    // constructor
    CalculatorGUI(){
    }

    public static void main(String[] args) {
        //create an instance of the class
        CalculatorGUI calc = new CalculatorGUI();
        // create frame of the window
        frame = new JFrame("My basic calculator");
        //TODO change the layout of the whole frame to GridBagLayout to enable resizing

        //TODO could use the look and feel of the system
        /*try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

         */

        // create a panel to contain the text/ screen field
        JPanel textpanel = new JPanel(new GridLayout(2,1,0,0));
        // position the textpanel in the frame (no layout)
        textpanel.setBounds(0, 0, 420, 100);
        // set the background of the textpanel
        textpanel.setBackground(Color.lightGray);

        //TODO organize the fonts in the screens and if it still looks awful: change the layout to GridBag as well

        // create a text field/ screen for showing how the calculation currently looks like (operands and operator till "=")
        screen0 = new JTextField("Calculation will be shown here", 40);
        screen0.setEditable(false);
        // create the text field/ screen for showing numbers currently chosen by user and the result of the calculation
        // at the end, now just put some text in it
        screen = new JTextField("Your chosen numbers are shown here", 40);
        screen.setEditable(false);

        // add both screens to the textpanel
        textpanel.add(screen0);
        textpanel.add(screen);

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

        for (JButton b: buttons){
            b.addActionListener(calc);
        }
    }

    public double getResult(String op){
        switch(op){
            case "+": result = firstNo + secondNo;  break;
            case "-": result = firstNo - secondNo;  break;
            case "*": result = firstNo * secondNo; break;
            case "/": result = firstNo / secondNo; break;
            case "%": result = (firstNo/100) * secondNo; break;
        }
        return result;
    }

        @Override
        public void actionPerformed (ActionEvent e){
            // String containing the action command to be used for screen
            String com = e.getActionCommand();

            // array with all the operators comes in handy later when checking the screen contents
            String[] ops = {"+", "-", "/", "%", "*"};

            //TODO after pressing any first button, delete everything on both screens and replace it with the value
            // or change the lower screen to start with a zero and change just that

            // set the text on the screen depending on the user's action
            switch (com) {
                case "CE":
                    screen0.setText("");
                    screen.setText(""); // delete everything on both screens when CE pressed
                    break;
                case "<=":
                    int l = screen.getText().length();
                    if (l == 0){  // if nothing on screen - break to avoid out of bounds exception
                        break;
                    }
                    String delLastChar = screen.getText().substring(0,(l-1));
                    screen.setText(delLastChar); // delete last character of the string on the lower screen
                    break;
                case "+": case "-": case"/": case "%": case "*":
                    // take the first operand from what's currently on the lower screen
                    firstNo = Double.parseDouble(screen.getText());
                    // set the operator to currently chosen one
                    op = com;
                    // continue showing everything on the upper screen
                    screen0.setText(screen0.getText() + com);
                    // update the lower screen to show the button pressed
                    screen.setText(com);
                    break;
                case "=":
                    screen0.setText(screen0.getText() + com);
                    // take the second operand for the calcualtion from the lower screen
                    secondNo = Double.parseDouble(screen.getText());
                    double output = getResult(op);
                    screen.setText(""+output);
                    break;
                default:
                    screen0.setText(screen0.getText() + com); // show everything on the upper screen

                    // if the previous character was an operator show only the currently chosen value on the lower screen
                    if (Arrays.asList(ops).contains(screen.getText())){ screen.setText(com);}
                    // if the previous character was an operand, continue typing values as usual
                        else { screen.setText(screen.getText() + com);}
                    //TODO: make the lower screen replace the current number shown with new one after the op was clicked
                    break;
            }


        }
}
