//Text writter 
import java.io.FileWriter;
import java.io.IOException;

public class Textwritter {

    public void Textwritter()
    {
    }
    //The writter is being fed the two strings which corrospond to the text boxes of store
    public void Writter(String nameT, String addressT) {
        try {
            FileWriter writer = new FileWriter("order.txt", true);
            writer.write(nameT);
            //Writting a line to seperate the two strings(text boxes)
            writer.write("\r\n");
            writer.write(addressT);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
 
}