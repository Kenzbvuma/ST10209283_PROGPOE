
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class Arrayuser {

    public void array1() {
        int userInput = 0;
        int taskno = 0;
        int choice;
        String choicestring;
        Scanner kb = new Scanner(System.in);
        //
        /*
        kb.nextLine();*/
        choicestring = (JOptionPane.showInputDialog(null, "Welcome to EasyKanban.\n" // displays menu option
                + " Menu.\n"
                + "1. Add Tasks.\n"
                + "2. Coming Soon.\n"
                + "3. Quit."));
        choice = Integer.parseInt(choicestring);
        if (choice == 1) {
            System.out.println("Enter the number of tasks you want to capture");
            userInput = kb.nextInt();
            kb.nextLine();//consumes enter key
        }
        String[] name = new String[userInput];//creates name array for name of task
        int[] taskNr = new int[userInput];// Creates array for task number
        String[] desc = new String[userInput];//Creates array for task description
        String[] devDetes = new String[userInput];//Creates array for Developer detail
        double[] duration = new double[userInput];//Creates array for duration
        String[] taskId = new String[userInput];//Creates array for taskId
        String[] status = new String[userInput];//Creates array for status of task
// See video nine minute video of Java Arrays Tutorial - Alex Lee

        String[] tasks = {"task name:", "task nr", "task description:",
            "developer details:", "task duration", "task status:"
        };
        Taskuser taskobj = new Taskuser();
        //populate array
        switch (choice) {
            case 1:
                for (int i = 0; i < name.length; i++) {
                    System.out.println("Enter a task name:");
                    
                    name[i] = kb.nextLine();
                    
                    taskNr[i] = i;
                    //Checking task description
                    System.out.println("Enter task description:");//prompts user for task description
                    desc[i] = kb.nextLine();
                    
                    System.out.println("Enter developer details:");// prompts user for Developer details
                    devDetes[i] = kb.nextLine();
                    
                    System.out.println("Enter task duration");// prompts user to display duration the task runs
                    duration[i] = kb.nextDouble();
                    kb.nextLine();//consumes enter key
                    
                    System.out.println("Enter task status:"
                            + "\n 1. Done"
                            + "\n 2. Doing"
                            + "\n 3.To Do ");// Prompts user to enter task status
                    int statuschoice = kb.nextInt();
                    if (statuschoice == 1) {
                        status[i] = "done";
                    } else if (statuschoice == 2) {
                        status[i] = "Doing";
                    } else {
                        status[i] = " To Do";
                    }
                    
                    kb.nextLine();//consumes enter key
                    // ( Farrell , 2019)
                    System.out.println(
                            name[i] + "\n"
                                    + desc[i] + "\n"
                                    + devDetes[i] + "\n"
                                    + duration[i] + "\n"
                                    + status[i]);
                    
                }   taskobj.checkTaskDescription(desc);
                taskId = taskobj.creatTaskID(name, taskNr, devDetes, userInput);
                taskobj.returnTotalHours(duration);
                int userchoice = 0;
                while (userchoice != 7) {
                    
                    System.out.println("Display"
                            + " 1.Display the Developer, Task Names and Task Duration for all tasks with the status of done.\n"
                            + "2.Display the Developer and Duration of the class with the longest duration.\n"
                            + "3.Search for a task with a Task Name and display the Task Name, Developer and Task Status.\n"
                            + "4.Search for all tasks assigned to a developer and display the Task Name and Task Status.\n"
                            + "5.Delete a task using the Task Name.\n"
                            + "6.Display a report that lists the full details of all captured tasks.\n"
                            + "7.QUIT");
                    
                    userchoice = kb.nextInt();
                    kb.nextLine();//consumes enter key
                    // User choice for searching aRRAYS
                    if (userchoice == 1) {
                        displayStatusDone(devDetes, name, duration, status);
                    } else if (userchoice == 2) {
                        displaylongduration(devDetes, duration);
                    } else if (userchoice == 3) {
                        System.out.println("Enter name you want to search for");
                        String tempsearchtsk = kb.next();
                        SearchTask(name, devDetes, status, tempsearchtsk);
                    } else if (userchoice == 4) {
                        System.out.println("Enter Developer Name ");
                        String searchdev = kb.next();
                        Searchdevnametasks(devDetes, name, status, searchdev);
                    } else if (userchoice == 5) {
                        System.out.println("Enter task name you want to delete");
                        String searchdelete = kb.next();
                        devDetes = SearchDelete(devDetes, name, searchdelete);
                        status = SearchDelete(status, name, searchdelete);
                        taskId = SearchDelete(taskId, name, searchdelete);
                        duration = deleteduration(duration, name, searchdelete);
                        name = SearchDelete(name, name, searchdelete);
                    } else if (userchoice == 6) {
                        displayAllArrays(devDetes,name,taskId,duration,status,taskNr);
                        
                    } else if (userchoice == 7) {
                        System.exit(0);
                    }
                    
                }
                // array.toString();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Coming Soon");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Quit");
                break;
        }

    }

    public void displayStatusDone(String[] devDetes, String[] name, double[] duration, String[] status) {
        for (int i = 0; i < status.length; i++) {
            if (status[i].equalsIgnoreCase("Done")) {
                System.out.println("Details" + devDetes[i]
                        + "\n Name" + name[i]
                        + "\n Duration" + duration[i]
                        + "\n Status" + status[i]);
            }

        }
    }
//https://www.codegrepper.com/code-examples/java/java+function+that+returns+the+index+of+the+largest+value+in+an+array

    public void displaylongduration(String[] devDetes, double[] duration) {
        int longest = 0;
        for (int i = 1; i < devDetes.length; i++) {
            if (duration[i] > duration[longest]) {
                longest = i;
            }

        }
        System.out.println("Details" + devDetes[longest] + "Duration\n" + duration[longest]);

    }

    public void SearchTask(String[] name, String[] devDetes, String[] status, String tempsearchtask) {

        for (int i = 0; i < name.length; i++) {
            if (name[i].equalsIgnoreCase(tempsearchtask)) {
                System.out.println("Details" + devDetes[i]
                        + "\n Name" + name[i]
                        + "\n Status" + status[i]);
            }
        }
    }

    public void Searchdevnametasks(String[] devDetes, String[] name, String[] status, String tempdev) {

        for (int i = 0; i < devDetes.length; i++) {
            if (devDetes[i].equalsIgnoreCase(tempdev)) {
                System.out.println("Details" + devDetes[i]
                        + "\n Name" + name[i]
                        + "\n Status" + status[i]);
            }

        }
    }

    public String[] SearchDelete(String[] devDetes, String[] name, String searchdelete) {
        // https://www.geeksforgeeks.org/remove-an-element-at-specific-index-from-an-array-in-java/
        // Create another array of size one less
        String[] Developerdetes = new String[devDetes.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < devDetes.length; i++) {

            // if the index is
            // the removal element index
            if (name[i].equalsIgnoreCase(searchdelete)) {
                continue;
            }

            // if the index is not
            // the removal element index
            Developerdetes[k++] = devDetes[i];
        }
        return Developerdetes;
    }

    public double[] deleteduration(double[] devDetes, String[] name, String searchdelete) {
        // https://www.geeksforgeeks.org/remove-an-element-at-specific-index-from-an-array-in-java/
        // Create another array of size one less
        double[] Developerdetes = new double[devDetes.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < devDetes.length; i++) {

            // if the index is
            // the removal element index
            if (name[i].equalsIgnoreCase(searchdelete)) {
                continue;
            }

            // if the index is not
            // the removal element index
            Developerdetes[k++] = devDetes[i];
        }
        return Developerdetes;
    }

    public void displayAllArrays(String[] devDetes, String[] name, String[] taskId, double[] duration, String[] status, int[] taskNr) {
for (int i = 0; i < devDetes.length; i++) {
                        System.out.println("Task Name:" + name[i]
                                + "\n Developer Details:" + devDetes[i]
                                + "\nTask ID:" + taskId[i]
                                + "\n Task Duration " + duration[i]
                                + "\n Task Status" + status[i]);
                    }
    }

}

/**
 * Reference List © 2019 Cengage Learning Inc. Java Programming Ninth Edition by
 * Joyce Farrell Analyzing a Java Application that Produces Console Output Page
 * 12 Chapter 1 Using a variable subscripts with an array pg 369 see nine minute
 * video of Java Arrays Tutorials - Alex Lee by Alex Lee
 * https://youtu.be/xzjZy-dHHLw [Accessed 05 June 2022]
 */
