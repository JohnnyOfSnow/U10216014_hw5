/**
 * Name: Johnny
 * ID: U10216014
 * Ex: hw5(write a calculator)
 * Information: 
 *      The program simulate a calculator.
 *      If user frist time use the calculator, he/she must set a password in order to use next time.
 *      If the password had setted, the program request user enter password.
 *      The calculator have addition, Subtraction, multiplication, and division.
 */
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

import javax.swing.*;

import java.util.*; 

public class calculator extends JFrame implements ActionListener{
        
    JTextField numberfield;
    
    String numberstring = " ";
    
    double number;
    
    char buttonname[]={'7','8','9','/',
                       '4','5','6','*',
                       '1','2','3','-',
                       '0','.','=','+'};
                       
    JButton button[]=new JButton[16];
    
    char operator;
   
    boolean point;
   
    public calculator()
    {
        super("30元計算機");
 
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
 
        JPanel p = new JPanel();
 
        numberfield = new JTextField("0.0");
        numberfield.setHorizontalAlignment(JTextField.RIGHT);
 
        p.setLayout(new GridLayout(4,4));
      
        for(int i=0;i<16;i++){
            button[i]=new JButton(buttonname[i]+"");
            p.add(button[i]);
            button[i].addActionListener(this);
        }
 
        c.add("North",numberfield); // The textfield in the north of frame.
        c.add("Center",p); // The JPanel(p) in the north of frame.
      
        setSize(200,200);
        setVisible(true);
    }
 
    public void actionPerformed(ActionEvent event){
        if(((JButton)event.getSource()).getText().charAt(0)=='.'){
            if(!point){
                if(numberstring.equals(""))
                    numberstring="0";
                    
                numberstring+=".";
                numberfield.setText(numberstring);
                point=true;
           }
        }else if(((JButton)event.getSource()).getText().charAt(0)<='9'&&
                 ((JButton)event.getSource()).getText().charAt(0)>='0'){
            numberstring+=((JButton)event.getSource()).getText().charAt(0)+"";
            numberfield.setText(numberstring);
        }else{
            point=false;
            numberstring="";
            numberfield.setText(operation(number,
                    Double.parseDouble(numberfield.getText()),operator)+"");
            operator=((JButton)event.getSource()).getActionCommand().charAt(0);
            
            if(((JButton)event.getSource()).getText().charAt(0)!='=')
                number=Double.parseDouble(numberfield.getText());
        }
    }
   
    public double operation(double number1,double number2,char operator){
        switch(operator)
        {
            case '+':
                return number1+number2;
            case '-':
                return number1-number2;
            case '*':
                return number1*number2;
            case '/':
                return number1/number2;
            default:
                return number2;
        }
    }
       
    public static void main(String args[]) throws Exception {
        /** Main method */
        String alreadyPassword = " ";
        java.io.File file = new java.io.File("password.txt");

        /**
         *   password.txt exist =====> read password
         *   password.txt doesn't exist======> let user input password to use next tine.
         */
        if(file.exists()) {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                alreadyPassword = input.next(); // Read items
            }
            input.close(); // Close the file.
            TestPassword frame1 = new TestPassword(); // Create a frame.
            frame1.setPassword(alreadyPassword);
            frame1.setSize(350,300); // Set the frame size.
            frame1.setTitle("確認使用者");
            frame1.setLocationRelativeTo(null);
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setVisible(true);  

        } else {
            TestPassword frame1 = new TestPassword(); // Create a frame.
            frame1.setSize(350,300); // Set the frame size.
            frame1.setLocationRelativeTo(null);
            frame1.setTitle("確認使用者");
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setVisible(true);  
        }
          
    }
}

class TestPassword extends JFrame {
    // Create JButton JTextField ,and JPasswordField.
    private JButton jbtEnter = new JButton("Enter");
    private JPasswordField passwordField;
    private JTextField jtfDisplayResult = new JTextField("在上方的空格中輸入計算機密碼");
    String password = "0000"; // 0000 as a initial password.

    TestPassword() {

        // Create a panel to hold JButton JTextField ,and JPasswordField.
        JPanel p1 = new JPanel(new GridLayout(3,1));

        // Set the passwordField attributes.
        passwordField = new JPasswordField();
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        passwordField.setEchoChar('*');
        p1.add(passwordField); // Add passwordField to the panel.

        // Set the jtfDisplayResult attributes.
        jtfDisplayResult.setHorizontalAlignment(JTextField.CENTER);
        jtfDisplayResult.setEditable(false);
        p1.add(jtfDisplayResult); // Add jtfDisplayResult to the panel.
        p1.add(jbtEnter); // Add jbtEnter to the panel.
        add(p1, BorderLayout.CENTER); // Add panel(p1) to the frame.

        // set the button event that user click it.
        jbtEnter.addActionListener(new ButtonListener()); // Register listener.
    }

    // A set method to set password
    public void setPassword(String newPassword) {
        password = newPassword;
    }

    // A get method to get password
    public String getPassword() {
        return password;
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            password = getPassword();
            String userPassword = " "; // User key in the passwordField.
            userPassword = String.valueOf(passwordField.getPassword());
            if(password.equals(userPassword)){
                dispose(); // close the window 
                if(password == "0000"){
                    userPassword = JOptionPane.showInputDialog("第1次使用計算機需先輸入你想設定的密碼"); // A dialog prompt user set password.
                    if(userPassword == null) {
                        System.exit(0); // Exit the program.
                    } else {
                        java.io.PrintWriter output = null;
                        try {
                            output = new java.io.PrintWriter("password.txt");
                        } catch (FileNotFoundException e1) {
                            // To do Auto-generated catch block
                            e1.printStackTrace();
                        }
                        output.print(userPassword); // Write password to the password.txt
                        output.close(); // Close the file
                        calculator a = new calculator(); // Open the calculator.
                        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                    }                       
                } else {
                     calculator a = new calculator(); // Open the calculator.
                    a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
                }                              
            } else {
                jtfDisplayResult.setText("你的密碼是錯的，我再給你一次機會輸入密碼");
                userPassword = " "; // Initialization.
            }         
        }
    }
}
