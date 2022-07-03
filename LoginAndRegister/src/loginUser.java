
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class loginUser {

   private String fname;// private variable for the getters and setters methods
   private String Sname;// private variable for the getters and setters methods
   private String Upass;// private variable for the getters and setters methods
   private String Uname;// private variable for the getters and setters methods

    public String getFname() { // Returns the First name 
        return fname;
    }

    public void setFname(String fname) { //  Sets the First name 
        this.fname = fname;
    }

    public String getSname() { // Returns the Second name
        return Sname;
    }

    public void setSname(String Sname) { // Sets the Second name
        this.Sname = Sname;
    }

    public String getUpass() { // Returns the User password
        return Upass;
    }

    public void setUpass(String Upass) { // Sets the User Password
        this.Upass = Upass;
    }

    public String getUname() { // Returns the User password
        return Uname;
    }

    public void setUname(String Uname) { // Sets the Username
        this.Uname = Uname;
    }
   
   // ( geeksforgeeks , 2022)
   
   

   

    public boolean checkPasswordComplexity(String ptf2) { // This method ensures that passwords meet the password complexity rules
        
        Pattern special = Pattern.compile("[!@#$%&8()_+=|<>?{}\\\\[\\\\]~-]"); // Statement that imports Regex Pattern package and includes password complexity requirements in square brackets
        // See 6 minute video of Java Password Validation using Regular Expression - Dr. Parag Shukla
        Matcher sMatcher = special.matcher(ptf2); // Statement that imports Regex Matcher package class
        boolean foundSpecial = sMatcher.find();
        boolean checkPassword; // Compares whether the password matches the complexity of the Regex Pattern package
        // See Seven minute Methods - Boolean Methods - Paul Miskew 2013
        
        if (foundSpecial ) { //  condition for password complexity 
            
           
            JOptionPane.showMessageDialog(null, " Password succesfully captured. ");
            checkPassword = true; // Returns message so long as condition is true
        } else {
            JOptionPane.showMessageDialog(null, "Please Enter a valid password , [ Password is not correctly formatted please ensure that the passowrd contains at least 8 characters, a capital letter , a number and a special ] ");
             checkPassword = false; // Returns message so long as condition is false        
        }
        return checkPassword;
    }

    public boolean checkUserName(String sn) { // This method ensures that any username contains an under score (_) and is no more than 5 characters
 
        
        if (sn.length() <= 6 && sn.contains("_") ){ // Condition to ensure character length is equal to or less than 5 characters
     
            JOptionPane.showMessageDialog(null, " Username succesfully captured. ");
            
          return true; // Indicates that the output statement should be printed true for as long as the condition is true
        } else {
            JOptionPane.showMessageDialog(null, " Username is not correctly formatted [ please ensure that your username contains an underscore and is no more than 5 characters in length ]");
          return false;// Indicates that the output statement should be printed for as long as the condition is false
        }
    }

    public String registerUser(boolean checkPassword , boolean checkUsername, String ru , String ptf2 , String firstname, String secondname) {// This method returns the necessary registration messages.
        
    String reg = " "; // String for Message 
        if (checkPassword && checkUsername) { // Condition for if Username and Password are correct
           
         
            JOptionPane.showMessageDialog(null, " The two above conditions have been met and the user has been registered successfully.");
            reg = " The two above conditions have been met and the user has been registered successfully.";
            
        }
         else if (!checkUsername) { // Condition for if Username is incorrect         
         JOptionPane.showMessageDialog(null, " The username is incorrectly formatted. ");
        reg =  " The username is incorrectly formatted. ";
                            }
         else if (!checkPassword)  { // Condition for if Password is incorrect
                                JOptionPane.showMessageDialog(null, " The password does not meet the complexity requirements. ");
                               reg = " The password does not meet the complexity requirements. ";
                                }
        
                            
    return reg; // Return the message back to the method for each condition

   // ( Farrell , 2019)

} 
     public void loginUser(String tempUser,String tempPass) { // This method verifies that the login details entered matches the login details stored when the user registers and returns the necessary messaging for a succcessful login and failed login
        
         
         System.out.println(Sname); // To check if method is working
         System.out.println(fname); // To check if method is working
         System.out.println(Upass); // To check if method is working
         System.out.println(Uname); // To check if method is working
         // ( Farrell , 2019)
         if(Uname.equals(tempUser) && Upass.equals(tempPass)){ // Condition that compares amd username and passowrd in Register frame and compares username and password entered in login interface
         JOptionPane.showMessageDialog(null ,  "Welcome "  +  fname  +" "+  Sname  +  ",it is great to see you again!" );
         }
         else{
             JOptionPane.showMessageDialog(null ," Username or Password is incorrect , Please try again ");
             
         }
         
         Taskuser newtask = new Taskuser();        
    
    }

}
 /**
 Reference List
 © 2019 Cengage Learning Inc. Java Programming Ninth Edition by Joyce Farrell
 Analyzing a Java Application that Produces Console Output Page 12 Chapter 1 
 Using Input Dialog Boxes Page 82 Chapter 2
 Declaring Objects and using their methods Java Programming by Joyce Farrell Page 145 chapter 3 
 https://www.roseindia.net.java/example/java/swing/IconifyAndMaximizeFrm.shtml
 [Accessed 10 May 2022 ]
 https://coderanch.com/t/343686/java/setLocationRelativeTo
 [Accessed 10 May 2022 ]
 // See Seven minute Methods - Boolean Methods - Paul Miskew 2013 added by Paul Miskew available at https://youtu.be/aMseR3t7Jbk
 [Accessed 8 May 2022]
 See 6 minute video of Java Password Validation using Regular Expression - Dr. Parag Shukla added by Dr. Parag Shukla available at https://youtu.be/zVBxKfWJuDs
 [Accessed 8 May 2022]
 https://www.google.com/amp/s/www/geeksforgeeks.org/getter-and-setter-in-java/amp/
 [Accessesed 11 May 2022]
  */
        
