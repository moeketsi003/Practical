/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.project.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 *
 * @author Mega
 */
public class Token {
    
    private String token = "";
    
    public String getToken(){
        return token;
    }
    
    public void setToken(String token){
        this.token = token;
    }
    
    public static Token initFromJSON(String jsonString){
        if (null == jsonString || jsonString.isEmpty())
            return new Token();//return empty token
        Token t;
        try {
            ObjectMapper mapper = new ObjectMapper();
            t = mapper.readValue(jsonString, Token.class);
        } catch (IOException e) {
            t = new Token();
            t.setToken("");
        }
        return t;
    }
    
}
