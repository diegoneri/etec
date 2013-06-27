/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.dao;

import br.com.etec.model.Disciplina;
import br.com.etec.model.Modulo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author dfelix3
 */
public class DisciplinaDao extends GenericDao<Disciplina, Integer>{
 
    public DisciplinaDao(){
        super(Disciplina.class);
    }
    
    public List<Disciplina> obterDisciplinasPorModulo(Modulo modulo){
        EntityManager em = super.entityManager;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Disciplina> criteriaQuery = cb.createQuery(this.type);
        Root<Disciplina> root = criteriaQuery.from(this.type);
        
        Predicate moduloCondition = cb.equal(root.get("modulo"), modulo);
        
        criteriaQuery.where(moduloCondition);
        
        TypedQuery<Disciplina> query = em.createQuery(criteriaQuery);
        return query.getResultList();        
    }
    
    @Override
    protected String getSortField() {
        return "";
    }    
    
}
