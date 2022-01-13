//A bufferd file reader, to read the password text file and convert it from the Caesar cypher

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PasswordReader 
{
    public void PasswordReader()
    {   
    }
    public char[] reader() 
    {
    BufferedReader objReader = null;
    try 
    {
    String strCurrentLine;

    //Defining the location and file of the what we want to be read
    objReader = new BufferedReader(new FileReader("password.txt"));

    //A while loop to make the text of "password.txt" into a char array
    //and then taking each character and decrypting it to normal form

    //We can do this by simply adding an int to the char's and then recasting them back to chars
    //This will in turn change the letters back one in a neat fashion
    //we just have the one exception of z, being that is the last letter we cannot push it forward
    //so we reassign it to 'a'
    while ((strCurrentLine = objReader.readLine()) != null) 
    {
        char [] EnteredPassword = strCurrentLine.toCharArray();
        for (int i = 0 ; i < EnteredPassword.length ; i++)
        {
            int caesar = 1;
            
            if (EnteredPassword[i] == 'z')
            {
                EnteredPassword[i] = 'a';
            }
            else
            {
                EnteredPassword[i] = (char) (EnteredPassword[i] + caesar);
            }
        }
        return EnteredPassword;
    }

    } 
    catch (IOException e) 
    {

    e.printStackTrace();

    } finally 
    {

    try 
    {
        if (objReader != null)
        objReader.close();
    } 
    catch (IOException ex) 
    {
        ex.printStackTrace();
    }
    }
    return new char [1];
    }
}





