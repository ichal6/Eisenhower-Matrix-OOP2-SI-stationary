import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    private TodoMatrix matrix = new TodoMatrix();
    private Label array = new Label();

    Menu(){
        matrix.addItemsFromFile("todo_items_read_test.csv");
    }

    public void displayMenu(){
        boolean isRun = true;
        while(isRun){
            int numberOfOption = chooseOption();
            isRun = switchOptions(numberOfOption);
        }
        
    }

    private void displayOptions(){
        String[] options =  {"1. Show quarter matrix", "2. Add item to matrix",
                            "3. Mark or unmark your tasks", "4. Remove items from matrix",
                            "5. Remove all done items", "6. Save to file items",
                            "7. Remove all done items, save to file and close program",
                            "8. Show all matrix", "0. Close program"};
        for(String option: options){
           System.out.println(option); 
        }
    }

    private boolean switchOptions(int numberOfOption){
        String status;
        int indexItem;
        StringBuffer label;
        switch(numberOfOption){
            case 1:
                displayQuarter();
                break;
            case 2:
                addItem();
                break;
            case 3:
                status = displayQuarter();
                if(status.equals("emptyQuarter")){
                    System.out.println("Quarter is empty!");
                    break;
                }
                indexItem = selectItem("Please select item by mark/unmark: ");
                if( matrix.getQuarter(status).getItem(indexItem).isDone()){
                    matrix.getQuarter(status).getItem(indexItem).unmark();
                }
                else{
                    matrix.getQuarter(status).getItem(indexItem).mark();
                }
                break;
            case 4:
                status = displayQuarter();
                if(status.equals("emptyQuarter")){
                    System.out.println("Quarter is empty!");
                    break;
                }
                indexItem = selectItem("Please select item by remove: ");
                matrix.getQuarter(status).removeItem(indexItem);
                break;
            case 5:
                matrix.archiveItems();
                break;
            case 6:
                matrix.saveItemsToFile("todo_items_file.csv");
                break;
            case 7:
                matrix.archiveItems();
                matrix.saveItemsToFile("todo_items_file.csv");
                return false;
            case 8:
                label = array.returnLabel();
                insertDataToLabel(label);
                //System.out.println(label);
                break;
            case 0:
                return false;
        }
        return true;
    }

    private int chooseOption(){
        int numberOfOption = 0;
        boolean isInsert = true;
        while(isInsert){
            displayOptions();
            System.out.println("Please choose option:");
            try{
                numberOfOption = Integer.parseInt(inputUserData());
                isInsert = false;
                
            }catch(Exception e){
                System.out.println("Incorrect value!");
                isInsert = true;
            }
        }
        return numberOfOption;
    }

    private String inputUserData(){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        return text;
    }

    private String displayQuarter(){
        System.out.println("Please choose which one quarter to display:[NN,IN,IU,NU]");
        String answer = inputUserData();
        switch(answer){
            case "NN":
            case "IN":
            case "IU":
            case "NU":
                System.out.println(matrix.getQuarter(answer).toString());
                String unconvertData = matrix.getQuarter(answer).toString().toString();
                if(unconvertData.equals("")){
                    return answer = "emptyQuarter";
                }
                return answer;
            default:
                System.out.println("Wrong input!");
        }
        
        return answer = "emptyQuarter";
    }

    private void addItem(){
        System.out.print("Please insert title item: ");
        String title = inputUserData();
        int monthAsInt = 1, dayAsInt = 1;
        boolean isNotCorrect = true;
        while(isNotCorrect){
            try{
                System.out.print("Please insert month deadline: ");
                String month = inputUserData();
                monthAsInt = Integer.parseInt(month);
                if (monthAsInt > 0 & monthAsInt < 13){
                    isNotCorrect = false;
                }
                else{
                    System.out.println("Please insert correct month!");
                }
            }
            catch (Exception e){
                System.out.println("Please insert correct month!");
            }
        }
        isNotCorrect = true;
        while(isNotCorrect){
            try{
                System.out.print("Please insert day deadline: ");
                String day = inputUserData();
                dayAsInt = Integer.parseInt(day);
                if (dayAsInt > 0 & dayAsInt < 32){
                    isNotCorrect = false;
                }
                else{
                    System.out.println("Please insert correct day!");
                }
            }
            catch (Exception e){
                System.out.println("Please insert correct day!");
            }
        }
        LocalDate deadline = LocalDate.now();
        int actualYear = deadline.getYear();
        deadline = deadline.of(actualYear, monthAsInt, dayAsInt);

        System.out.print("Is your task important?:[y] ");
        String answer = inputUserData();
        if(answer.contains("y"))
        {
            matrix.addItem(title, deadline, true);
        }
        else{
            matrix.addItem(title, deadline);
        }
    }

    private int selectItem(String order){
        int index = 0;
        boolean isNotCorrect = true;
        while(isNotCorrect){
            try{
                System.out.print(order);
                index = Integer.parseInt(inputUserData());
                isNotCorrect = false;
            }catch(Exception e){
                System.out.println("Wrong input!");
            }
        }
        return index - 1;
    }

    private void insertDataToLabel(StringBuffer label){
        
        
        int tab = 6;
        int index = 2;
        String output = "";
        int maxWeidth = 31;
        int rowLength = 72;
        int lengthWord = 6;
        for(TodoItem item :matrix.getQuarter("IU").getItems()){
            output = item.toString();
            lengthWord = output.length();
            label.replace((rowLength * index) + tab,(rowLength * index) + tab + lengthWord, output);
            index++;
        }
        tab = 39;
        index = 2;
        for(TodoItem item :matrix.getQuarter("IN").getItems()){
            output = item.toString();
            lengthWord = output.length();
            if(lengthWord > maxWeidth){
                output = output.substring(0, maxWeidth);
                lengthWord = maxWeidth;
            }
            label.replace((rowLength * index) + tab,(rowLength * index) + tab + lengthWord, output);
            index++;
        }
        tab = 6;
        index = 16;
        for(TodoItem item :matrix.getQuarter("NU").getItems()){
            output = item.toString();
            lengthWord = output.length();
            if(lengthWord > maxWeidth){
                output = output.substring(0, maxWeidth);
                lengthWord = maxWeidth;
            }
            label.replace((rowLength * index) + tab,(rowLength * index) + tab + lengthWord, output);
            index++;
        }

        tab = 39;
        index = 16;
        for(TodoItem item :matrix.getQuarter("NN").getItems()){
            output = item.toString();
            lengthWord = output.length();
            if(lengthWord > maxWeidth){
                output = output.substring(0, maxWeidth);
                lengthWord = maxWeidth;
            }
            label.replace((rowLength * index) + tab,(rowLength * index) + tab + lengthWord, output);
            index++;
        }
        System.out.println(label);
    }
}