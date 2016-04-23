/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Abdul Halim <13029096@studentmail.ul.ie>
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {

    @PersistenceContext(unitName = "13029096-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    
    public Customer getCustomerById(Integer custId)
    {
        List<Customer> cList = em.createNamedQuery("Customer.findByCustomerId")
                .setParameter("customerId", custId).getResultList();
        
        if(cList.size() > 0){
            return cList.get(0);
        }
        else
            return null;     
    }
    
}
