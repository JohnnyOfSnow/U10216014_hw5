import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class calculator extends JFrame implements ActionListener{
        
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
   
    public calculator()
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
        cal a=new cal();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
 
}
