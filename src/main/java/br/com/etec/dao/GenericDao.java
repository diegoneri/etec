package br.com.etec.dao;

import br.com.etec.util.dao.EteAb01EntityManager;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

/**
 * This class provides generic methods that maintains and get data from
 * database.
 *
 * @author dfelix3
 *
 * @param an entity class
 */
@Repository
public abstract class GenericDao<T,K> {

    @PersistenceContext(name="eteab01PU")
    protected EntityManager entityManager;
    protected Class<T> type;

    public GenericDao(final Class<T> clazz) {
        this.type = clazz;
        this.entityManager = EteAb01EntityManager.getEntityManager();
    }

    /**
     * Gets the default ordering of the type Hook method to be implemented to
     * the child class.
     *
     * @return list of Order
     */
    //protected abstract List<Order> getDefaultOrdering(CriteriaBuilder cb);
    /**
     * Make an instance managed and persistent.
     *
     * @param entity - entity instance
     * @return a managed entity instance
     *
     * @see EntityManager.persist
     */
    public T create(final T entity) {
        this.entityManager.persist(entity);
        this.entityManager.flush();
        return entity;
    }

    public List<T> createAll(final List<T> entities) {
        List<T> newList = new ArrayList<>();
        this.entityManager.getTransaction().begin();
        for (T t : entities) {
            create(t);
            newList.add(t);
        }
        this.entityManager.getTransaction().commit();
        return newList;
    }
  
    /**
     * Delete the managed entity instance.
     *
     * @param id - entity identifier
     *
     * @see EntityManager.remove
     */
    public void delete(final T entity) {
        this.entityManager.remove(entity);
    }

    /**
     * Delete the managed entity instance.
     *
     * @param id - entity identifier
     *
     * @see EntityManager.remove
     */
    public void deleteById(final K id) {
        this.entityManager.remove(this.getReference(id));
    }

    /**
     * Find by primary key. Search for an entity of the specified class and
     * primary key. If the entity instance is contained in the persistence
     * context, it is returned from there.
     *
     * @param id - entity identifier
     * @return the found entity instance or null if the entity does not exist
     *
     * @see EntityManager.find
     */
    public T find(final K id) {
        return this.entityManager.find(this.type, id);
    }

    public T findOut(final K id){
        String hql = "select o from "+ this.type.getSimpleName() + " as o WHERE o.id = :id";
        
        TypedQuery<T> query = entityManager.createQuery(hql, this.type);
        query.setParameter("id", id);
        
        return query.getSingleResult();
    }
    
    protected String getIdField(){
        return "id";
    }
    
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public T getReference(final K id) {
        return this.entityManager.getReference(this.type, id);
    }

    public boolean isManaged(final T o) {
        return this.entityManager.contains(o);
    }

    /**
     * Get all instances for the specified class.
     *
     * @return a list of managed entity instance
     *
     * @see EntityManager.createQuery, TypedQuery.getReultList
     */
    public List<T> listAll() {
        return this.listAll(-1, -1);
    }

    protected abstract String getSortField();
    
    public List<T> listAll(int pageSize, int page) {
        EntityManager em = this.entityManager;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = 
                        cb.createQuery(this.type);
        Root<T> root = criteriaQuery.from(this.type);

        criteriaQuery = criteriaQuery.select(root);
        
        if (!getSortField().trim().equals("")) {
            criteriaQuery.orderBy(cb.asc(root.get(getSortField())));    
        }
        
        TypedQuery<T> query = em.createQuery(criteriaQuery);
        if (page > -1) {
            query.setFirstResult((page - 1) * pageSize);
            query.setMaxResults(pageSize);
        }

        return query.getResultList();
    }

    public int getCount() {
        String query = "select count(o) from "+ this.type.getSimpleName() + " as o";
        Query q = entityManager.createQuery(query);
        return ((Long) q.getSingleResult()).intValue();
    }

    /**
     * Refresh the state of the instance from the database, overwriting changes
     * made to the entity, if any.
     *
     * @param entity - managed entity instance
     *
     * @see EntityManager.refresh
     */
    public void refresh(final T entity) {
        this.entityManager.refresh(entity);
    }

    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Merge the state of the given entity into the current persistence context.
     *
     * @param entity - entity instance
     * @return a managed entity instance
     *
     * @see EntityManager.merge
     */
    public T update(final T entity) {
        return this.entityManager.merge(entity);
    }   
 
    public List<T> updateAll(final List<T> entities) {
        List<T> newList = new ArrayList<>();
        this.entityManager.getTransaction().begin();
        for (T t : entities) {
            update(t);
            newList.add(t);
        }
        this.entityManager.getTransaction().commit();
        return newList;
    }    
    
    public void flush(){
        this.entityManager.flush();
    }
}