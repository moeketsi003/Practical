/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.project.model;

import java.util.Date;

/**
 *
 * @author Mega
 */
public class Projects {
    
    private int pk;
    private String title;
    private String description;
    private Date start_date;
    private Date end_date;
    private boolean is_billable;
    private boolean is_active;
    private Task [] task_set;
    private Resource [] resource_set;
    
    public int getPk(){
        return pk;
    }
    
    public void setPk(int pk){
        this.pk = pk;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public Date getStart_date(){
          return start_date;
      }
      
      public void setStart_date(Date start_date){
          this.start_date = start_date;
      }
      
      public Date getEnd_date(){
          return end_date;
      }
      
      public void setEnd_date(Date end_date){
          this.end_date = end_date;
      }
      
      public boolean getIs_billable(){
          return is_billable;
      }
      
      public void setIs_billable(boolean is_billable){
          this.is_billable = is_billable;
      }
      
      public boolean getIs_active(){
          return is_active;
      }
      
      public void setIs_active(boolean is_active){
          this.is_active = is_active;
      }
      
      public Task[] getTask_set(){
          return task_set;
      }
      
      public void setTask_set(Task[] task_set){
          this.task_set = task_set;
      }
      
      public Resource[] getResource_set(){
          return resource_set;
      }
      
      public void setResource_set(Resource[] resource_set){
          this.resource_set = resource_set;
      }
}
