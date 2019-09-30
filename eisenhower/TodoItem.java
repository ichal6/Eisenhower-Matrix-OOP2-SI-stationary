package eisenhower;

import java.time.LocalDate;
public class TodoItem{
    String title;
    LocalDate deadline;
    boolean isDone = false;

    TodoItem(String title, LocalDate deadline){

    }

    public String getTitle(){
        //This method must be return title String
        return title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void mark(){
        isDone = true;
    }

    public void unmark(){
        isDone = false;
    }

    public boolean isDone(){
        return true;
    }

    public String toString(){
        String forString = "";
        return forString;
    }
}