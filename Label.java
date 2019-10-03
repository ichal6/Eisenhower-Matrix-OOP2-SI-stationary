import java.io.File;
import java.io.IOException;
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

    public void displayLabel(TodoMatrix matrix){
        String labelAsString = importFile(openFile("draftLabel.txt"));
        StringBuffer labelAsBuffer = new StringBuffer(labelAsString);
        
        labelAsBuffer = insertDataToLabel(labelAsBuffer, matrix);

        System.out.println(labelAsBuffer);
    }

    public StringBuffer insertDataToLabel(StringBuffer label, TodoMatrix matrix){
        int tabulation = 6;
        int startRow = 2;
        String status = "IU";
        label = insertQuarterInLabel(tabulation, startRow, status, label, matrix);

        tabulation = 39;
        startRow = 2;
        status = "IN";
        label = insertQuarterInLabel(tabulation, startRow, status, label, matrix);

        tabulation = 6;
        startRow = 16;
        status = "NU";
        label = insertQuarterInLabel(tabulation, startRow, status, label, matrix);

        tabulation = 39;
        startRow = 16;
        status = "NN";
        label = insertQuarterInLabel(tabulation, startRow, status, label, matrix);

        return label;
    }

    private StringBuffer insertQuarterInLabel(int tab, int startRow, String status, StringBuffer label, TodoMatrix matrix){
        String output = "";
        int maxWeidth = 31;
        int rowLength = 72;
        int lengthWord = 0;
        for(TodoItem item :matrix.getQuarter(status).getItems()){
            output = item.toString();
            lengthWord = output.length();
            if(lengthWord > maxWeidth){
                output = output.substring(0, maxWeidth);
                lengthWord = maxWeidth;
            }
            label.replace((rowLength * startRow) + tab,(rowLength * startRow) + tab + lengthWord, output);
            startRow++;
        }
        return label;
    }
}