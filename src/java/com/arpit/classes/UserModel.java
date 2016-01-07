/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpit.classes;

/**
 *
 * @author arpit
 */
public class UserModel {
    
    private String username,password;
    
    private boolean isValid = false;

    public UserModel(){
        this.username = "";
        this.password = "";
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    
    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
}
