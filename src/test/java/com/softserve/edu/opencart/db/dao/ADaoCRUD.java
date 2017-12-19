package com.softserve.edu.opencart.db.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import com.softserve.edu.opencart.db.entity.IEntity;
import com.softserve.edu.opencart.db.entity.IEntity.QueryNames;
import com.softserve.edu.opencart.tools.exceptions.GeneralException;

abstract class ADaoCRUD<TEntity extends IEntity> extends ADaoRead<TEntity> implements IDaoCRUD<TEntity> {

    protected ADaoCRUD() {
        super();
    }

    // TODO Use Builder
    protected abstract String[] getFields(TEntity entity);

    // Create
    public boolean insert(TEntity entity) {
        boolean result = false;
        Statement statement = null;
        String query = sqlQueries.get(QueryNames.INSERT).toString();
        if (query == null) {
            throw new GeneralException(String.format(QUERY_NOT_FOUND, "INSERT"));
            //throw new RuntimeException(String.format(QUERY_NOT_FOUND, QueryNames.INSERT.name()));
        }
        try {
            statement = getStatement();
            // TODO CHECK!
            result = statement.execute(String.format(query,
                    (Object[]) Arrays.copyOfRange(getFields(entity), 1, getFields(entity).length)));
        } catch (SQLException e) {
            throw new GeneralException(DATABASE_READING_ERROR, e);
            //throw new RuntimeException(DATABASE_READING_ERROR, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                    // TODO Logging Warning
                }
            }
        }
        // TODO result must be return if delete Ok
        return result;
    }

    //
    // Update
    public boolean updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition) {
        boolean result = false;
        Statement statement = null;
        String query = sqlQueries.get(QueryNames.UPDATE_BY_FIELD).toString();
        if (query == null) {
            throw new GeneralException(String.format(QUERY_NOT_FOUND, "UPDATE_BY_FIELD"));
            //throw new RuntimeException(String.format(QUERY_NOT_FOUND, QueryNames.UPDATE_BY_FIELD.name()));
        }
        try {
            statement = getStatement();
            // TODO Use statement.executeUpdate
            result = statement.execute(String.format(query, fieldName, text, fieldCondition, textCondition));
        } catch (SQLException e) {
            throw new GeneralException(DATABASE_READING_ERROR, e);
            //throw new RuntimeException(DATABASE_READING_ERROR, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                    // TODO Logging Warning
                }
            }
        }
        // TODO result must be return if delete Ok
        return result;
    }

    // Delete
    public boolean deleteById(Long id) {
        // System.out.println("\t\t\tdeleteById DONE");
        //System.out.println("*****deleteById START");
        boolean result = false;
        Statement statement = null;
        String query = sqlQueries.get(QueryNames.DELETE_BY_ID).toString();
        if (query == null) {
            throw new GeneralException(String.format(QUERY_NOT_FOUND, "DELETE_BY_ID"));
            //throw new RuntimeException(String.format(QUERY_NOT_FOUND, QueryNames.DELETE_BY_ID.name()));
        }
        try {
            statement = getStatement();
            //System.out.println("*****deleteById Statement Prepared " 
            //        + String.format(query, id) );
            // System.out.println("DAO query: " + String.format(query, id));
            result = statement.execute(String.format(query, id));
            //System.out.println("DAO result : " + result);
            //System.out.println("*****deleteById Statement EXECUTE, QUERY = "
            //        + String.format(query, id) );
        } catch (SQLException e) {
            throw new GeneralException(DATABASE_READING_ERROR, e);
            //throw new RuntimeException(DATABASE_READING_ERROR, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                    // TODO Logging Warning
                }
            }
        }
        // TODO result must be return if delete Ok
        return result;
    }

    public boolean deleteByFieldName(String fieldCondition, String textCondition) {
        //System.out.println("*****deleteByFieldName START");
        boolean result = false;
        Statement statement = null;
        String query = sqlQueries.get(QueryNames.DELETE_BY_FIELD).toString();
        if (query == null) {
            throw new GeneralException(String.format(QUERY_NOT_FOUND, "DELETE_BY_ID"));
            //throw new RuntimeException(String.format(QUERY_NOT_FOUND, QueryNames.DELETE_BY_FIELD.name()));
        }
        try {
            statement = getStatement();
            //System.out.println("*****deleteByFieldName Statement Prepared");
            result = statement.execute(String.format(query, fieldCondition, textCondition));
            //System.out.println("*****deleteByFieldName Statement EXECUTE, QUERY = "
            //        + String.format(query, fieldCondition, textCondition) );
        } catch (SQLException e) {
            throw new GeneralException(DATABASE_READING_ERROR, e);
            //throw new RuntimeException(DATABASE_READING_ERROR, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                    // TODO Logging Warning
                }
            }
        }
        // TODO result must be return if delete Ok
        return result;
    }

    public boolean delete(TEntity entity) {
        return deleteById(entity.getId());
    }

}
