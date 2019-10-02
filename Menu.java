import java.util.Scanner;

public class Menu {
    Menu(){

    }
    public void displayMenu(){
        int numberOfOption = chooseOption();
        switchOptions(numberOfOption);
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

    private void switchOptions(int numberOfOption){
        switch(numberOfOption){
            case 1:
                displayQuarter();
                break;
            case 2:
                addItem();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 0:
                break;
        }
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

    private void displayQuarter(){
        System.out.println("Please choose which one quarter to display:[NN,IN,IU,NU]");
        String answer = inputUserData();
        switch(answer){
            case "NN":
                break;
            case "IN":
                break;
            case "IU":
                break;
            case "NU":
                break;
            default:
                System.out.println("Wrong input!");
        }
    }

    private void addItem(){
        System.out.print("Please insert title item: ");
        String title = inputUserData();
        int monthAsInt;
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
                int dayAsInt = Integer.parseInt(day);
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
    }
}