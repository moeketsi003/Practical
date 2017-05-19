/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.project.model.Projects;
import za.project.model.Token;
import za.project.model.User;
import za.project.util.APIHelper;

/**
 *
 * @author Mega
 */

@Controller
@RequestMapping("/")
public class LoginController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String showLogin(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "LoginPage";
    }
 
    @RequestMapping(method = RequestMethod.POST)
    public String authenticate(@Valid User user, BindingResult result, ModelMap model) {
        if(result.hasErrors()) {
            return "LoginPage";
        }
        
        Token userToken;
        try {
            userToken = APIHelper.getToken(user);
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            model.addAttribute("message", ex.getMessage());
            return "LoginPage";
        }
        if (userToken == null){
            model.addAttribute("message", "Username or password not recognised. Please try again.");
            return "LoginPage";
        }
        
        try {
            String pro = APIHelper.callProjectsAPI(userToken.getToken(), HttpMethod.GET, "projects");
                    
            model.addAttribute("message", "Welcome to the ProjectList UI");
            model.addAttribute("token", userToken.getToken());
            model.addAttribute("projects", pro);
            
            return "ProjectsPage";
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            model.addAttribute("message", "An error occured while navigating to projects: " + ex.getMessage());
            return "LoginPage";
        }
        
    }
    
}
