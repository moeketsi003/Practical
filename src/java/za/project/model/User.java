/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.project.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Mega
 */
public class User {
    
    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
}
