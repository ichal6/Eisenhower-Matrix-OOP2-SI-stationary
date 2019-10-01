import java.time.LocalDate;
public class TodoItem{
    private String title;
    private LocalDate deadline;
    private boolean isDone = false;

    TodoItem(String title, LocalDate deadline){
        this.title = title;
        this.deadline = deadline;
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
        return isDone;
    }

    public String toString(){
        String outputString = "";
        int month = deadline.getMonthValue();
        int day = deadline.getDayOfMonth();
        if (isDone){
            outputString = String.format("[x] %d-%d %s", month, day, title);
        }
        else{
            outputString = String.format("[ ] %d-%d %s", month, day, title);
        }
        return outputString;
    }
}