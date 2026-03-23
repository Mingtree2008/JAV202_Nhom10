package DAO;



import java.util.List;

public interface CrudDAO<T, K> {
    void insert(T entity);
    void update(T entity);
    void delete(K id);
    T findById(K id);
    List<T> findAll();
}
