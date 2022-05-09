package backend.Repository;

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
        Type t = getClass().getGenericSuperClass();
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
}