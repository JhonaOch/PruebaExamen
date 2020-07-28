/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ups.edu.ec.modelo.Capitulos;

/**
 *
 * @author enriq
 */
@Stateless
public class CapitulosFacade extends AbstractFacade<Capitulos> {

    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CapitulosFacade() {
        super(Capitulos.class);
    }
    
}
