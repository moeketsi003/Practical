/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.project.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.project.model.Projects;
import za.project.util.APIHelper;

@Controller
@RequestMapping("/Projects/")
public class ProjectsController {
    
    APIHelper<Projects> helper = new APIHelper<>();
 
    @RequestMapping(value="", method = RequestMethod.GET)
    public String listProjects(ModelMap model) {
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        return "ProjectsPage";
    }
 
    @RequestMapping(value="/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
        return "ProjectsPage";
    }
    
    private Projects getProjects(String userToken){
        Projects projects = new Projects();
        try {
            helper.callProjectsAPI(userToken, HttpMethod.GET, "projects", projects.getClass());
        } catch (IOException ex) {
            Logger.getLogger(ProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projects;
    }
 
}