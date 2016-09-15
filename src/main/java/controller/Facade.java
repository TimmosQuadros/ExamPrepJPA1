/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Project;
import entity.ProjectUser;
import entity.Task;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author TimmosQuadros
 */
public class Facade {
    
    EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    Controller cr = new Controller(emf);

    public void createUser(ProjectUser puser){
        cr.createUser(puser);
    }
    
    public ProjectUser findUser(Long key){
        return cr.findUser(key);
    }
    
    public List<ProjectUser> getAllUsers(){
        return cr.getAllUsers();
    }
    
    public void createProject(Project p){
        cr.createProject(p);
    }
    
    public void assignUserToProject(Project p, ProjectUser pUser){
        cr.assignUserToProject(p,pUser);
    }
    
    public Project findProject(Long key){
        return cr.findProject(key);
    }
    
    public void createTask(Task t,Project p){
        cr.createTask(t,p);
    }
    
    
}
