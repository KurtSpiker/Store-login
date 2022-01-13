//The store Jframe class.

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
 
//Extending Jframe so that we can save some time for each step
public class Store extends JFrame {
  
    public Store()
    {
  
        //Importing the textwritter class to be used in the button actions 
        //And then basic Jframe initialization 
        Textwritter textW = new Textwritter();
        setTitle("Order information");
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
  
        gbc.insets = new Insets(5, 5, 5, 5);
        
        //Each section contains its own object on the panel
        //With its grid position, and added features like 
        //images for the labels and buttons
        gbc.gridx = 0;
        gbc.gridy = 0;
        ImageIcon icon1 = new ImageIcon("image1-150.png");
        panel1.add(new JLabel(icon1), gbc);
  
        gbc.gridx = 1;
        gbc.gridy = 0;
        ImageIcon icon2 = new ImageIcon("image2-150.png");
        panel1.add(new JLabel(icon2), gbc);
  
        gbc.gridx = 2;
        gbc.gridy = 0;
        ImageIcon icon3 = new ImageIcon("image3-150.png");
        panel1.add(new JLabel(icon3), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(new JLabel("Name"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        panel1.add(new JLabel("Address"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JTextArea Area1 = new JTextArea(0,8);
        panel1.add(Area1, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        JTextArea Area2 = new JTextArea(3,8);
        panel1.add(Area2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        ImageIcon icon4 = new ImageIcon("image4-50.png");
        JButton saveB = new JButton("SAVE", icon4);
        panel1.add(saveB, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        ImageIcon icon5 = new ImageIcon("image5-50.png");
        JButton clearB = new JButton("CLEAR", icon5);
        panel1.add(clearB, gbc);

        //Setting up the frame, closing operations, and visibility
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(panel1);
        setSize(600, 400);
        setVisible(true);

        //Listener for the save button
        //This feeds the strings from both text boxes
        //to the text writter class to be written
        //Try Catch it used to implement the sleep
        //function
        saveB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent s)
            {
                setTitle("Saving, please wait");
                String nameT = Area1.getText();
                String addressT = Area2.getText();
                textW.Writter(nameT, addressT);
                try
                {
                    Thread.sleep(3000);
                }
                catch (Exception ex)
                {
                }
                setTitle("Order information");
            }
        });
        
        //Listener for the clear button
        //clears both the text fields when the button is pressed
        clearB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent c)
            {
                Area1.setText(null);
                Area2.setText(null);
            }
        });

    }
}