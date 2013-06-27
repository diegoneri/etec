/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.dao;

import br.com.etec.model.Atribuicao;
import br.com.etec.model.PeriodoLetivo;
import br.com.etec.model.Turma;
import java.util.ArrayList;
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
public class AtribuicaoDao extends GenericDao<Atribuicao, Integer> {
    
    public AtribuicaoDao() {
        super(Atribuicao.class);
    }
    
    @Override
    public Atribuicao create(final Atribuicao entity) {
        if (entity.hasSubstituicao()) {
            super.create(entity.getAtribuicaoSubstituicao());
        } else {
            entity.setAtribuicaoSubstituicao(null);
        }
        super.create(entity);
        
        return entity;
    }
    
    public List<Atribuicao> reinsertAll(final List<Atribuicao> entities) {
        List<Atribuicao> updatedList = new ArrayList<>();
        this.entityManager.getTransaction().begin();
        for (Atribuicao t : entities) {
            deleteAndRemoveReference(t);
        }
        flush();
        for (Atribuicao t : entities) {       
            create(t);
            updatedList.add(t);
        }        
        this.entityManager.getTransaction().commit();
        return updatedList;
    }
    
    private void deleteAndRemoveReference(Atribuicao t) {
        if (t.hasSubstituicao()) {
            Atribuicao atrSub = t.getAtribuicaoSubstituicao();
            deleteAndRemoveReference(atrSub);
        }
        delete(t);
        flush();
        t.setNullId();       
    }
    
    public List<Atribuicao> listAllByTurmaPeriodoLetivo(Turma turma, PeriodoLetivo periodoLetivo) {
        EntityManager em = this.entityManager;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Atribuicao> criteriaQuery =
                cb.createQuery(this.type);
        Root<Atribuicao> root = criteriaQuery.from(this.type);
        
        criteriaQuery = criteriaQuery.select(root);
        
        Predicate turmaPredicate = cb.equal(root.get("turma"), turma);
        Predicate periodoLetivoPredicate = cb.equal(root.get("periodoLetivo"), periodoLetivo);
        Predicate andPredicate = cb.and(turmaPredicate, periodoLetivoPredicate);
        
        criteriaQuery = criteriaQuery.where(andPredicate);
        
        TypedQuery<Atribuicao> query = em.createQuery(criteriaQuery);
        
        return query.getResultList();
    }
    
    @Override
    protected String getSortField() {
        return "";
    }
    
    @Override
    public List<Atribuicao> updateAll(final List<Atribuicao> entities) {
        List<Atribuicao> newList = new ArrayList<>();
        this.entityManager.getTransaction().begin();

        for (Atribuicao newAtribuicao : entities) {
            updateAll_(newAtribuicao, newList);
        }
        this.entityManager.getTransaction().commit();
        return newList;
    }    

    private void updateAll_(final Atribuicao newAtribuicao, List<Atribuicao> newList) {
        this.entityManager.detach(newAtribuicao);
        Atribuicao oldAtribuicao = this.getReference(newAtribuicao.getId());
        if (newAtribuicao.hasSubstituicao() && !oldAtribuicao.hasSubstituicao() ) {
            create(newAtribuicao.getAtribuicaoSubstituicao());
        }else if (!newAtribuicao.hasSubstituicao() && oldAtribuicao.hasSubstituicao()) {
            delete(oldAtribuicao.getAtribuicaoSubstituicao());
        }
        update(newAtribuicao);
        newList.add(newAtribuicao);
    }
    
}
