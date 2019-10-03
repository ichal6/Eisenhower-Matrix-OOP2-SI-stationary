import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Label {
    Label(){

    }
    private Scanner openFile(String filename)
    {
        Scanner data = null;

        try 
        {
            data = new Scanner(new File(filename));
        }
        catch ( IOException e) 
        {
            System.out.println("Sorry but I was unable to open your data file");
            e.printStackTrace();
            System.exit(0);
        }
        return data;
    }
    
    private String importFile(Scanner dataFromFile){
        String newRow = "";
        String output = "";
        //ArrayList <String> output = new ArrayList<String>();
        while(dataFromFile.hasNextLine()) 
        {
            newRow = dataFromFile.nextLine();
            output += newRow + "\n";
        }
        return output;
    }

    public StringBuffer returnLabel(){
        String labelAsString = importFile(openFile("draftLabel.txt"));
        StringBuffer labelAsBuffer = new StringBuffer(labelAsString);
        
        return labelAsBuffer;
    }
}