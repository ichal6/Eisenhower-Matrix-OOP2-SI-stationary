import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class TodoQuarter{
    ArrayList<String> toDoItems = new ArrayList<String>();

    TodoQuarter(){

    }

    public void addItem(String title, LocalDate deadLine){
        //Append new item to List
    }

    public void removeItem(int index){
        //Remove object with index from list
    }

    public void archiveItems(){
        //Remove all object with parametr isDone == true from list
    }

    public String getItem(int index){
        String object = "";
        return object;
    }

    public List<String> getItems(){ 
        //Return private field todoItems - It's uncertain
        return toDoItems;
    }

    public String toString(){
        // Return formatted list to label 
        String forString = "";
        return forString;
    }
}