import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.*;
import java.util.*;

/**
   A frame that shows the growth of an investment with variable interest.
*/
public class InvestmentFrame2 extends JFrame
{    
   private static final int FRAME_WIDTH = 450;
   private static final int FRAME_HEIGHT = 300;

   private static final double DEFAULT_RATE = 5;
   //private static final double INITIAL_BALANCE = 1000;   

   private JLabel rateLabel;
   private JTextField rateField;
   private JButton button;
   private JLabel resultLabel;
   private double balance;
   private JLabel initialbalance;
   private JTextField balancefield; 
   private JButton buttonbalance;
   
 
   public InvestmentFrame2()
   {  
      //balance = INITIAL_BALANCE;

      resultLabel = new JLabel("Balance: ");
      initialbalance = new JLabel("Initial Balance");
      balancefield = new JTextField(10);

      createTextField();
      createButton();
      createPanel();
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      setTitle("InvestmentFrame2");
   }

   private void createTextField()
   {
      rateLabel = new JLabel("Interest Rate: ");

      final int FIELD_WIDTH = 10;
      rateField = new JTextField(FIELD_WIDTH);
      rateField.setText("" + DEFAULT_RATE);
   }

   /**
      Adds interest to the balance and updates the display.
   */
   class AddInterestListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         Scanner in = new Scanner(balancefield.getText());
         if (in.hasNextDouble())
         {
         double rate = Double.parseDouble(rateField.getText());
         balance = Double.parseDouble(in.next());
         //balance = initialbalance;
         double interest = balance * rate / 100;
         balance = balance + interest;
         resultLabel.setText("Balance: " + balance);
         balancefield.setText(""+balance);
         }
      }            
   }
      
   private void createButton()
   {
      button = new JButton("Add Interest");
      buttonbalance = new JButton("Add initial balance");
      
      ActionListener listener = new AddInterestListener();
      ActionListener listener2 = new AddInterestListener();
      button.addActionListener(listener);
      buttonbalance.addActionListener(listener2);
   }

   private void createPanel()
   {
      JPanel panel = new JPanel();
      panel.add(rateLabel);
      panel.add(rateField);
      panel.add(button);
      panel.add(resultLabel); 
      panel.add(initialbalance);
      panel.add(balancefield);
      add(panel);
   } 

}
