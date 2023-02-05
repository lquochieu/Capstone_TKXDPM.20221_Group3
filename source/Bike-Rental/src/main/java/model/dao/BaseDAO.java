package model.dao;

import java.util.List;

/**
 * class interact with database
 * @author Group 3
 * @param <T>
 */
public interface BaseDAO<T> {
    /**
     * get all Object from database
     *
     * @return a List of Object
     */
    List<T> getAll();

    /**
     * get Object from database by Id
     *
     * @param id id of object
     * @return Object
     */
    T getByID(int id);

    /**
     * save object to database
     *
     * @param t object t
     */
    int save(T t);

    /**
     * update an existed object to database
     * @param t obbject
     */


    /**
     * remove an object in database
     *
     * @param t object
     */
    void delete(T t);
}