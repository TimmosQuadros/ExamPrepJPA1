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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author TimmosQuadros
 */
public class Controller {

    private EntityManager em;
    EntityManagerFactory emf;

    public Controller(EntityManagerFactory emf) {
        this.emf = emf;
    }

    void createUser(ProjectUser puser) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(puser);
        em.getTransaction().commit();
        em.close();
    }

    public ProjectUser findUser(Long key) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        ProjectUser pUser = em.find(ProjectUser.class, key);
        em.getTransaction().commit();
        em.close();
        return pUser;
    }

    List<ProjectUser> getAllUsers() {
        try {
            em = emf.createEntityManager();
            return em.createQuery("Select p from projectuser").getResultList();
        } finally {
            em.close();
        }
    }

    void createProject(Project p) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    void assignUserToProject(Project p, ProjectUser pUser) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        p.addUser(pUser);
        em.merge(p);
        em.getTransaction().commit();
        em.close();
    }

    public Project findProject(Long key) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Project p = em.find(Project.class, key);
        em.getTransaction().commit();
        em.close();
        return p;
    }

    void createTask(Task t, Project p) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        t.setProject(p);
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }

}
