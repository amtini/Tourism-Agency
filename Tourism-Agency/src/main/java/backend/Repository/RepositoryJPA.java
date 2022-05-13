package backend.Repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

//TO DO abstract class for use search function on all the subRepositories
public class RepositoryJPA<T> implements Repository<T>{
    protected EntityManager entityManager;
    private Class<T> type;

    public EntityManager getEntityManager(){
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public RepositoryJPA(){
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    public T create(final T t){
        entityManager.persist(t);
        return t;
    }

    public void delete(final Object object){
        entityManager.remove(entityManager.merge(object));
    }  

    public T find(final Object id){
        return (T) entityManager.find(type, id);
    }

    //TO DO getById and specific search
    /*public T getById(Long id){
        return (T) entityManager.stream().filter(t -> t.id == id);
    }

    public List<T> search(String value){

    }*/

    public T upDate(final T t){
        return entityManager.merge(t);
    }

    public Iterable<T> findAll(){
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
        Root<T> root = criteriaQuery.from(type);
        criteriaQuery.select(root);
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public T getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> search(String value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T update(T t) {
        // TODO Auto-generated method stub
        return null;
    }
}