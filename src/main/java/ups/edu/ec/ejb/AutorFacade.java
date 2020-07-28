/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ups.edu.ec.modelo.Autor;

/**
 *
 * @author enriq
 */
@Stateless
public class AutorFacade extends AbstractFacade<Autor> {

    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutorFacade() {
        super(Autor.class);
    }
    
    public List<Autor>findByName(String name){
        
       String jpql = "FROM Autor c WHERE c.nombre LIKE '" + name + "%'";
        
        //System.out.println("Lista================================== " +  em.createQuery(jpql).getResultList());
        return (List<Autor>) em.createQuery(jpql).getResultList();
    }
}
