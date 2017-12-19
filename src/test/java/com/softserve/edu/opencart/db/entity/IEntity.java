package com.softserve.edu.opencart.db.entity;

public interface IEntity {

    public static enum QueryNames {
        INSERT,
        GET_BY_ID,
        GET_BY_FIELD,
        GET_ALL,
        UPDATE_BY_FIELD,
        DELETE_BY_ID,
        DELETE_BY_FIELD;
    }

    Long getId();

}
