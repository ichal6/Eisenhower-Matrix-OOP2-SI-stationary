import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TodoMatrix{
    private HashMap<String, TodoQuarter> todoQuarters = new HashMap<String, TodoQuarter>();

    TodoMatrix(){
        todoQuarters.put("IU", new TodoQuarter());
        todoQuarters.put("IN", new TodoQuarter());
        todoQuarters.put("NU", new TodoQuarter());
        todoQuarters.put("NN", new TodoQuarter());
    }
    public Map<String, TodoQuarter> getQuarters(){
        return todoQuarters;
    }

    public String getQuarter(String status){
        //Returns a choosen object drom map. Status should be foreach(IU,IN,NU,NN)
        return "";
    }

    public void addItem(String title, LocalDate deadline){
        //Add new item to map
        boolean isImportant = false;
        addItem(title, deadline, isImportant);
    }

    public void addItem(String title, LocalDate deadline, boolean isImportant){
        //Add new item to map
        LocalDate today = LocalDate.now();
        deadline.toEpochDay();
        long urgent = deadline.toEpochDay() - today.toEpochDay();
        if (urgent <= 3){
            if(isImportant){
                todoQuarters.get("IU").addItem(title, deadline);
            }
            else{
                todoQuarters.get("NU").addItem(title, deadline);
            }
        }
        else{
            if(isImportant){
                todoQuarters.get("IN").addItem(title, deadline);
            }
            else{
                todoQuarters.get("NN").addItem(title, deadline);
            }
        }
    }

    private void saveToFile(String dataToSave, String filename)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(dataToSave);
            fileWriter.close();
        }
        catch ( IOException e) 
        {
            System.out.println("Sorry but I was unable to save your data file");
            e.printStackTrace();
            System.exit(0);
        }
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

    private void ScannerToMatrix(Scanner dataFromFile)
    {
        String newRow = "";
        String title = "";
        String date = "";
        boolean isImportant;
        LocalDate deadline = LocalDate.now();
        while(dataFromFile.hasNextLine()) 
        {
            newRow = dataFromFile.nextLine();
            String[] parts = newRow.split("\\|");

            title = parts[0]; //insert title
            date = parts[1]; //insert date as unforrmatng String
            
            String[] dayAndMonth = date.split("-");
            deadline = deadline.of(2019, Integer.parseInt(dayAndMonth[1]), Integer.parseInt(dayAndMonth[0]));

            if(parts.length == 2){
                isImportant = false;
            }
            else{
                isImportant = true;
            }
            addItem(title, deadline, isImportant);

        }
        //System.out.println(todoQuarters);
    }

    public void addItemsFromFile(String filename){
        //Add items from file to map by format:
        // title|day-month|is_important
        Scanner newScanner = openFile(filename);
        ScannerToMatrix(newScanner);

    }

    public void saveItemsToFile(String filename){
        //Add items from mat to file by format:
        // title|day-month|is_important
        String dataToSave = "";
        String unconvertData = "";
        LocalDate date = LocalDate.now();
        int dateMonth, dateDay;
        String title = "";
        String important = "";
        for(Map.Entry<String, TodoQuarter> entry : todoQuarters.entrySet()){
            unconvertData = entry.getValue().toString().toString();
            if(unconvertData.equals("")){
                continue;
            }
            if(entry.getKey().equals("IU") | entry.getKey().equals("IN")){
                //System.out.println(unconvertData);
                int length = entry.getValue().getItems().size();
                for(int index = 0; index < length; index++){
                    date = entry.getValue().getItem(index).getDeadline();
                    dateMonth = date.getMonthValue();
                    dateDay = date.getDayOfMonth();
                    title = entry.getValue().getItem(index).getTitle();
                    important = "important";
                    dataToSave += String.format("%s|%d-%d|%s\n", title, dateMonth, dateDay, important);
                }
            }
            else{
                int length = entry.getValue().getItems().size();
                for(int index = 0; index < length; index++){
                    date = entry.getValue().getItem(index).getDeadline();
                    dateMonth = date.getMonthValue();
                    dateDay = date.getDayOfMonth();

                    title = entry.getValue().getItem(index).getTitle();
                    dataToSave += String.format("%s|%d-%d|\n", title, dateMonth, dateDay);
                }

            }
           
        }
        
        saveToFile(dataToSave, filename);
    }

    public void archiveItems(){
        //Removes all TodoItem object with parametr isDone from list todoItems
        for (TodoQuarter quarter: todoQuarters.values()){
            quarter.archiveItems();
        }
    }

    public String toString(){
        //Return a todoQuarters list formatted to string
        String returnString = "";
        return returnString;
    }

}