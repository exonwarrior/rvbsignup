/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Class for handling the interaction of Person objects with the database.
 * @author thh21
 */
@Stateless
@LocalBean
public class PersonDAO {

    EntityManagerFactory emf;
    @PersistenceContext(unitName = "MonsterGamePU")
    EntityManager em;

    public PersonDAO() {
    }

    /**
     * 
     * @param person 
     */
    public void persist(Person person) {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");

        em = emf.createEntityManager();
        try {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    /**
     * 
     * @return 
     */
    private ArrayList<Person> getAllPeople() {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");
        em = emf.createEntityManager();
        ArrayList<Person> list = new ArrayList<Person>();
        try {
            em.getTransaction().begin();
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
            list.addAll(query.getResultList()) ;
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        list = getPeoplesArrays(list);
        return list;
    }
    /**
     * 
     * @param people
     * @return 
     */
    public ArrayList<Person> getPeoplesArrays(ArrayList<Person> people){
        ArrayList<Person> list = new ArrayList<Person>();
        for(Person p : people){
            p = getPersonsArrays(p);
            list.add(p);
        }
        return list;
    }
    /**
     * 
     * @param p
     * @return 
     */
    public Person getPersonsArrays(Person p){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");
        em = emf.createEntityManager();
        Person dbPerson = em.find(Person.class, p.getId());
        return dbPerson;
    }
    /**
     * 
     * @param email
     * @return 
     */
    public boolean lookForEmail(String email) {
        boolean answer = false;
        ArrayList<Person> list = this.getAllPeople();
        for (Person p : list) {
            if (p.getEmail() == null ? email == null : p.getEmail().equals(email)) {
                answer = true;
            }
        }
        return answer;
    }
    /**
     * 
     * @param email
     * @return 
     */
    public Person getPersonByEmail(String email) {
        ArrayList<Person> people = getAllPeople();
        Person p = null;
        for(Person person: people){
            if(person.getEmail().equalsIgnoreCase(email)){
                p = person;
            }
        }
        return p;
        
    }
    /**
     * 
     * @param id
     * @return 
     */
    public Person getPersonByID(Long id){
        Person person = null;
        for(Person p: getAllPeople()){
            if(p.getId().equals(id)){
                person = p;
            }
        }
        return person;
    }
   
    /**
     * 
     * @param person 
     */
    public void updatePersonsInfo(Person person){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb"); 
        em = emf.createEntityManager();
        
        Person dbPerson = em.find(Person.class, person.getId());
        
        try{
             em.getTransaction().begin();
             em.getTransaction().commit();
        }
        finally{
             em.close();
        } 
    }
}
