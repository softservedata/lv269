package com.softserve.edu.opencart.db.dao;

public interface IDaoCRUD<TEntity> extends IDaoRead<TEntity> {

    // Create
    boolean insert(TEntity entity);

    // Update
    boolean updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition);

    // Delete
    boolean deleteById(Long id);

    boolean deleteByFieldName(String fieldCondition, String textCondition);

    boolean delete(TEntity entity);

}
