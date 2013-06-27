/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.dao;

import br.com.etec.model.PeriodoLetivo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dfelix3
 */
public class PeriodoLetivoDao extends GenericDao<PeriodoLetivo, Integer> {
    private static final String SITUACAO_ATIVO = "A";
    public PeriodoLetivoDao(){
        super(PeriodoLetivo.class);
    }
    
    /**
     * Get all instances for the specified class.
     *
     * @return a list of managed entity instance
     *
     * @see EntityManager.createQuery, TypedQuery.getReultList
     */
    public List<PeriodoLetivo> listAllActive() {
        EntityManager em = super.entityManager;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PeriodoLetivo> criteriaQuery = cb.createQuery(this.type);
        Root<PeriodoLetivo> root = criteriaQuery.from(this.type);
        
        Predicate ativeCondition = cb.equal(root.get(PeriodoLetivo.PROP_SITUACAO), SITUACAO_ATIVO);
        
        criteriaQuery.where(ativeCondition);
        
        TypedQuery<PeriodoLetivo> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }    
    
    @Override
    protected String getSortField() {
        return "";
    }    
    
}
