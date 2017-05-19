/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.util.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpMethod;
import za.project.model.Projects;
import za.project.model.Token;
import za.project.model.User;
import za.project.util.APIHelper;

/**
 *
 * @author Mega
 */
public class TestUtil {
    
    public static void main(String [] args){
        try {
            User u = new User();
            List<Projects> projects = new ArrayList<>();
            APIHelper<List<Projects>> pHelper = new APIHelper<>();
            String users = "";
            //APIHelper<String> uHelper = new APIHelper<>();
            u.setUsername("jacob.zuma");
            u.setPassword("tangent");
            Token newToken = APIHelper.getToken(u);
            projects = pHelper.callProjectsAPI(newToken.getToken(), HttpMethod.GET, "projects", projects.getClass());
            System.out.println(projects);
            //uHelper.callUserAPI(newToken.getToken(), HttpMethod.GET, "users", users);
            //System.out.println(users);
        } catch (IOException ex) {
            Logger.getLogger(TestUtil.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (Exception ex) {
            Logger.getLogger(TestUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
