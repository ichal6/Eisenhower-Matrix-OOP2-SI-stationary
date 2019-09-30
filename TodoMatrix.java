import java.time.LocalDate;
import java.util.HashMap;

public class TodoMatrix{
    HashMap<String, LocalDate> todoQuarters = new HashMap<String, LocalDate>();

    TodoMatrix(){

    }

    public String getQuarter(String status){
        //Returns a choosen object drom map. Status should be foreach(IU,IN,NU,NN)
        return "";
    }

    public void addItem(String title, LocalDate deadline){
        //Add new item to map
    }

    public void addItem(String title, LocalDate deadline, boolean isImportant){
        //Add new item to map
    }

    public void addItemsFromFile(String filename){
        //Add items from file to map by format:
        // title|day-month|is_important
    }

    public void saveItemFromFile(String filename){
        //Add items from mat to file by format:
        // title|day-month|is_important
    }

    private void archiveItems(){
        //Removes all TodoItem object with parametr isDone from list todoItems
    }

    public String toString(){
        //Return a todoQuarters list formatted to string
        String returnString = "";
        return returnString;
    }


}