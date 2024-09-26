package com.example;

public class PasswordValidator {


    private NotificationService notificationService;

    
   
    public PasswordValidator(NotificationService notificationService) {
        this.notificationService = notificationService;
    }



    public boolean isValidPassword(String password){


        //refactored implementation 

        if(password==null){
            return false;
        }
        

        if(password.length() < 8 ){
            return false;
        }

        for (char c: password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                this.notificationService.sendNotification("Password is valid");
                return true;
            }
        }

        return false;
      
    }
}



   /* 
        if(password==null){
            return false;
        }
        

        //condition 1: more than 8 letters
        if(password.length() < 8 ){
            return false;
        }

        //condition 2: has 1 or + uppercase

        for (char c: password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }

        //if no conditions are met return false
        return false;

        */