import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class calculatorTwo extends JFrame implements ActionListener{
        
    JTextField numberfield;
    
    String numberstring="";
    
    double number;
    
    char buttonname[]={'7','8','9','/',
                       '4','5','6','*',
                       '1','2','3','-',
                       '0','.','=','+'};
                       
    JButton button[]=new JButton[16];
    
    char operator;
   
    boolean point;
   
    public calculatorTwo()
    {        
        super("123");
 
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
 
        JPanel p=new JPanel();
 
        numberfield=new JTextField("0.0");
        numberfield.setHorizontalAlignment(JTextField.RIGHT);
 
        p.setLayout(new GridLayout(4,4));
      
        for(int i=0;i<16;i++){
            button[i]=new JButton(buttonname[i]+"");
            p.add(button[i]);
            button[i].addActionListener(this);
        }
 
        c.add("North",numberfield);
        c.add("Center",p);
      
        setSize(200,200);
        setVisible(true);
    }
 
    public void actionPerformed(ActionEvent event)
    {   
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
   
    public double operation(double number1,double number2,char operator)
    {      
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
       
    public static void main(String args[])
    {   

        /** Main method */
        TestPassword frame1 = new TestPassword(); // Create a frame.
        frame1.setSize(350,300); // Set the frame size.
        frame1.setTitle("Calculator");
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);

              
    }
 
}

class TestPassword extends JFrame {
    // Create JButton  JTextField ,and JPasswordField.
        private JButton jbtEnter = new JButton("Enter");
    private JTextField jtfDisplayResult = new JTextField("輸入你的密碼在上方的空格內");

    TestPassword() {
        // Create a panel to hold JButton  JTextField ,and JPasswordField.
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

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String password = "0000"; 
            String userPassword = " "; // User key in the passwordField.

            userPassword = String.valueOf(passwordField.getPassword());
            if(password.equals(userPassword)){
                dispose(); // close the window
                calculatorTwo a = new calculatorTwo();
                a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                 
            } else {
                jtfDisplayResult.setText("你現在不可以使用計算機，但我再給你機會再輸入一次密碼");
                userPassword = " "; // Initialization.
            }
            
        }
    }

}private JPasswordField passwordField;
