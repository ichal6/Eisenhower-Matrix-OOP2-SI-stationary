import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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

    public void addItemsFromFile(String filename){
        //Add items from file to map by format:
        // title|day-month|is_important
    }

    public void saveItemsToFile(String filename){
        //Add items from mat to file by format:
        // title|day-month|is_important
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