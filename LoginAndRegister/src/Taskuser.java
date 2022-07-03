
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
class Taskuser {
    
    private double totalHours= 0;
    private boolean valid;
   
            
    public String[] creatTaskID(String [] name, int [] tasknr, String []devdetails, int size){ // Method that creates taskId
        
        String [] taskId = new String [size]; // declaring array variable
   
        for(int i=0; i<name.length;i++){ // incrementation of taskId
            taskId[i] = name[i].substring(0, 2).toUpperCase() +":"+tasknr[i]+":"+ devdetails[i].substring(devdetails[i].length()-3, devdetails[i].length()).toUpperCase();
        }
        
        for(int i = 0;i<taskId.length;i++){
            System.out.println(taskId[i]);//prints out taskId
        }
            
        
        return taskId;
    }
    public double returnTotalHours(double [] duration){ // Method to return hours
        
        for(int i=0;i<duration.length;i++){
            totalHours = totalHours +duration[i]; // Prints out totalhours of tasks
        }
            
        return totalHours;
    }
    
    public boolean checkTaskDescription(String [] desc){ // Method to check description of task
        Scanner kb = new Scanner(System.in);
        for(int i=0;i<desc.length;i++){
            if(desc[i].length()>50){
                System.out.println("Please enter a task description of less than 50 characters");
                desc[i]=kb.nextLine();
                valid=false; // if condition is not true 
            }else {
                System.out.println("Task successfully captured");
                valid=true; // if condition is true
            }
        }
        
        return valid;
    }
}



/**
Reference List
© 2019 Cengage Learning Inc. Java Programming Ninth Edition by Joyce Farrell*/