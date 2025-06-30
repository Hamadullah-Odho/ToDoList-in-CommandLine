import java.util.*;
public class ToDoList {

    static Scanner scan = new Scanner(System.in);
    //String arrays to store tasks and dates
    static String[] tasks;
    //date not used
    
    // limit variable to check if todolist is full or not
    static int limit;

    // static block to initializing static variables for proper usage
    static{
        tasks = new String[50];
        limit = 0;
    }

    //method to add task
    static void addTask(){
        System.out.print("Enter Task Name : ");
        try {
            String task = scan.nextLine();
            tasks[limit] = task;
            limit++;
        }
        catch (ArrayIndexOutOfBoundsException error){
            System.out.println("Task List Full");
        }
        catch (Exception error){
            System.out.println("> Error" + error);
        }

    }
    //method to remove task
    static void removeTask(){
        System.out.print("Enter Task Name :");
        try {
            String remove_task = scan.nextLine();
            int remove_index = 0;
            for (String task : tasks) {
                if (remove_task.equals(task)) {
                    tasks[remove_index] = null;
                    System.out.println("Task Removed");
                }
                remove_index++;
            }
        }
        catch (Exception e){
            System.out.println("Error : " + e);
        }
    }
    // method to show user todolist
    static void showToDoList(){

        try {
            System.out.println("> To Do List");
            for (String task : tasks) {

                if(task != (null)){
                    System.out.println(task);
                }
            }
            System.out.println();
        }
        catch(NullPointerException e){
            System.out.println("Error : " + e.getMessage());
        }

    }
    //show menu method
    static void showMenu(){
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println(("3. Show ToDoList"));
        System.out.println("4. Exit");

    }
    // main method
    public static void main(String[] args){

        // boolean run variable for deciding start and end of  todolist
        boolean run = true;
        while(run){

            showMenu();
            System.out.print("> Enter Selection : ");
            String select = scan.nextLine();

            try{
                int choice = Integer.parseInt(select);

                switch(choice){
                    case 1:
                        addTask();
                        break;
                    case 2:
                        removeTask();
                        break;
                    case 3:
                        showToDoList();
                        break;
                    case 4:
                        run = false;
                        break;
                    default:
                        System.out.println("> Provide Valid Selection");
                        break;
                }
            }
            catch (NumberFormatException e){
                System.out.println("> Selection Cannot be Non-Numeric");
            }
            catch (Exception e){
                System.out.println("Error : " + e);
            }
        }

    }
}
