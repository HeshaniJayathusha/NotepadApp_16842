import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main{
    public static void main(String[] args){

        Border border = BorderFactory.createLineBorder(Color.blue);

         JFrame frame = new JFrame();
         frame.setTitle("First Application");
         frame.setSize(600,600);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);

         JLabel label = new JLabel();
         label.setText("Hello World");
         label.setForeground(Color.blue);
         label.setHorizontalAlignment(JLabel.CENTER);
         label.setVerticalAlignment(JLabel.TOP);
         label.setBorder(border);
         frame.add(label);










    }

}