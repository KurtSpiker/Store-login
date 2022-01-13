//Version 0.1 April 10 2021
//Added the login class, and worked out the kinks on the initial JFrame

//Version 0.2 April 11 2021
//Added the "PasswordReader" which is the file reader for the text file 
//password, and allowed it to decrypt in its own class. Made the login 
//class able to interact and feed the char arrays to one another so that 
//we could compare them

//Version 0.3 April 12 2021
//Added the Store class, with it the store jframe in gridbaglayout.
//Imported images, and sized them to fit accordingly on the layout.
//Also added the file writter and made the store feed into it, so that
//it could write in its own class.

//Version 1.0 April 13 2021
//Hammered out some bugs with adding delay to the jframes , and did some more
// comments for clarity

//Kurt Spiker UCID: 30137339 T09

//The features: of this program are a working login screen, that uses Caesar encryption security
//A file reader
//A file writter
//And a shopping menu screen that can save your contact information in another file

//Limitations: include only being able to click to proceed in a text box instead of enter.
//And limited password option, limited to lowercase alphabet only

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Login 
{
    //Making an int so that it can be used later on
    static int attempsRemaining = 3;
    public static void main(String [] args)
    {  
        //Basic jframe setup for the Boxlayout format
        PasswordReader password = new PasswordReader();
        Login nLogin = new Login();
        //Allowing the title card to be changed in accordance with the attempts
        JFrame frame = new JFrame("No. incorrect login attempts (max=3):" + attempsRemaining);  
        JPanel panel = new JPanel();  
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  
        JLabel label = new JLabel("Enter password");  
        JButton button = new JButton();
        JPasswordField pass = new JPasswordField();
        pass.setMaximumSize(new Dimension(100,30));
        button.setText("Login ");
        panel.add(Box.createRigidArea(new Dimension(0, 80)));  
        panel.add(label);
        panel.add(pass);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); 
        panel.add(button);  
        frame.add(panel);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        pass.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);  
        frame.setSize(390, 300); 
        frame.setLocation(100, 150);   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true); 
        
        //Action listener for the login button of the panel
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {   
                //using a compare method which is defined a little bit lower
                //to check the compatibility of the char arrays the first being 
                //the one created by calling getpassword from our password text box
                //and the second being the decrypted password from out text file

                //The if statment will allow us to update the attempt counter for a 
                //bad input or close the frame and open the storepage 
                if (nLogin.compare (pass.getPassword(), password.reader()))
                {
                    frame.dispose();
                    nLogin.storePage();   
                }
                else
                {   
                    //updating the count
                    attempsRemaining -= 1;
                    if (attempsRemaining == 0)
                    {
                        //Using another try catch to allow the use of .sleep method
                        //to pause the window so that the user can read the title
                        //message
                        frame.setTitle("Max attempts exceeded, exiting...");
                        try 
                        {
                            Thread.sleep(3000);
                        } 
                        catch (Exception ex)
                        {
                        }
                        frame.dispose();
                    }
                    frame.setTitle("No. incorrect login attempts (max=3):" + attempsRemaining);
                }
            }
        }); 
    } 
    //The comparing method, as metioned above will compare the two char arrays
    //Our guess, and our decrypted password

    //since they are in arrays, we have to compare each index and ensure its the same.
    //We can save some time (doesnt super matter but its good practise) by comparing the 
    //length of the arrays first as if they are not the same we their is no chance that 
    //the entities will be. 
    public boolean compare(char[] pass, char[] EnteredPassword)
    {
        if (pass.length != EnteredPassword.length)
        {
            return false;
        }
        for (int i = 0 ; i < EnteredPassword.length ; i++)
        {
            if (pass[i] != EnteredPassword[i])
            {
                return false;  
            }
        }  
        return true; 
    }

    //Calling the store constructor
    public void storePage()
    {
        new Store();

    }

}